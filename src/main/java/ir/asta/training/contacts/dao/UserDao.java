package ir.asta.training.contacts.dao;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.wise.core.datamanagement.ActionResult;

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
		String queryString = "select e from UserTB e where username := UsereName ";
		Query query = entityManager.createQuery(queryString);
	}

	public boolean containsUser(String username){
		Query query = entityManager.createQuery("select e from UserEntity e where username=:username");
		query.setParameter("username", username);
		List list = query.getResultList();
		return list.size() > 0;
	}

	public UserEntity checkUsernameAndPassword(String username, String password){
		Query query = entityManager.createQuery("select e from UserEntity e where username=:username and password=:password");
		query.setParameter("username", username).setParameter("password", password);
		List<UserEntity> list = query.getResultList();
		if (list.size() > 0){
			return list.get(0);
		}
		return null;
	}
}
