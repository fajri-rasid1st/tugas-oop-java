package exercise;

public class ConverterData extends Converter implements Data {

    @Override
    void start() {
        System.out.println(getClass().getSimpleName() + " is started");
    }

    @Override
    void stop() {
        System.out.println(getClass().getSimpleName() + " is terminated");
    }

    @Override
    public long teraToGiga(long value) {
        return value * 1024L;
    }

    @Override
    public long teraToMega(long value) {
        return value * 1048576L;
    }

    @Override
    public long teraToKilo(long value) {
        return value * 1073741824L;
    }
}