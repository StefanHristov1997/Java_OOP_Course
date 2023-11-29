package magicGame.models.region;

import magicGame.models.magicians.Magician;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> wizards = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("Wizard")).collect(Collectors.toList());
        List<Magician> blackWidows = magicians.stream().filter(magician -> magician.getClass().getSimpleName().equals("BlackWidow")).collect(Collectors.toList());

        while (!wizards.isEmpty() && !blackWidows.isEmpty()) {
            for (Magician wizard : wizards) {
                if (wizard.getMagic().fire() == 0) {
                    continue;
                }

                Magician blackWidow = blackWidows.get(0);
                if (wizard.getMagic().getClass().getSimpleName().equals("RedMagic")) {
                    blackWidow.takeDamage(1);
                } else if (wizard.getMagic().getClass().getSimpleName().equals("BlackMagic")) {
                    blackWidow.takeDamage(10);
                }

                if (!blackWidow.isAlive()) {
                    blackWidows.remove(blackWidow);
                }

            }

            for (Magician blackWidow : blackWidows) {
                if (blackWidow.getMagic().fire() == 0) {
                    continue;
                }
                Magician wizard = wizards.get(0);
                if (blackWidow.getMagic().getClass().getSimpleName().equals("RedMagic")) {
                    wizard.takeDamage(1);
                } else if (blackWidow.getMagic().getClass().getSimpleName().equals("BlackMagic")) {
                    wizard.takeDamage(10);
                }

                if (!wizard.isAlive()) {
                    wizards.remove(wizard);
                }
            }
        }

        if (blackWidows.isEmpty()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }

    }
}
