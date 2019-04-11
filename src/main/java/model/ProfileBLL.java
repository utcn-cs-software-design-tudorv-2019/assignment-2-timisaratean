package model;

import java.util.List;

import javax.inject.Inject;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class ProfileBLL {
	Injector guice=Guice.createInjector(new GuiceModule());
	UserBLL user=guice.getInstance(UserBLL.class);
	ProfileRepository profileRepository;
	
	@Inject
	public ProfileBLL(ProfileRepository profileRepository) {
		this.profileRepository=profileRepository;
	}
	
	public Profile findProfile(int id){
        return profileRepository.findProfile(id);
    }
	public List<Profile> list() {
        return profileRepository.list();
    }
	public void create(Profile client) {

        profileRepository.create(client);
    }
	public void delete(Profile p) {
		profileRepository.delete(p);
	}
	public void update(Profile p) {
		profileRepository.update(p);
	}
	public Profile findbyIdUser(int id){
        return profileRepository.findByIdUser(id);
    }
	public void register(Profile p,String username,String pass) {
		List<Profile> profiles=list();
		for (Profile s:profiles) {
			if (s.equals(p)) {
				System.out.println("Acest profil exista deja!");
			}
			else {
				create(p);
				User u=new User(p.getIdUser(),username,pass,1);
				user.insert(u);
			}
		}
	}

}
