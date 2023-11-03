package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUser(User user);
   List<User> listUsers();

   List<User> usersByCarModel(String model);

   List<User> usersByCarSeries(int series);

   List<User> usersByCar(String model, int series);

}
