package com.gl.StudentManagement.service;

import com.gl.StudentManagement.entity.User;
import com.gl.StudentManagement.repository.UserRepository;
import com.gl.StudentManagement.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("not found");
		}
		return new MyUserDetails(user);
	}

}
