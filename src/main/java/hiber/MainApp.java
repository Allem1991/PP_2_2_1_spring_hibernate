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

      user1.setFirstName("Alex");user1.setLastName("Stepanov");user1.setEmail("sasha1@mail.ru");user1.setCar("BMW", 3);
      user2.setFirstName("Andrew");user2.setLastName("Bobov");user2.setEmail("andrew001@mail.ru");user2.setCar("BMW", 4);
      user3.setFirstName("Stepan");user3.setLastName("Grevin");user3.setEmail("stepan12@mail.ru");user3.setCar("BMW", 5);
      user4.setFirstName("Gleb");user4.setLastName("Smetanin");user4.setEmail("gleb11@mail.ru");user4.setCar("Audi", 5);


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
