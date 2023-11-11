package ReflectionAndAnnotations_Exercise_07.BarracksWars_03.core.factories;

import ReflectionAndAnnotations_Exercise_07.BarracksWars_03.interfaces.Unit;
import ReflectionAndAnnotations_Exercise_07.BarracksWars_03.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "ReflectionAndAnnotations_Exercise_07.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class clazz = Class.forName("ReflectionAndAnnotations_Exercise_07.barracksWars.models.units." + unitType);
            Constructor<Unit> constructor = clazz.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            e.getMessage();
        }

        return null;
    }
}
