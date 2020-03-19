class Segitiga extends BangunDatar {

    public Segitiga(double sisi, double sisi2, double sisi3) {
        super(sisi, sisi2, sisi3);
    }

    @Override
    public double getKeliling() {
        return getSisi() + getSisi2() + getSisi3();
    }

    @Override
    public double getLuas() {
        return (getSisi() * getSisi2()) / 2;
    }
}