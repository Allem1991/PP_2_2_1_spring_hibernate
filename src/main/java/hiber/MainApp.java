package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("BMW", 5);
      Car car2 = new Car("BMW", 4);
      Car car3 = new Car("BMW", 3);
      Car car4 = new Car("Audi", 5);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);

      userService.add(user1, car1);
      userService.add(user2, car2);
      userService.add(user3, car3);
      userService.add(user4, car4);

      List<User> users = userService.listUsers();
      users.forEach(System.out::println);

      System.out.println();

      List<User> usersCarModel = userService.usersByCarModel("BMW");
      usersCarModel.forEach(System.out::println);

      System.out.println();

      List<User> usersCarSeries = userService.usersByCarSeries(5);
      usersCarSeries.forEach(System.out::println);

      System.out.println();

      List<User> usersCar = userService.usersByCar("Audi", 5);
      usersCar.forEach(System.out::println);

      context.close();
   }
}
