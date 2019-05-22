package ir.asta.training.contacts.services.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.management.Query;

import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.training.contacts.manager.UserManager;
import ir.asta.training.contacts.services.UserService;
import ir.asta.wise.core.datamanagement.ActionResult;

@Named("UserService")
public class UserServiceImp implements UserService{
		
		@Inject
		UserManager manager;
		
		@Override

		public String save(String username,String password,boolean isStudent) {

			UserEntity entity = new UserEntity();
			entity.setName(username);
			entity.setPassword(password);
			entity.setStatus(isStudent);
			manager.save(entity);

			return entity.getId() + " " +entity.getName()+" ";
//			return new ActionResult<Long>(true, "New contact saved successfully.", entity.getId());

		}

	@Override
	public UserEntity load(String password , String username) {
		UserEntity entity = new UserEntity();
		entity.setName(username);
		entity.setPassword(password);
		return null;
	}

}
