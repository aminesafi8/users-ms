package tn.users.ms.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.users.ms.entities.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public List<User> findByUsername(String username);

}
