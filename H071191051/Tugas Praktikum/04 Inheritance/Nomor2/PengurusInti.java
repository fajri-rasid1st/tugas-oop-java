import java.util.*;

class PengurusInti extends Anggota {

    public PengurusInti() {

    }

    public PengurusInti(String name, String dateOfBirth, String nim) {
        super(name, dateOfBirth, nim);
    }

    public void setPengurusIntiList(Map<Integer, String> positionList) {
        positionList.put(1, "Ketua");
        positionList.put(2, "Wakil Ketua");
        positionList.put(3, "Sekretaris");
        positionList.put(4, "Bendahara");
    }
}