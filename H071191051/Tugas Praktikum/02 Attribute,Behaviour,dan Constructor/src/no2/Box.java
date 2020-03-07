package no2;

class Box {
    private double width;
    private double height;
    private double depth;
    private double mass;
    //private double density;


    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setDepth(double depth) {
        this.depth = depth;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public double getDensity() {
        return (mass/(width*height*depth));
    }

    public Box(double width, double height, double depth) {
        setWidth(width);
        setHeight(height);
        setDepth(depth);
    }
}