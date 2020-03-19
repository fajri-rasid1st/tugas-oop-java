import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class Dimension {
    public void mainMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        while (true) {

            FileInputStream file = new FileInputStream("Dimension.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                System.out.println(scan.nextLine());
            }
            file.close();
            scan.close();

            System.out.print("> ");
            int choice = sc.nextInt();
            double s1, s2, s3, s4;

            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.print("Sisi        : ");
                Persegi persegi = new Persegi(sc.nextDouble());
                persegi.show();
            } else if (choice == 2) {
                System.out.print("Panjang     : ");
                s1 = sc.nextDouble();
                System.out.print("Lebar       : ");
                s2 = sc.nextDouble();
                PersegiPanjang persegiPanjang = new PersegiPanjang(s1, s2);
                persegiPanjang.show();
            } else if (choice == 3) {
                System.out.print("Sisi 1(a)   : ");
                s1 = sc.nextDouble();
                System.out.print("Sisi 2(t)   : ");
                s2 = sc.nextDouble();
                System.out.print("Sisi 3      : ");
                s3 = sc.nextDouble();
                Segitiga segitiga = new Segitiga(s1, s2, s3);
                segitiga.show();
            } else if (choice == 4) {
                System.out.print("Jari-jari   : ");
                Lingkaran lingkaran = new Lingkaran(sc.nextDouble());
                lingkaran.show();
            } else if (choice == 5) {
                System.out.print("Alas        : ");
                s1 = sc.nextDouble();
                System.out.print("Tinggi      : ");
                s2 = sc.nextDouble();
                System.out.print("Sisi miring : ");
                s3 = sc.nextDouble();
                JajarGenjang jajarGenjang = new JajarGenjang(s1, s2, s3);
                jajarGenjang.show();
            } else if (choice == 6) {
                System.out.print("Sisi        : ");
                s1 = sc.nextDouble();
                System.out.print("Diagonal 1  : ");
                s2 = sc.nextDouble();
                System.out.print("Diagonal 2  : ");
                s3 = sc.nextDouble();
                BelahKetupat belahKetupat = new BelahKetupat(s1, s2, s3);
                belahKetupat.show();
            } else if (choice == 7) {
                System.out.print("Sisi 1      : ");
                s1 = sc.nextDouble();
                System.out.print("Sisi 2      : ");
                s2 = sc.nextDouble();
                System.out.print("Diagonal 1  : ");
                s3 = sc.nextDouble();
                System.out.print("Diagonal 2  : ");
                s4 = sc.nextDouble();
                Layangan layang = new Layangan(s1, s2, s3, s4);
                layang.show();
            } else if (choice == 8) {
                System.out.print("Sisi atas   : ");
                s1 = sc.nextDouble();
                System.out.print("Sisi bawah  : ");
                s2 = sc.nextDouble();
                System.out.print("Sisi miring : ");
                s3 = sc.nextDouble();
                System.out.print("Tinggi      : ");
                s4 = sc.nextDouble();
                Trapesium trapesium = new Trapesium(s1, s2, s3, s4);
                trapesium.show();
            } else if (choice == 9) {
                System.out.print("Rusuk           : ");
                Kubus kubus = new Kubus(sc.nextDouble());
                kubus.show();
            } else if (choice == 10) {
                System.out.print("Panjang         : ");
                s1 = sc.nextDouble();
                System.out.print("Lebar           : ");
                s2 = sc.nextDouble();
                System.out.print("Tinggi          : ");
                s3 = sc.nextDouble();
                Balok balok = new Balok(s1, s2, s3);
                balok.show();
            } else if (choice == 11) {
                System.out.print("Luas sisi       : ");
                s1 = sc.nextDouble();
                System.out.print("Luas alas       : ");
                s2 = sc.nextDouble();
                System.out.print("Tinggi          : ");
                s3 = sc.nextDouble();
                PrismaSegitiga prismaSegitiga = new PrismaSegitiga(s1, s2, s3);
                prismaSegitiga.show();
            } else if (choice == 12) {
                System.out.print("Jari-jari       : ");
                s1 = sc.nextDouble();
                System.out.print("Tinggi          : ");
                s2 = sc.nextDouble();
                Tabung tabung = new Tabung(s1, s2);
                tabung.show();
            } else if (choice == 13) {
                System.out.print("Jari-jari       : ");
                s1 = sc.nextDouble();
                System.out.print("Rusuk miring    : ");
                s2 = sc.nextDouble();
                System.out.print("Tinggi          : ");
                s3 = sc.nextDouble();
                Kerucut kerucut = new Kerucut(s1, s2, s3);
                kerucut.show();
            } else if (choice == 14) {
                System.out.print("Jari-jari       : ");
                Bola bola = new Bola(sc.nextDouble());
                bola.show();
            } else if (choice == 15) {
                System.out.print("Luas sisi       : ");
                s1 = sc.nextDouble();
                System.out.print("Luas alas       : ");
                s2 = sc.nextDouble();
                System.out.print("Tinggi          : ");
                s3 = sc.nextDouble();
                LimasSegiEmpat limasSegiEmpat = new LimasSegiEmpat(s1, s2, s3);
                limasSegiEmpat.show();
            }
        }
        sc.close();
    }
}