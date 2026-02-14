package repositories;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.UserEntity;
import utils.HibernateUtil;

public class UserRepository 
{
	private Session getUserSession() 
	{
		Session session = HibernateUtil
				.getSessionFactory()
				.openSession();
		
		return session;
	}
	
	public UserEntity findUserById(int id)
	{
		Session session = getUserSession();
		
		UserEntity userEntity = session.get(UserEntity.class, id);
		
		session.close();
		
		return userEntity;
	}
	
	@SuppressWarnings("deprecation")
	public void saveUser(UserEntity userEntity)
	{
		Session session = getUserSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(userEntity);
		
		tx.commit();
		
		session.close();
	}
}
