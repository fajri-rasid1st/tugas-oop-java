package exercise3;

import java.util.HashMap;

class Courses {
    private HashMap<String, String> myCourses = new HashMap<>();

    public void setCourses() {
        myCourses.put("matematika dasar", "Dr. Eng. Armin Lawi, M.Eng;3");
        myCourses.put("metode statistika", "Dr. Nurtiti Sunusi, S.Si M.Si;3");
        myCourses.put("aljabar linier", "Drs. Muhammad Zakir, M.Si;3");
        myCourses.put("bahasa inggris", "Bu Sukmawati Marzuki;2");
        myCourses.put("wawasan ipteks", "Dr. Sri Suryani, DEA;2");
        myCourses.put("technopreneurship", "Dr. Muhammad Hasbi, M.Sc;3");
        myCourses.put("pemrograman berorientasi objek", "Supri Bin Hj Amir, S.Si, M.Eng;3");
        myCourses.put("logika komputer", "Dr. Diaraya, M.Ak;3");
        myCourses.put("kewarganegaraan", "Pak Irham;2");
    }

    public String getCourses(String lesson) {
        return myCourses.get(lesson);
    }
}