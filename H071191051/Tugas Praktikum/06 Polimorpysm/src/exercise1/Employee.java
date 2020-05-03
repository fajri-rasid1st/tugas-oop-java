package exercise1;

class Employee {
    private String name;
    protected final int salary = 2500000;

    Employee(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void myInfo() {
        System.out.printf("%s mendapatkan gaji Rp. %d", name, getSalary());
    }
}