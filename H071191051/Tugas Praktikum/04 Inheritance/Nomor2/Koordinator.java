import java.util.*;

class Koordinator extends Anggota {

    public Koordinator() {

    }

    public Koordinator(String name, String dateOfBirth, String nim) {
        super(name, dateOfBirth, nim);
    }

    public void setKoordinatorList(Map<Integer, String> positionList) {
        positionList.put(5, "Kordinator Bidang Advertising");
        positionList.put(6, "Kordinator Bidang Sosial Media");
        positionList.put(7, "Kordinator Bidang Event");
        positionList.put(8, "Staf Penasihat");
        positionList.put(9, "Staf Pelayanan");
    }
}