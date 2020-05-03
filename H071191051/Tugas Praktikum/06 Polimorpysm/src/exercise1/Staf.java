package exercise1;

class Staf extends Employee {
    private int attendance;

    Staf(String name, int attendance) {
        super(name);
        this.attendance = attendance;
    }

    @Override
    public int getSalary() {
        return salary + (attendance * 50000);
    }
}