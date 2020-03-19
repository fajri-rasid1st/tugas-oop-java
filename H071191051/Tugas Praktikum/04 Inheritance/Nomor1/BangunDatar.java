class BangunDatar {
    private double sisi;
    private double sisi2;
    private double sisi3;
    private double sisi4;

    public BangunDatar(double sisi) {
        this.sisi = sisi;
    }

    public BangunDatar(double sisi, double sisi2) {
        this.sisi = sisi;
        this.sisi2 = sisi2;
    }

    public BangunDatar(double sisi, double sisi2, double sisi3) {
        this.sisi = sisi;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
    }

    public BangunDatar(double sisi, double sisi2, double sisi3, double sisi4) {
        this.sisi = sisi;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
        this.sisi4 = sisi4;
    }

    public double getKeliling() {
        return 0;
    }

    public double getLuas() {
        return 0;
    }

    public double getSisi() {
        return sisi;
    }

    public double getSisi2() {
        return sisi2;
    }

    public double getSisi3() {
        return sisi3;
    }

    public double getSisi4() {
        return sisi4;
    }

    public void show() {
        if (getKeliling() == (int) getKeliling()) {
            System.out.println("Keliling    : " + (int) getKeliling());
        } else {
            System.out.printf("Keliling    : %.02f\n", getKeliling());
        }
        if (getLuas() == (int) getLuas()) {
            System.out.println("Luas        : " + (int) getLuas());
        } else {
            System.out.printf("Luas        : %.02f\n", getLuas());
        }
    }
}