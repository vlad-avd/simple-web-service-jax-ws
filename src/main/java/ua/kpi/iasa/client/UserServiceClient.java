package ua.kpi.iasa.client;

import ua.kpi.iasa.service.UserService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class UserServiceClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:9999/user?wsdl");

        QName qname = new QName("http://impl.service.iasa.kpi.ua/", "UserServiceImplService");

        Service service = Service.create(url, qname);

        UserService userService = service.getPort(UserService.class);

        System.out.println("Users number: " + userService.countUsers());
        System.out.println("User with ID = 3: " + userService.getUserById(3));

        userService.addUser(4, "username", "password");
        System.out.println("Add user: " + userService.getUserById(4));
        System.out.println("Users number: " + userService.countUsers());

        userService.updateUserById(4, "newUsername", "newPassword");
        System.out.println("Update user with ID = 4: " + userService.getUserById(4));

        userService.deleteUserById(1);

        System.out.println("Delete user with ID = 4. User number: " + userService.countUsers());

    }

}