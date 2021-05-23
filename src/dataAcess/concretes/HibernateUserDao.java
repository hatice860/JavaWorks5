package dataAcess.concretes;

import dataAcess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;


public class HibernateUserDao implements UserDao {
    ArrayList<User> users = new ArrayList<>();
    public HibernateUserDao() {
        fillUsers();
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        for (User i : users) {
            if (i.getId() == user.getId()) {
                delete(i);
                add(user);
                System.out.println(user.getFirstName() + "isimli kullanıcı güncellendi");
                return;
            }
            System.out.println("Girilen Id ile eşleşen bir kullanıcı bulunamadı");
        }
    }

    @Override
    public void delete(User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                users.removeIf(us -> us.getId() == user.getId());
                System.out.println(user.getFirstName() + " isimli kullanıcı başarıyla silindi");
                break;
            }
        }
    }

        @Override
        public ArrayList<User> getAll () {
            return users;
        }

    private void fillUsers() {
        users.add(new User(1,"hatice", "ay", "hatice@gmail.com", "12345"));
        users.add(new User(2, "rabia", "asd", "hermailcom", "1234567"));
        users.add(new User(3, "dskfnjk", "drfdrgv", "her@gmail.com", "1234567"));
        users.add(new User(4, "rabia", "asd", "rabia123@gmail.com", "1234567"));
        users.add(new User(5, "asd", "asd", "asd@asd.com", "1234567"));
    }

    }
