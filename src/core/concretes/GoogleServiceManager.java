package core.concretes;

import core.abstracts.GoogleService;
import entities.concretes.User;

public class GoogleServiceManager implements GoogleService {
    @Override
    public void verifyAccaount(User user) {
        if (user.getFirstName().length() >= 2 && user.getLastName().length() >= 2 && user.getPassword().length() >= 6 && user.geteMail().contains("@")){
            System.out.println(user.geteMail()+"hesabı doğrulandı");
        }
        else {
            System.out.println("Doğrulama sırasında bir hata yaşandı");
        }
    }

    @Override
    public void accountVerification(User user) {
        if (user.geteMail().contains("@")){
            System.out.println(user.geteMail()+"hesabına doğrulama kodu gönderildi");
        }
        else{
            System.out.println("kod gönderilemedi");
        }


    }
}
