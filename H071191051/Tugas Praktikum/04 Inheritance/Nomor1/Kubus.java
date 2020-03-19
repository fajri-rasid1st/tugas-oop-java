class Kubus extends BangunRuang {
    private double r;

    public Kubus(double r) {
        this.r = r;
    }

    @Override
    public double getLuasPermukaan() {
        return 6 * Math.pow(r, 2);
    }

    @Override
    public double getVolume() {
        return Math.pow(r, 3);
    }
}