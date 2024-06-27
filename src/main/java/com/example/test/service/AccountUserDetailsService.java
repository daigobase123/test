package com.example.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.test.beans.MyUser;
import com.example.test.dao.UserDao;

@Service
public class AccountUserDetailsService implements UserDetailsService {

	@Autowired
    private UserDao userDao;

	
    public UserDetails loadUserByUsername(String userName)
    	throws UsernameNotFoundException{
    	
    	if(userName == null || "".equals(userName)) {
    		throw new UsernameNotFoundException(userName + "is not found");
    	}
    	
    	try {
    		MyUser myUser = userDao.findById(userName);
    		
            if (myUser != null) {
                return new AccountUserDetails(myUser); // --- (2) UserDetailsの実装クラスを生成

            } else {
                throw new UsernameNotFoundException(userName + "is not found");
            }
    	} catch(EmptyResultDataAccessException e) {
    		throw new UsernameNotFoundException(userName + "is not found");
    	}
        
    }
}