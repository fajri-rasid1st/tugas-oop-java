class Layangan extends BangunDatar {

    public Layangan(double sisi1, double sisi2, double diagonal1, double diagonal2) {
        super(sisi1, sisi2, diagonal1, diagonal2);
    }

    @Override
    public double getKeliling() {
        return 2 * (getSisi() + getSisi2());
    }

    @Override
    public double getLuas() {
        return (getSisi3() * getSisi4()) / 2;
    }
}