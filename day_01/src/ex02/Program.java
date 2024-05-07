package ex02;

public class Program {
    private static UsersArrayList users = new UsersArrayList();

    public static void main(String[] args) {
        checkAddUsers();
        checkGetUserById();
        checkGetUserByIndex();
    }

    private static void checkAddUsers() {
        addUser(new User("John"));
        addUser(new User("Mike"));
        addUser(new User("Dick"));
    }

    private static void checkGetUserById() {
        getUserById(1);
        getUserById(2);
        getUserById(3);
        getUserById(null);
        getUserById(0);
        getUserById(-1);
        getUserById(99);
    }

    private static void checkGetUserByIndex() {
        Integer index = 0;

        for (int i = 0; i < 3; ++i) {
            index = i;
            getUserByIndex(index);
        }
        getUserById(-1);
        getUserById(99);
        getUserById(null);
    }

    private static void getUserByIndex(Integer index) {
        String message = "Search by " + "index-" + index + ".";
        String result = "Result: ";
        System.out.println(message);
        users.getUserByIndex(index);
        System.out.print(result);

    }

    private static void addUser(User user) {
        System.out.println("Add new user " + user.getName());
        System.out.println(
                "Users number before addition: " + users.getUsersNumber());
        users.addUser(user);
        System.out.println(
                "Users number after addition: " + users.getUsersNumber());
    }

    private static void getUserById(Integer id) {
        User user = null;

        try {
            user = users.getUserById(id);
            System.out.print("Found user is " + user.getName() + ".");
            System.out.println(" Their id is " + user.getId() + ".");
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
