package ir.asta.training.contacts.manager;

import javax.inject.Inject;
import javax.inject.Named;

import ir.asta.training.contacts.dao.UserDao;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Named("UserManager")
public class UserManager {
	
	@Inject
	 private UserDao dao;

	@Transactional
	
	public ActionResult<UserEntity> save(UserEntity entity) {
		ActionResult<UserEntity> result = new ActionResult<>();
		if (!dao.containsUser(entity.getName())) {
			result.setData(dao.save(entity));
			result.setSuccess(true);
		}
		else {
			result.setMessage("کاربر با این نام کاربری وجود دارد");
		}
		return result;
	}

	public ActionResult<UserEntity> login(String username, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		UserEntity entity = dao.checkUsernameAndPassword(username, password);
		ActionResult<UserEntity> result = new ActionResult<>();
		result.setData(entity);
		if (entity != null){
			result.setSuccess(true);
		}
		else {
			result.setMessage("نام کاربری یا رمز عبور اشتباه است");
		}
		return result;
	}
}
