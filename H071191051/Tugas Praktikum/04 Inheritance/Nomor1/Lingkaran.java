class Lingkaran extends BangunDatar {

    public Lingkaran(double jari_jari) {
        super(jari_jari);
    }

    @Override
    public double getKeliling() {
        return 2 * Math.PI * getSisi();
    }

    @Override
    public double getLuas() {
        return Math.PI * getSisi() * getSisi();
    }
}