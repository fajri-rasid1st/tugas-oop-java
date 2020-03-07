import java.io.*;
import java.util.*;

class DataSource {
    private static DataSource dataSource = null;
    private Map<String, User> userMap = new HashMap<String, User>();
    private Map<Integer, UserDetail> userDetailMap = new HashMap<Integer, UserDetail>();

    private DataSource() {
        putUser();
        putUserDetail();
    }
    
    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        return dataSource;
    }

    private void putUser() {
        FileInputStream file = null;
        try {
            file = new FileInputStream("user.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String[] userList = sc.nextLine().split(";");
                userMap.put(userList[1], new User(Integer.valueOf(userList[0]), userList[1], userList[2], userDetailMap.get(Integer.valueOf(userList[0]))));
            }
            sc.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }

    private void putUserDetail() {
        FileInputStream file = null;
        try {
            file = new FileInputStream("userdetail.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String[] userDetailList = sc.nextLine().split(";");
                userDetailMap.put(Integer.valueOf(userDetailList[0]), new UserDetail(Integer.valueOf(userDetailList[0]), userDetailList[1], userDetailList[2], userDetailList[3]));
            }
            sc.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }

    }

    public User getUser(String key) {
        return userMap.get(key);
    }
    
    public UserDetail getUserDetail(int key) {
        return userDetailMap.get(key); 
    }
}