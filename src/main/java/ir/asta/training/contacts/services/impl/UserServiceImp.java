package ir.asta.training.contacts.services.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.management.Query;
import javax.servlet.ServletException;

import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.training.contacts.manager.UserManager;
import ir.asta.training.contacts.services.UserService;
import ir.asta.wise.core.datamanagement.ActionResult;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Named("UserService")
public class UserServiceImp implements UserService {

    @Inject
    UserManager manager;

    @Override
    public ActionResult<UserEntity> save(String username, String password, boolean isStudent,boolean isTeacher) {

        UserEntity entity = new UserEntity();
        entity.setName(username);
        entity.setPassword(password);
        entity.setStudent(isStudent);
        entity.setTeacher(isTeacher);
        return manager.save(entity);
    }

    @Override
    public ActionResult<UserEntity> load(String password, String username) throws IOException, NoSuchAlgorithmException, ServletException {
        return manager.login(username, password);
    }

    @Override
    public ActionResult<List<UserEntity>> management(){
        return manager.management();
    }

    @Override
    public  ActionResult<Integer> manager_del(String username){
        return manager.manage_del(username);
    }

    @Override
    public ActionResult<UserEntity> manager_up(String username){
      return manager.manage_up(username);
    }

    @Override
    public ActionResult<UserEntity> manager_act(String username){
        return manager.manage_act(username);
    }
}
