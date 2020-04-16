package exercise;

public class ConverterDistance extends Converter implements Distance {

    @Override
    void start() {
        System.out.println(getClass().getSimpleName() + " is started");
    }

    @Override
    void stop() {
        System.out.println(getClass().getSimpleName() + " is terminated");
    }

    @Override
    public double metreToKilo(double value) {
        return value * 0.001;
    }

    @Override
    public double metreToMilli(double value) {
        return value * 1000;
    }

    @Override
    public double inchToMetre(double value) {
        return value * 0.0254;
    }
}