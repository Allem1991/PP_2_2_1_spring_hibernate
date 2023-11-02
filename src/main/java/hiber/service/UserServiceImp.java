package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user, Car car) {
      userDao.add(user, car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> usersByCarModel(String model) {
      return userDao.usersByCarModel(model);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> usersByCarSeries(int series) {
      return userDao.usersByCarSeries(series);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> usersByCar(String model, int series) {
      return userDao.usersByCar(model, series);
   }

}
