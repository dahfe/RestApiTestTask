package test.restapi.cities.service;

import test.restapi.cities.model.User;

public interface AuthService {
    String loginWithUsernameAndPassword(String username, String password);
    void saveUser (User user);
}
