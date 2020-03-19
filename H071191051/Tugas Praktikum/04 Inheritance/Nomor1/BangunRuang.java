public class BangunRuang {

    public double getLuasPermukaan() {
        return 0;
    }

    public double getVolume() {
        return 0;
    }

    public void show() {
        if (getLuasPermukaan() == (int) getLuasPermukaan()) {
            System.out.println("Luas Permukaan  : " + (int) getLuasPermukaan());
        } else {
            System.out.printf("Luas Permukaan  : %.02f\n", getLuasPermukaan());
        }
        if (getVolume() == (int) getVolume()) {
            System.out.println("Volume          : " + (int) getVolume());
        } else {
            System.out.printf("Volume          : %.02f\n", getVolume());
        }
    }
}