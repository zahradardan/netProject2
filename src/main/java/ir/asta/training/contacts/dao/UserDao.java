package ir.asta.training.contacts.dao;



import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Named("userDao")
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public UserEntity save(UserEntity ue) {
			entityManager.persist(ue);
			return ue;
	}

	public void load(String username ) {
		Query query = entityManager.createQuery("select e from UserEntity e where e.name = :username");
	}

	public boolean containsUser(String username) {
        Query query = entityManager.createQuery("select e from UserEntity e where e.name = :username");
        List results = query.setParameter("username", username).getResultList();
        if (results.isEmpty())
            return false;
        else
            return true;
    }

	public UserEntity checkUsernameAndPassword(String username, String password){
		Query query = entityManager.createQuery("select e from UserEntity e where e.name= :username and e.password= :password");
		List result=query.setParameter("username", username).setParameter("password", password).getResultList();
		if(result.isEmpty())
		    return null;
		else
		    return (UserEntity) result.get(0);
	}

	public List<UserEntity> management(){
		Query query = entityManager.createQuery("select e from UserEntity e where e.student = false");
		List result = query.getResultList();

		if(result.isEmpty()){
			return null;
		}else{
			return result;
		}
	}


	@Transactional
	public int manager_del(String username){
		Query query = entityManager.createQuery("DELETE from UserEntity e where e.name = :username");
		int p =query.setParameter("username",username).executeUpdate();
		return p;
	}

	@Transactional
	public UserEntity manager_up(String username){
		Query query = entityManager.createQuery("select e from UserEntity e where e.name = :username");
		List results = query.setParameter("username", username).getResultList();
		UserEntity ue = (UserEntity) results.get(0);
		ue.setConfirmed(true);
		entityManager.merge(ue);
		return ue;
	}

	@Transactional
	public UserEntity manager_act(String username){
		Query query = entityManager.createQuery("select e from UserEntity e where e.name = :username");
		List results = query.setParameter("username", username).getResultList();
		UserEntity ue = (UserEntity) results.get(0);
		ue.setActivate(false);
		entityManager.merge(ue);
		return ue;
	}

	public ActionResult<List<UserEntity>> users(){
		Query query=entityManager.createQuery("select u from UserEntity u");
		List<UserEntity> list=query.getResultList();
		ActionResult<List<UserEntity>> actionResult=new ActionResult<>();
		if(list.size()>0){
			actionResult.setMessage("True");
			actionResult.setSuccess(true);
		}
		else{
			actionResult.setMessage("false");
			actionResult.setSuccess(false);
		}

		actionResult.setData(list);
		return actionResult;
	}

	public ActionResult<List<UserEntity>> responsibles(){
		Query query=entityManager.createQuery("select u from UserEntity u where u.student = FALSE");
		List<UserEntity> list=query.getResultList();
		ActionResult<List<UserEntity>> actionResult=new ActionResult<>();
		if(list.size()>0){
			actionResult.setMessage("True");
			actionResult.setSuccess(true);
		}
		else{
			actionResult.setMessage("false");
			actionResult.setSuccess(false);
		}
		actionResult.setData(list);
		return actionResult;
	}

	@Transactional
	public boolean upadatepassword(String password,String newpassword,String username){
		Query query = entityManager.createQuery("select e from UserEntity e where e.name= :username and e.password= :password");
		List result = query.setParameter("username",username).setParameter("password",password).getResultList();
		if(!result.isEmpty()) {
			UserEntity ue =  (UserEntity) result.get(0);
			ue.setPassword(newpassword);
			entityManager.merge(ue);
			return true;
		}
		else {
			return false;
		}
	}
}
