package core.abstracts;

import entities.concretes.User;

public interface GoogleService {
    void verifyAccaount(User user);
    void accountVerification(User user);
}
