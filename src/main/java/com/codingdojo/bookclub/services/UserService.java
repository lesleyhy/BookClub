package com.codingdojo.bookclub.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repos.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	//==========Register and Login==============
	
	public User register(User newUser, BindingResult result) {
        //check if email is unique
		if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "Email is taken.");
		}
		
		//check if pw match cfm pw
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Password not match.");
		}
				
		if(result.hasErrors()) {
			return null;
		}
		
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		return userRepo.save(newUser);

    }
	
	
    public User login(LoginUser newLoginUser, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	//check if the user with the entered email exists
    	Optional<User>potentialUser = userRepo.findByEmail(newLoginUser.getEmail());
        if(!potentialUser.isPresent()) {
        	result.rejectValue("email", "Unique", "Invalid Credentials.");
        	return null;
        }
    	
    	User user = potentialUser.get(); //get the User object from the Optional
    	if(!BCrypt.checkpw(newLoginUser.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Credentials.");
        	return null;
    	}
    			
        return user;
    }
    
	//===========Read===================
    
    public List<User> getAll(){
    	return userRepo.findAll();
    }
	
	public User getOne(Long id) {
		return userRepo.findById(id).orElse(null);
	}

}

