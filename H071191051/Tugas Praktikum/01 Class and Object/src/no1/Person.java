package no1;

class Person {
    String name;
    int age;
    boolean isMale;

    void setAge(int age) {
        this.age = age;
    }
    int getAge() {
        return age;
    }
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
    void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    String getGender() {
        if(isMale) {
            return "Laki - laki";
        }else {
            return "Perempuan";
        }
    }
}