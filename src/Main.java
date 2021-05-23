import business.concretes.UserManager;
import core.concretes.GoogleServiceManager;
import dataAcess.abstracts.UserDao;
import entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        GoogleServiceManager googleServiceManager = new GoogleServiceManager();
        UserManager userManager = new UserManager();

        User user2 = new User(2, "hatice", "ay", "hatice@gmail.com", "12345");
        User user3 = new User(3, "ayse", "ay", "gmail.com", "1256345");
        User user5 = new User(5, "emine", "ay", "emine@gmail.com", "1234564");
        System.out.println("Register");
        userManager.register(user3);
        googleServiceManager.accountVerification(user5);
        googleServiceManager.verifyAccaount(user2);
        System.out.println("Register With Google account");
        userManager.googleWithAccount("hatice@mail.com", "12345");
        System.out.println("Login");
        userManager.logİn("ayse123mailcom", "664657");
        userManager.update(user3);
        userManager.delete(user2);
        userManager.add(user5);
        System.out.println(userManager.getAll());
//


    }
    }

