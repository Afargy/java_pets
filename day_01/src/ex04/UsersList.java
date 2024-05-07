package ex04;

public interface UsersList {

    public void addUser(User user);

    public User getUserById(Integer id) throws UserNotFoundException;

    public User getUserByIndex(Integer index);

    public Integer getUsersNumber();
}
