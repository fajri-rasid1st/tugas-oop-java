class Kerucut extends BangunRuang {
    private double r, s, t;

    public Kerucut(double r, double s, double t) {
        this.r = r;
        this.s = s;
        this.t = t;
    }

    @Override
    public double getLuasPermukaan() {
        return (Math.PI * r * s) + (Math.PI * Math.pow(r, 2));
    }

    @Override
    public double getVolume() {
        return (Math.PI * Math.pow(r, 2) * t) / 3;
    }
}