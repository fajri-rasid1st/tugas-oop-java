package exercise1;

class Dosen extends Employee {
    private int sks;

    Dosen(String name, int sks) {
        super(name);
        this.sks = sks;
    }

    @Override
    public int getSalary() {
        return salary + (sks * 120000);
    }
}