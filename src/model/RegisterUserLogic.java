package model;
import dao.UserDao;
public class RegisterUserLogic {
	 public void execute(User RegisterUser) {
	        UserDao dao = new UserDao();
	        dao.create(RegisterUser);      
	    }
}
