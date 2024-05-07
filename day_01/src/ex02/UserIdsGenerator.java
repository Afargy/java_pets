package ex02;

public class UserIdsGenerator {
    private static UserIdsGenerator instance = null;
    private static Integer id = 0;

    public static UserIdsGenerator getInstance() {
        return ((instance == null) ? new UserIdsGenerator() : instance);
    }

    public Integer generateId() {
        return (++id);
    }
}
