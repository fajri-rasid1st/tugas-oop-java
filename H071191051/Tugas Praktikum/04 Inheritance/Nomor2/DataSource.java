import java.io.*;
import java.text.ParseException;
import java.util.*;

class DataSource {

    public void mainMenu() throws IOException, ParseException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        Map<Character, String> facultyMap = new HashMap<Character, String>();
        Map<Integer, String> positionList = new HashMap<Integer, String>();
        PengurusInti p = new PengurusInti();
        Koordinator k = new Koordinator();

        facultyMap.put('A', "Kedokteran");
        facultyMap.put('B', "Farmasi");
        facultyMap.put('C', "Teknik");
        facultyMap.put('D', "Kehutanan");
        facultyMap.put('E', "Pertanian");
        facultyMap.put('F', "Keperawanan");
        facultyMap.put('G', "Kesehatan Masyarakat");
        facultyMap.put('H', "MIPA");

        p.setPengurusIntiList(positionList);
        k.setKoordinatorList(positionList);

        String pi = "";
        String ks = "";
        while (true) {
            initialDisplay();
            System.out.print("> ");
            int key = sc.nextInt();
            if (key == 0) {
                break;
            } else if (key == 1) {
                if (pi.equals("")) {
                    System.out.println("\nBelum ada yang mendaftar sebagai pengurus inti");
                } else {
                    System.out.println(pi);
                }
            } else if (key == 2) {
                if (ks.equals("")) {
                    System.out.println("\nBelum ada yang mendaftar sebagai kordinator/staf");
                } else {
                    System.out.println(ks);
                }
            } else if (key == 9) {
                System.out.print("Nama          : ");
                String name = sc.next() + sc.nextLine();
                System.out.print("Tanggal lahir : ");
                String date = sc.next();
                System.out.print("NIM           : ");
                String nim = sc.next();
                positionListMenu();
                System.out.print("Jabatan yang diinginkan : ");
                int position = sc.nextInt();

                System.out.println("\nSedang mengautentikasi data...");
                Thread.sleep(5000);

                if (positionList.get(position) != null) {
                    if (position > 0 && position < 5) {
                        PengurusInti pengurus = new PengurusInti(name, date, nim);
                        pengurus.setAge(pengurus.getDateOfBirth());
                        pengurus.setFaculty(facultyMap);
                        pengurus.setRegisterYear(nim);
                        pengurus.setEmail(pengurus.getName());
                        pengurus.setPosition(positionList, position);
                        System.out.println("Pendaftaran Berhasil");
                        pi = pi + pengurus.data();
                        positionList.remove(position);
                    } else if (position > 4 && position < 10) {
                        Koordinator kordinator = new Koordinator(name, date, nim);
                        kordinator.setAge(kordinator.getDateOfBirth());
                        kordinator.setFaculty(facultyMap);
                        kordinator.setRegisterYear(nim);
                        kordinator.setEmail(kordinator.getName());
                        kordinator.setPosition(positionList, position);
                        System.out.println("Pendaftaran Berhasil");
                        ks = ks + kordinator.data();
                        positionList.remove(position);
                    }
                } else {
                    System.out.println("Jabatan tidak ada/Sudah diambil alih");
                }
            }
        }
        sc.close();
    }

    public void positionListMenu() {
        System.out.println("\n+++++ PENGURUS INTI +++++");
        System.out.println("1. Ketua");
        System.out.println("2. Wakil Ketua");
        System.out.println("3. Sekretaris");
        System.out.println("4. Bendahara");
        System.out.println("+++++ KORDINATOR BIDANG & STAF +++++");
        System.out.println("5. Kordinator Bidang Advertising");
        System.out.println("6. Kordinator Bidang Sosial Media");
        System.out.println("7. Kordinator Bidang Event");
        System.out.println("8. Staf Penasihat");
        System.out.println("9. Staf Pelayanan");
    }

    public void initialDisplay() {
        System.out.println("\n++++++++++ Sistem Informasi ++++++++++");
        System.out.println("+++++++ UKM Programmer Unhas +++++++++");
        System.out.println("1. Pengurus inti");
        System.out.println("2. Koordinator bidang dan staf");
        System.out.println("9. Mendaftar");
        System.out.println("0. Exit");
        System.out.println("(*Khusus Mahasiswa Universitas Hasanuddin angkatan 2000 ke atas yang boleh mendaftar)");
    }
}