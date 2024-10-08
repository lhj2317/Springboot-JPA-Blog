package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
 

// 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. IoC를 해준다.
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;	
	
	@Transactional
	public void 회원가입(User user) { 
		String rawPassword = user.getPassword();   //1234원문
		String encPassword = encoder.encode(rawPassword);  //해쉬
		user.setPassword(encPassword);
		//실제로 DB에 insert 하고 아래에서 return 
		user.setRole(RoleType.USER);
		userRepository.save(user); 
	}	
}
