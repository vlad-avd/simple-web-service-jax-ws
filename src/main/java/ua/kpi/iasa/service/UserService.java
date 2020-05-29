package ua.kpi.iasa.service;

import ua.kpi.iasa.exception.UserAlreadyExists;
import ua.kpi.iasa.exception.UserNotFound;
import ua.kpi.iasa.model.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface UserService {

    @WebMethod
    User getUserById(long id) throws UserNotFound;

    @WebMethod
    User updateUserById(long id, String username, String password) throws UserNotFound;

    @WebMethod
    boolean deleteUserById(long id) throws UserNotFound;

    @WebMethod
    User addUser(long id, String username, String password) throws UserAlreadyExists;

    @WebMethod
    int countUsers();

}
