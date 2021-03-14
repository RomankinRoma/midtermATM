package kz.iitu.atm.service.impl;

import kz.iitu.atm.model.User;
import kz.iitu.atm.repository.UserRepo;
import kz.iitu.atm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepo.delete(userRepo.getById(id));
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepo.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepo.getByUsername(username);
    }

    @Override
    public User checkPassword(String username, String password) {
        if (userRepo.getByUsername(username).getPassword().equals(password))
            return userRepo.getByUsername(username);
        return null;
    }
}
