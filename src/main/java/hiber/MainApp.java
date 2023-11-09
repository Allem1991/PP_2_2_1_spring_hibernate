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

      User user1 = new User("Alex", "Stepanov", "sasha1@mail.ru", new Car("BMW", 3));
      User user2 = new User("Andrew", "Bobov", "andrew001@mail.ru", new Car("BMW", 4));
      User user3 = new User("Stepan", "Grevin", "stepan12@mail.ru", new Car("BMW", 5));
      User user4 = new User("Gleb", "Smetanin", "gleb11@mail.ru", new Car("Audi", 5));


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

      List<User> usersCar = userService.usersByCar("Audi", 5);
      usersCar.forEach(System.out::println);

      context.close();
   }
}
