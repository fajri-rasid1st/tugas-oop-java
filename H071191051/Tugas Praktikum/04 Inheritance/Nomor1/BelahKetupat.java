class BelahKetupat extends BangunDatar {

    public BelahKetupat(double sisi, double diagonal1, double diagonal2) {
        super(sisi, diagonal1, diagonal2);
    }

    @Override
    public double getKeliling() {
        return 4 * getSisi();
    }

    @Override
    public double getLuas() {
        return (getSisi2() * getSisi3()) / 2;
    }
}