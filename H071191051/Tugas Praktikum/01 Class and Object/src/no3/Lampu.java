package no3;

class Lampu {
    boolean blueIson;
    Boolean redIsOn;

    void turnOn() {
        blueIson = true;
        redIsOn = true;
    }
    void turnOff() {
        blueIson = false;
        redIsOn = false;
    }
    void getState() {
        if(blueIson && redIsOn) {
            System.out.println("Lampu Sedang Menyala");
        }else {
            System.out.println("Lampu Sedang Mati");
        }
    }
}