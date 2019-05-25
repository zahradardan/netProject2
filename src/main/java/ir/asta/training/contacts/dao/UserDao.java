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
		Query query = entityManager.createQuery("select e from UserEntity e where e.name = :username ");
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
}
