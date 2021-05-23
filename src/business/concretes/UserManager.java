package business.concretes;

import business.absracts.UserService;
import dataAcess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager implements UserService {
    ArrayList<User> users;

    public static boolean emailValid (String eMail){

        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(eMail);
        return matcher.matches();

    }
    public static boolean emailValidOnClick(String eMail){
        return true;
    }


    private List<String> emailList = new ArrayList<String>();
    private List<String> passwordList = new ArrayList<String>();

    private UserDao userDao;

    public UserManager (UserDao userDao ){
        super();
        this.userDao=userDao;

    }
    public UserManager(){

    }
    @Override
    public void register(User user){
        if (user.getFirstName().length() >= 2 && user.getLastName().length() >= 2 && user.getPassword().length() >= 6 ){

        }
        else if (! UserManager.emailValid(user.geteMail())){

            System.out.println("e mail gecersiz");
        }

        else if (emailList.contains(user.geteMail())){
            System.out.println("Bu Mail daha önce kullanıldı !");

        }

        else if (UserManager.emailValidOnClick(user.geteMail())){
            System.out.println("Tebrikler! kayıt işlemi tamamlandı.");

        }
        else {
            System.out.println("Emailini kontrol et ve hesabını doğrula");
        }

    }


    public void fillUsers() {
        users.add(new User(1,"hatice", "ay", "hatice@gmail.com", "12345"));
        users.add(new User(2, "rabia", "asd", "hermailcom", "1234567"));
        users.add(new User(3, "dskfnjk", "drfdrgv", "her@gmail.com", "1234567"));
        users.add(new User(4, "rabia", "asd", "rabia123@gmail.com", "1234567"));
        users.add(new User(5, "asd", "asd", "asd@asd.com", "1234567"));

    }

    @Override
    public void logİn(String Email, String password) {
        fillUsers();
        for (User user: users
        ) {
            if (user.geteMail().contains("@") && user.getPassword().length() >= 6){
                System.out.println("Sisteme giriş yapıldı");
            }
            else {
                System.out.println("Email ya da şifreniz yanlış kontrol edip tekrar deneyiniz");
            }
        }

    }

    @Override
    public void googleWithAccount(String Email, String password) {
        if(emailList.contains(Email) && passwordList.contains(password)){
            System.out.println("Google hesabı giriş yapıldı");
        }
        else {
            System.out.println("Email ya da şifreniz yanlış kontrol edip tekrar deneyiniz");
        }


    }

    @Override
    public void add(User user) {
        
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {
        this.userDao.delete(user);

    }

    @Override
    public ArrayList<User> getAll() {
        return users;
    }
}
