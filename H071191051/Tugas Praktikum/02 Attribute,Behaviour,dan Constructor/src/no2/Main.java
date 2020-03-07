package no2;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double width = sc.nextDouble();
        double height = sc.nextDouble();
        double depth = sc.nextDouble();
        double mass = sc.nextDouble();
        Box box = new Box(width, height, depth);
        box.setMass(mass);
        System.out.println("Massa jenis = " + box.getDensity());
        box.setMass(mass*2);
        System.out.println("Massa jenis = " + box.getDensity());
        
        sc.close();
    }
}