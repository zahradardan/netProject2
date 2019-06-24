package ir.asta.training.contacts.manager;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import ir.asta.training.contacts.dao.UserDao;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Named("UserManager")
public class UserManager {

    @Inject
    private UserDao dao;

    @Context
    public HttpServletRequest request;
    @Context
    public HttpServletResponse response;

    @Transactional

    public ActionResult save(UserEntity entity) {
        if (!dao.containsUser(entity.getName())) {
            return new ActionResult<UserEntity>(true, "ثبت نام با موفقیت انجام شد.", dao.save(entity));
        } else {
            return new ActionResult<String>(false, "ثبت نام با شکست مواجه شد.", "");
        }
    }

    public ActionResult<UserEntity> login(String username, String password) throws IOException, NoSuchAlgorithmException, ServletException {
        ActionResult<UserEntity> result = new ActionResult<>();
        if (dao.checkUsernameAndPassword(username, password) == null) {
            result.setSuccess(false);
            result.setMessage("اطلاعات وارد شده صحیح نمی باشد.");

        } else {
            result.setSuccess(true);
            result.setMessage("کاربر وارد شد.");
        }
        return result;
    }
    public ActionResult<UserEntity> editprofile(String oldpassword, String newpassword,String username) throws IOException, NoSuchAlgorithmException, ServletException {
        ActionResult<UserEntity> result = new ActionResult<>();


       if(dao.checkUsernameAndPassword(username,oldpassword)==null){
           result.setSuccess(false);
           result.setMessage("رمز عبور نادرست است"  + oldpassword);
       }
        else if(dao.upadatepassword(oldpassword,newpassword,username)){
            result.setSuccess(true);
            result.setMessage("رمز عبور عوض شد");
        }
       else{
           result.setSuccess(false);
           result.setMessage("تعویض با مشکل مواجه شد");
       }
       return result;
    }


}
