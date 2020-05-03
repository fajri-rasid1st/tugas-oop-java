package exercise1;

public class Main {
    static java.util.Scanner sc = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Nama Staf ::> ");
        String name1 = sc.nextLine();
        System.out.print("Jumlah Kehadiran ::> ");
        int attendance = sc.nextInt();
        System.out.print("Nama Dosen ::> ");
        String name2 = sc.next() + sc.nextLine();
        System.out.print("Jumlah SKS ::> ");
        int sks = sc.nextInt();
        System.out.print("Nama Pegawai ::> ");
        String name3 = sc.next() + sc.nextLine();

        Employee[] employee = new Employee[3];
        employee[0] = new Staf(name1, attendance);
        employee[1] = new Dosen(name2, sks);
        employee[2] = new Employee(name3);

        for (int i = 0; i < employee.length; i++) {
            employee[i].myInfo();
            System.out.print("\n");
        }
        sc.close();
    }
}