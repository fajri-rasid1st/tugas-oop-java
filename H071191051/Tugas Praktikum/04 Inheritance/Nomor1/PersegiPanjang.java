class PersegiPanjang extends BangunDatar {

    public PersegiPanjang(double sisi, double sisi2) {
        super(sisi, sisi2);
    }

    @Override
    public double getKeliling() {
        return 2 * (getSisi() + getSisi2());
    }

    @Override
    public double getLuas() {
        return getSisi() * getSisi2();
    }
}