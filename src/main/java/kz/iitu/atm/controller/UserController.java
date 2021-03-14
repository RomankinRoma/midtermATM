package kz.iitu.atm.controller;

import kz.iitu.atm.model.User;
import kz.iitu.atm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public User login(@Param(value = "username")String username,@Param(value = "password")String password){
        return iUserService.checkPassword(username,password);
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public User getInfo(@PathVariable Integer id){
        return iUserService.getById(id);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return iUserService.create(user);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public User update(@RequestBody User user){
        return iUserService.update(user);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        iUserService.delete(id);
    }
}
