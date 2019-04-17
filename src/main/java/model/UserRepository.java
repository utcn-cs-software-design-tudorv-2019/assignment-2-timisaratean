package model;

import java.util.List;

public interface UserRepository {
	public User findById(int id);
	public List<User> list();
	public void insert(User objectToCreate);
	public int findId(String username);
}
