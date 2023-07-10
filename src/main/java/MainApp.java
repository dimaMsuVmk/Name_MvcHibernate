import hiber.config.HiberConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HiberConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.save(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.save(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.save(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.save(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
