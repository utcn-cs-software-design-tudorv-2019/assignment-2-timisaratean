package model;

import java.util.List;

import javax.inject.Inject;


public class UserBLL {
	UserRepository userRepository;
	
	@Inject
	public UserBLL(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	public User findUser(int id){
        return userRepository.findById(id);
    }
	
	public List<User> list() {
        return userRepository.list();
    }
	public void insert(User client) {

        userRepository.insert(client);
    }
	public int login(String name, String password) {
		List<User> users=list();
		for (User u:users) {
			if (u.getUsername().equals(name)) {
				if(u.getPass().equals(password)) {
					if (u.getTip()==1) {
						return 1;
					}
					return 0;
				}
			}
		}
		return -1;
	}
}
