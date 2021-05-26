package kz.iitu.atm.repository;

import kz.iitu.atm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User getById(Integer id);
    User getByUsername(String username);
    User getByPhoneNumber(String phoneNumber);

}
