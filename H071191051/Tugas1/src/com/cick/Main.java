package com.cick;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map <String, String> facultyMap = new HashMap<>();
        Map <String, String> majorMap = new HashMap<>();
        facultyMap.put("Kedokteran", "A");
        facultyMap.put("Farmasi", "B");
        facultyMap.put("Teknik", "C");
        facultyMap.put("Kehutanan", "D");
        facultyMap.put("Pertanian", "E");
        facultyMap.put("Keperawatan", "F");
        facultyMap.put("KesMas", "G");
        facultyMap.put("MIPA", "H");
        
        majorMap.put("Matematika", "01");
        majorMap.put("Kimia", "02");
        majorMap.put("Fisika", "03");
        majorMap.put("Biologi", "04");
        majorMap.put("Geofisika", "05");
        majorMap.put("Aktuaria", "06");
        majorMap.put("Ilmu Komputer", "07");

        Student s1 = new Student();
	    Student s2 = new Student();
	    Student s3 = new Student();

        s1.setFirstname("MUHAMMAD");
        s1.setLastname("fitRaH");
        s1.setRegisterYear(2017);
        s1.setFaculty("MIPA");
        s1.setDepartment("Matematika");
        s1.setMajor("Ilmu Komputer");
        s1.setId(facultyMap, majorMap);
        s1.setEmail(facultyMap);

	    s2.setFirstname("keNneDy");
        s2.setLastname("");
        s2.setRegisterYear(2018);
        s2.setFaculty("Pertanian");
        s2.setDepartment("Ilmu Tanah");
        s2.setMajor("Biologi");
        s2.setId(facultyMap, majorMap);
        s2.setEmail(facultyMap);
        
	    s3.setFirstname("khawaritZmi");
        s3.setLastname("abdaLLah aHMAD");
        s3.setRegisterYear(2019);
        s3.setFaculty("MIPA");
        s3.setDepartment("Matematika");
        s3.setMajor("Aktuaria");
        s3.setId(facultyMap, majorMap);
        s3.setEmail(facultyMap);

        s1.description();
	    s2.description();
	    s3.description();
        
        sc.close();
    }
}