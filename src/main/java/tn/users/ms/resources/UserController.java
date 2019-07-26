package tn.users.ms.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.users.ms.entities.User;
import tn.users.ms.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	UserService userService;

	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<String>("user added!", HttpStatus.OK);

	}

	@GetMapping("{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {

		User foundedUser = userService.findByUsername(username);
		return new ResponseEntity<User>(foundedUser, HttpStatus.OK);

	}
}
