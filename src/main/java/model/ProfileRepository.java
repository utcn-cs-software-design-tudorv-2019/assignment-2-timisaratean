package model;

import java.util.List;

public interface ProfileRepository {
	public Profile findProfile(int id);
	public Profile findByIdUser (int id);
	public List<Profile> list() ;
	public void create(Profile objectToCreate);
	public void delete(Profile objectToDelete);
	public void update(Profile objectToUpdate);
}
