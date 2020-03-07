public class Main {
    public static void main(String[] args) {
        Login login = Login.getInstance();

        login.auth("fitrh", "12345678");
        login.status();

        System.out.println("\n");

        login.auth("ken", "asdf");
        login.status();

        System.out.println("\n");

        login.auth("farhan", "Parhan");
        login.status();

        System.out.println("\n");
        
        login.auth("cick", "12345");
        login.status();
    }
}