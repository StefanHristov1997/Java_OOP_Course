package robotService.core;

import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.INVALID_ROBOT_TYPE;
import static robotService.common.ExceptionMessages.NO_SUPPLEMENT_FOUND;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        if (!type.equals("MainService") && !type.equals("SecondaryService")) {
            throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }

        switch (type) {
            case "MainService":
                Service mainService = new MainService(name);
                services.add(mainService);
                break;
            case "SecondaryService":
                Service secondaryService = new SecondaryService(name);
                services.add(secondaryService);
                break;
        }

        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        if (!type.equals("PlasticArmor") && !type.equals("MetalArmor")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        switch (type) {
            case "PlasticArmor":
                Supplement plasticArmor = new PlasticArmor();
                supplements.addSupplement(plasticArmor);
                break;
            case "MetalArmor":
                Supplement metalArmor = new MetalArmor();
                supplements.addSupplement(metalArmor);
                break;
        }

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);

    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplementToAdd = supplements.findFirst(supplementType);

        if (supplementToAdd == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        Service service = services.stream().filter(service1 -> service1.getName().equals(serviceName)).findFirst().get();
        service.addSupplement(supplementToAdd);
        supplements.removeSupplement(supplementToAdd);
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        if (!robotType.equals("MaleRobot") && !robotType.equals("FemaleRobot")) {
            throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }

        Robot robot;

        if (robotType.equals("MaleRobot")) {
            robot = new MaleRobot(robotName, robotKind, price);
        } else {
            robot = new FemaleRobot(robotName, robotKind, price);
        }

        Service service = services.stream().filter(service1 -> service1.getName().equals(serviceName)).findFirst().get();

        if (robotType.equals("MaleRobot") && service.getClass().getSimpleName().equals("MainService")) {
            service.addRobot(robot);
            return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
        } else if (robotType.equals("FemaleRobot") && service.getClass().getSimpleName().equals("SecondaryService")) {
            service.addRobot(robot);
            return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
        } else {
            return UNSUITABLE_SERVICE;
        }
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = services.stream().filter(service1 -> service1.getName().equals(serviceName)).findFirst().get();
        service.feeding();
        int countFedRobots = service.getRobots().size();
        return String.format(FEEDING_ROBOT, countFedRobots);
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = services.stream().filter(service1 -> service1.getName().equals(serviceName)).findFirst().get();
        double sumRobotsPrice = service.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        double sumSupplementsPrice = service.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();
        double sumOfAll = sumRobotsPrice + sumSupplementsPrice;

        return String.format(VALUE_SERVICE, serviceName, sumOfAll);
    }

    @Override
    public String getStatistics() {
        return services.stream().map(Service::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }
}
