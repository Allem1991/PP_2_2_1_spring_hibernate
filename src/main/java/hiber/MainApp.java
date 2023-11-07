package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = context.getBean(User.class);
      User user2 = context.getBean(User.class);
      User user3 = context.getBean(User.class);
      User user4 = context.getBean(User.class);

      userService.addUser(user1);
      userService.addUser(user2);
      userService.addUser(user3);
      userService.addUser(user4);

      List<User> users = userService.listUsers();
      users.forEach(System.out::println);

      System.out.println();

      List<User> usersCarModel = userService.usersByCarModel("BMW");
      usersCarModel.forEach(System.out::println);

      System.out.println();

      List<User> usersCarSeries = userService.usersByCarSeries(5);
      usersCarSeries.forEach(System.out::println);

      System.out.println();

      List<User> usersCar = userService.usersByCar("BMW", 3);
      usersCar.forEach(System.out::println);

      context.close();
   }
}
