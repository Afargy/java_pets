package ex05;

public class User {
    final private Integer ID = UserIdsGenerator.getInstance().generateId();
    private String name = "";
    private Integer balance = 0;

    public User(String name) {
        setName(name);
    }

    public User(String name, Integer balance) {
        setName(name);
        setBalance(balance);
    }

    public Integer getId() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBalance(Integer balance) {
        this.balance = ((balance < 0) ? 0 : balance);
    }

    public Integer getBalance() {
        return this.balance;
    }
}
