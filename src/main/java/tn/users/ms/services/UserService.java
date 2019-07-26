package tn.users.ms.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.users.ms.entities.User;
import tn.users.ms.repositories.UserRepository;

@Service
public class UserService {
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	UserRepository userRepository;

	public void addUser(User user) {
		userRepository.save(user);
		log.info("user added");
	}
	
	public User findByUsername(String username) {
	
		return userRepository.findByUsername(username).get(0);
	}

}
