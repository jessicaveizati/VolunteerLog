package backend.services;

import backend.repositories.UsersRepo;
import models.Users;

import java.util.List;

public class UsersService {
    private final UsersRepo repo;

    public UsersService(UsersRepo usersRepo) {
        repo = usersRepo;
    }
    public List<Users> getAllUsers() {
        return repo.getUsers();
    }

    //Adds a user to the database
    public void addUser(String name, String email, int graduationYear){
        if (name == null) {
            throw new IllegalArgumentException("The input is empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("The input is empty");
        }
        if (graduationYear <= 0){
            throw new IllegalArgumentException("The input is invalid");
        }
        repo.addUser(name, email, graduationYear);
    }

}





