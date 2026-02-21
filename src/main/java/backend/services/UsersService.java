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
    }





