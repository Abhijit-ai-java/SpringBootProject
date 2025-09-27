package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.exception.ResourceNotFoundException;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found with id= "+id));
	}

	@Override
	public User updateUser(Long id, User userDetails) {
		
		User user = getUserById(id);
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		
		if(!userRepository.existsById(id))
		{
			throw new ResourceNotFoundException("User not found with id= "+id);
		}
		userRepository.deleteById(id);
	}
}
