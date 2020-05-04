package app;

class Main {
    public static void main(String[] args) {
        Integer number = 0;

        Race race = new Race();
        Runner[] runners = new Runner[10];

        for (int i = 0; i < runners.length; i++) {
            runners[i] = new Runner(++number);
            runners[i].joinRace(race); // beri comment pada baris ini untuk kondisi Jika method Race::start()
                                       // dipanggil, namun jumlah peserta belum mencukupi.
        }

        race.start(); // beri comment pada baris ini untuk kondisi Runner telah mengikuti Race, namun
                      // Race yang diikuiti belum dimulai.

        for (Runner runner : runners) {
            runner.start();
        }

        race.result();
    }
}