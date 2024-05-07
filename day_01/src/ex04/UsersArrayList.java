package ex04;

public class UsersArrayList implements UsersList {
    private static Integer usersNumber = 0;
    private Integer reserved = 10;
    private User[] users = new User[reserved];

    @Override
    public void addUser(User user) {
        if (usersNumber.equals(reserved)) {
            allocate();
        }
        users[usersNumber] = user;
        ++usersNumber;
    }

    public void allocate() {
        Integer newSize = (reserved + (reserved / 2));
        User[] temp = new User[newSize];

        for (int i = 0; i < reserved; ++i) {
            temp[i] = users[i];
        }
        users = temp;
    }

    @Override
    public User getUserById(Integer id) throws UserNotFoundException {
        User user = null;

        checkNotNull(id);
        user = searchUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User getUserByIndex(Integer index) {
        User user = null;

        checkNotNull(index);
        user = searchUserByIndex(index);
        return user;
    }

    @Override
    public Integer getUsersNumber() {
        return usersNumber;
    }

    private User searchUserByIndex(Integer index) {
        User user = null;

        checkNotNull(index);
        checkIndex(index);
        for (int i = 0; i < usersNumber; ++i) {
            if (index.equals(i)) {
                user = users[i];
                break;
            }

        }
        return user;
    }

    private void checkIndex(Integer index) throws UserNotFoundException {
        if ((index < 0) || (index > usersNumber)) {
            throw new UserNotFoundException("User not Found");
        }
    }

    private User searchUserById(Integer id) {
        User user = null;

        for (int i = 0; i < usersNumber; ++i) {
            if (users[i].getId().equals(id)) {
                user = users[i];
                break;
            }
        }
        return user;

    }

    private void checkNotNull(Integer elem) throws UserNotFoundException {
        if (elem == null) {
            throw new UserNotFoundException("Null pointer");
        }
    }
}
