package no2;

class Rectangle {
    double height;
    double width;

    double getArea() {
        //lengkapi
        return 0.5 * width * height;
    }
}
public class Main {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        //lengkapi
        rec.height = 10;
        rec.width = 3;
        System.out.println("Luas = " + rec.getArea());
    }
}