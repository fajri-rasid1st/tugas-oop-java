import java.lang.Exception;
import java.util.NoSuchElementException;

class Login {
    private static Login login = null;
    private User user;
    private UserDetail userDetail;
    private DataSource dataSource;
    
    private Login() {
        dataSource = DataSource.getInstance();
    }

    public static Login getInstance() {
        if (login == null) {
            login = new Login();
        }
        return login;
    }

    public void auth(String userName, String password) {
        try {
            user = dataSource.getUser(userName);
            if (user.getPassword().equals(password)) {
                userDetail = dataSource.getUserDetail(user.getId());
            } else {
                System.out.println("Invalid password!");
            }
        } catch (Exception e) {
            throw new NoSuchElementException("No such Username :" + userName);
        }
    }
    
    public void status() {
        try {
            System.out.printf("Name\t\t: %s\n", userDetail.getName());
            System.out.printf("Email\t\t: %s\n", userDetail.getEmail());
            System.out.printf("Date of Birth\t: %s\n", userDetail.getBirthDay());
            System.out.printf("Username\t: %s\n", user.getUserName());
            System.out.printf("Password\t: %s", user.getPassword());
        } catch (NullPointerException npe) {
            System.out.print("");
        }
    }
}