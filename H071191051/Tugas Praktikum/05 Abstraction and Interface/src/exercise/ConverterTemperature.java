package exercise;

public class ConverterTemperature extends Converter implements Temperature {

    @Override
    void start() {
        System.out.println(getClass().getSimpleName() + " is started");
    }

    @Override
    void stop() {
        System.out.println(getClass().getSimpleName() + " is terminated");
    }

    @Override
    public double celciusToFahrenheit(double value) {
        return (9 * value / 5) + 32;
    }

    @Override
    public double celciusToKelvin(double value) {
        return value + 273.15;
    }
}