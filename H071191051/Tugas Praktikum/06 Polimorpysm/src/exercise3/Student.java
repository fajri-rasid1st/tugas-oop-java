package exercise3;

import java.util.StringTokenizer;

class Student extends Courses implements AcademicSystem {
    private String name;
    private String nim;
    private String classType;
    private String lesson;
    private double uts, uas;

    Student(String name, String nim, String classType, String lesson, double uts, double uas) {
        this.name = name;
        this.nim = nim;
        this.classType = classType;
        this.lesson = lesson;
        this.uts = uts;
        this.uas = uas;
        super.setCourses();
    }

    @Override
    public double setfinalScore(double uts, double uas) {
        return (uts + uas) / 2;
    }

    @Override
    public String setgrade(double score) {
        if (score >= 80) {
            return "A";
        } else if (score >= 75) {
            return "A-";
        } else if (score >= 70) {
            return "B+";
        } else if (score >= 65) {
            return "B";
        } else if (score >= 60) {
            return "B-";
        } else if (score >= 55) {
            return "C+";
        } else if (score >= 50) {
            return "C";
        } else if (score >= 25) {
            return "D";
        } else {
            return "E";
        }
    }

    public String[] getLectureAndSks() {
        String data = super.getCourses(lesson);
        String[] lectureAndSks = new String[2];

        StringTokenizer sToken = new StringTokenizer(data, ";");
        lectureAndSks[0] = sToken.nextToken();
        lectureAndSks[1] = sToken.nextToken();

        return lectureAndSks;
    }

    @Override
    public void desc() {
        System.out.println("\n------- Sistem Akadamik Mahasiswa -------");
        System.out.println("-----------------------------------------");
        System.out.println("Nama        : " + name);
        System.out.println("NIM         : " + nim);
        System.out.println("Kelas       : " + classType);
        System.out.println("Mata kuliah : " + lesson);
        System.out.println("SKS         : " + getLectureAndSks()[1]);
        System.out.println("Dosen       : " + getLectureAndSks()[0]);
        System.out.println("Nilai UTS   : " + uts);
        System.out.println("Nilai UAS   : " + uas);
        System.out.println("Nilai Akhir : " + setfinalScore(uts, uas));
        System.out.println("Angka Mutu  : " + setgrade(setfinalScore(uts, uas)));
        System.out.println("-----------------------------------------");
    }

    public boolean lessonIsExist(String lesson) {
        if (super.getCourses(lesson) == null) {
            return false;
        } else {
            return true;
        }
    }
}