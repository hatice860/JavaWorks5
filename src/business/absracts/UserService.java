package business.absracts;

import entities.concretes.User;

import java.util.ArrayList;

public interface UserService {
    void register (User user);
    void logİn(String Email, String password);
    void googleWithAccount(String Email, String password);
    void add(User user);
    void update(User user);
    void delete (User user);
    ArrayList<User> getAll();
}
