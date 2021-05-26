package kz.iitu.atm.service;

import kz.iitu.atm.model.User;

import java.util.List;

public interface IUserService {
    User create(User object);
    User update(User object);
    void delete(Integer id);
    List<User> getAll();
    User getById(Integer id);
    User getByUsername(String username);

    User getByPhoneNumber(String phone);
}
