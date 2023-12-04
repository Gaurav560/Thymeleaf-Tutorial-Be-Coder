package StreamApiTelusko;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndCollect {
	public static void main(String[] args) {

		// collect() method of Stream Interface to accumulate elements of any stream
		// into collection.

		// creating a list of user type
		List<User> users = new ArrayList<>();

		// adding new users to the list
		users.add(new User("gaurav", "1809157@sbsstc.ac.in", "Lumia@540"));
		users.add(new User("amar", "1809158@sbsstc.ac.in", "Lumia@541"));
		users.add(new User("sameer", "1809159@sbsstc.ac.in", "Lumia@541"));
		users.add(new User("divya", "1809160@sbsstc.ac.in", "Lumia@542"));

		// creating list of userDto to store objects
		List<UserDto> userDtos = new ArrayList<>();

		// traditional way of mapping user object into userDto object
		// now we will map ,each user object into UserDto object using steam.map
		for (User u : users) {
			userDtos.add(new UserDto(u.getUserName(), u.getEmail()));

		}

		// printing objects in userDtos oject
		userDtos.forEach(u -> System.out.println(u));

		// new way using stream api to map user object into userDto object
		System.out.println("\n");

		// collect method to collect the stream objects and Collectors.toList() to
		// convert
		// a stream into List
		users.stream().map(user -> new UserDto(user.getUserName(), user.getEmail())).collect(Collectors.toList())
				.forEach(listObj -> System.out.println(listObj));

	}

}

class UserDto {
	private String userName;
	private String email;

	// getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// parameterized constructor
	public UserDto(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}

	// toString() overridden method
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + "]";
	}

}

class User {
	private String userName;
	private String password;
	private String email;

	// getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// parameterized constructor
	public User(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	// toString() overridden method
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}

}
