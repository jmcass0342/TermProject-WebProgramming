package finalProject.logicLayer;

import java.sql.SQLException;
import java.util.List;

import finalProject.entity.User;
import finalProject.logicLayer.ShowDemo;
import finalProject.session.Session;
import finalProject.session.SessionManager;
public class LoginValidation {

	private ShowDemo show;
	private List<User> users = null;
	
	public LoginValidation(){
		try {
			show = new ShowDemo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String validate(Session session, String username, String password) throws Exception{
		String ssid = null;
		String returnString = null;
		try {
			users = show.getValidation(username, password);
			if(users.isEmpty() == false){
				session.setUser(users.get(0));
				ssid = SessionManager.storeSession(session);
				returnString = ssid;
			}else{
				returnString= "Error";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		show.disconnect();
		return returnString;
		
	}
	
	
	public void logout(String ssid) throws Exception{
		SessionManager.logout(ssid);
		show.disconnect();
	}
	
	
	
	
	
}
