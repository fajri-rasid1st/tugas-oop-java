package no1;

public class Main {
    public static void main(String[] args) {
        Person ps = new Person();
        ps.setName("Takdim");
        ps.setAge(21);
        ps.setGender(false);
        System.out.printf("Nama \t: %s\nUmur \t: %d tahun\nGender \t: %s",ps.getName(),ps.getAge(),ps.getGender());
    }
}