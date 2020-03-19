class Tabung extends BangunRuang {
    private double r, t;

    public Tabung(double r, double t) {
        this.r = r;
        this.t = t;
    }

    @Override
    public double getLuasPermukaan() {
        return (2 * Math.PI * r * t) + (2 * Math.PI * Math.pow(r, 2));
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(r, 2) * t;
    }
}