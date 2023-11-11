package ReflectionAndAnnotations_Exercise_07.BarracksWars_03.interfaces;

public interface CommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
