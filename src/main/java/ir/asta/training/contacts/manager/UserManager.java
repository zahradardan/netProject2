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
import java.util.List;

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

    public ActionResult<List<UserEntity>> management()
    {
        List<UserEntity> lu = dao.management();
        if (lu!= null) {
            return new ActionResult<List<UserEntity>>(true, "یکیldjkf پیدا شد.",lu);
        }
        else {
            return new ActionResult<List<UserEntity>>(false, "هیشکی پیدا نشد", null);
        }
    }
    public ActionResult<Integer> manage_del(String username){

        int s = dao.manager_del(username);

            return new ActionResult<Integer>(true, "کاربر حذف شد",s);
    }

    public ActionResult<UserEntity> manage_up(String username){
        UserEntity ue = dao.manager_up(username);
        if(ue!=null) {
            return new ActionResult<UserEntity>(true, "کاربر تایید شد.", dao.manager_up(username));
        }else{
            return new ActionResult<UserEntity>(false, "کاربر تایید نشد.", null);

        }
    }
    public ActionResult<UserEntity> manage_act(String username){
        UserEntity ue = dao.manager_act(username);
        if(ue!=null) {
            return new ActionResult<UserEntity>(true, "کاربر غیر فعال شد.", dao.manager_up(username));
        }else{
            return new ActionResult<UserEntity>(false, "درخواست با مشکل رو به رو شد.", null);
        }
    }
}
