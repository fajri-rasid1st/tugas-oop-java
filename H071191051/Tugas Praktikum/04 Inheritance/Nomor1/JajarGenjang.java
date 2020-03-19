class JajarGenjang extends BangunDatar {

    public JajarGenjang(double alas, double tinggi, double sisiMiring) {
        super(alas, tinggi, sisiMiring);
    }

    @Override
    public double getKeliling() {
        return 2 * (getSisi() + getSisi3());
    }

    @Override
    public double getLuas() {
        return getSisi() * getSisi2();
    }
}