package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {
      sessionFactory.getCurrentSession().save(user);
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> userByCarModel(String model) {
      String hql = "FROM User where car.model = :model_name";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("model_name", model);
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> userByCarSeries(int series) {
      String hql = "FROM User where car.series = :series_value";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("series_value", series);
      return query.getResultList();
   }

}
