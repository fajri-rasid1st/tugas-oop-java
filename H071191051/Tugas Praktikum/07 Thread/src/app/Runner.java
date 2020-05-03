package app;

public class Runner implements Runnable {
    private Integer number;
    private Thread thread;
    private Race race;

    Runner(Integer number) {
        this.number = number;
        thread = new Thread(this); // this = equals to "new Runner(number)""
    }

    public Runner joinRace(Race race) {
        if (this.race == null) {
            this.race = race;
            race.totalRunner++;
        }
        return this;
    }

    public void start() {
        try {
            joinRace(race);
            if (!race.isRaceStarted) {
                System.out.printf("Hey %s, the race hasn't started yet\n", getNumber());
            } else {
                thread.start();
            }
        } catch (NullPointerException npe) {
            System.out.printf("%s have not entered any race\n", getNumber());
        }
    }

    public String getNumber() {
        return String.format("Runner -%d", number);
    }

    @Override
    public void run() {
        System.out.printf("%s running . . .\n", getNumber());
        try {
            Thread.sleep(race.durationRace);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        race.position.add(getNumber());
    }
}