public class Main {
    public static void main(String[] args) {
        Login login = Login.getInstance();

        // password correct
        login.auth("fitrh", "12345678");
        login.status();
        System.out.println("\n");
        login.auth("ken", "asdf");
        login.status();
        System.out.println("\n");

        // password incorrect
        login.auth("farhan", "12345");
        System.out.println("\n");

        // account not registered
        login.auth("cick", "man");
    }
}