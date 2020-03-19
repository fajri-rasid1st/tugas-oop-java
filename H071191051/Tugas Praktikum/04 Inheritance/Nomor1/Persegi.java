class Persegi extends BangunDatar {

    public Persegi(double sisi) {
        super(sisi);
    }

    @Override
    public double getKeliling() {
        return 4 * getSisi();
    }

    @Override
    public double getLuas() {
        return getSisi() * getSisi();
    }
}