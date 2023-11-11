package ReflectionAndAnnotations_Exercise_07.BarracksWars_03;

import ReflectionAndAnnotations_Exercise_07.BarracksWars_03.core.Engine;
import ReflectionAndAnnotations_Exercise_07.BarracksWars_03.core.factories.UnitFactoryImpl;
import ReflectionAndAnnotations_Exercise_07.BarracksWars_03.data.UnitRepository;
import ReflectionAndAnnotations_Exercise_07.BarracksWars_03.interfaces.Repository;
import ReflectionAndAnnotations_Exercise_07.BarracksWars_03.interfaces.Runnable;
import ReflectionAndAnnotations_Exercise_07.BarracksWars_03.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
