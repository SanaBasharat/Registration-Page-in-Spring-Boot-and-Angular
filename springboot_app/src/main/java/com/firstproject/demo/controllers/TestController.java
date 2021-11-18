package com.firstproject.demo.controllers;

// import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Status;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerResponse;

import com.firstproject.demo.model.User;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
// @RequestMapping(value = "/users" , method = RequestMethod.GET)
public class TestController {
    private List<User> Users = createList();

	// @GetMapping(produces = "application/json")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@GetMapping("/server-http-response")
	public List<User> firstPage(HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200/");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
		return Users;
	}
	
	private static List<User> createList() {
		List<User> tempUsers = new ArrayList<>();
		User user1 = new User();
		user1.setName("user1");
		user1.setGender("female");
		user1.setUserID("1");
		user1.setAge(23);

		User user2 = new User();
		user2.setName("user2");
		user2.setGender("male");
		user2.setUserID("2");
		user2.setAge(21);
		tempUsers.add(user1);
		tempUsers.add(user2);
		return tempUsers;
	}
}
