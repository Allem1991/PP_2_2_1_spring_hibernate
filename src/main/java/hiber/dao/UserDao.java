package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void addUserWithCar(User user, Car car);
   List<User> listUsers();

   List<User> usersByCarModel(String model);

   List<User> usersByCarSeries(int series);

   List<User> usersByCar(String model, int series);

}
