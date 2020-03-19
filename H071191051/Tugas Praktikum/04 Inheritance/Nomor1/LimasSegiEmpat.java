class LimasSegiEmpat extends BangunRuang {
    private double ls, la, t;

    public LimasSegiEmpat(double ls, double la, double t) {
        this.ls = ls;
        this.la = la;
        this.t = t;
    }

    @Override
    public double getLuasPermukaan() {
        return (4 * ls) + la;
    }

    @Override
    public double getVolume() {
        return (la * t) / 3;
    }
}