class PrismaSegitiga extends BangunRuang {
    private double ls, la, t;

    public PrismaSegitiga(double ls, double la, double t) {
        this.ls = ls;
        this.la = la;
        this.t = t;
    }

    @Override
    public double getLuasPermukaan() {
        return (3 * ls) + (2 * la);
    }

    @Override
    public double getVolume() {
        return (la * t) / 2;
    }
}