package exercise3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean condition = true;

        while (condition) {
            System.out.println("-------------- Main Menu --------------");
            System.out.println("1. Lihat Hasil Studi");
            System.out.println("0. Exit");
            System.out.print("> ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Nama        : ");
                String name = sc.next() + sc.nextLine();
                System.out.print("NIM         : ");
                String nim = sc.nextLine();
                System.out.print("Kelas       : ");
                String classType = sc.nextLine();
                System.out.print("Mata kuliah : ");
                String lesson = sc.nextLine().toLowerCase();
                System.out.print("Nilai UTS   : ");
                int uts = sc.nextInt();
                System.out.print("Nilai UAS   : ");
                int uas = sc.nextInt();

                Student st = new Student(name, nim, classType, lesson, uts, uas);

                if (st.lessonIsExist(lesson)) {
                    st.desc();
                } else {
                    System.out.println("\n--- Mata kuliah tidak ditemukan ---\n");
                }

            } else {
                break;
            }
        }
        sc.close();
    }
}