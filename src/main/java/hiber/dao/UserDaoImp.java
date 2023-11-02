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
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User u");
      return query.getResultList();
   }

   @Override
   public List<User> usersByCarModel(String model) {
      String hql = "FROM User u where u.car.model = :model_name";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("model_name", model);
      return query.getResultList();
   }

   @Override
   public List<User> usersByCarSeries(int series) {
      String hql = "FROM User u where u.car.series = :series_value";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("series_value", series);
      return query.getResultList();
   }

   @Override
   public List<User> usersByCar(String model, int series) {
      String hql = "FROM User u WHERE u.car.model = :model_name AND u.car.series = :series_value";
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("model_name", model);
      query.setParameter("series_value", series);
      return query.getResultList();
   }

}
