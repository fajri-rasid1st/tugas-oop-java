class Balok extends BangunRuang {
    private double p, l, t;

    public Balok(double p, double l, double t) {
        this.p = p;
        this.l = l;
        this.t = t;
    }

    @Override
    public double getLuasPermukaan() {
        return (2 * p * l) + (2 * p * t) + (2 * l * t);
    }

    @Override
    public double getVolume() {
        return p * l * t;
    }
}