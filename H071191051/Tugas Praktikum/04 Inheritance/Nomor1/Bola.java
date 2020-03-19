class Bola extends BangunRuang {
    private double r;

    public Bola(double r) {
        this.r = r;
    }

    @Override
    public double getLuasPermukaan() {
        return 4 * Math.PI * Math.pow(r, 2);
    }

    @Override
    public double getVolume() {
        return (4 * Math.PI * Math.pow(r, 3)) / 3;
    }
}