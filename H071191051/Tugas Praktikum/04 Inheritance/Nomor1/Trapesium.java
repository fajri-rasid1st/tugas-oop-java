class Trapesium extends BangunDatar {

    public Trapesium(double sisiAtas, double sisiBawah, double sisiMiring, double tinggi) {
        super(sisiAtas, sisiBawah, sisiMiring, tinggi);
    }

    @Override
    public double getKeliling() {
        return getSisi() + getSisi2() + getSisi3() + getSisi4();
    }

    @Override
    public double getLuas() {
        return ((getSisi() + getSisi2()) * getSisi4()) / 2;
    }
}