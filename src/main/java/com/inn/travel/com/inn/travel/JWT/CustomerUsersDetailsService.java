package com.inn.travel.com.inn.travel.JWT;


import com.inn.travel.com.inn.travel.dao.UserDao;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Service
@Slf4j
public class CustomerUsersDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;



    private com.inn.travel.com.inn.travel.Model.User userdetail;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("Inside loadUserByUsername {}",username);
        userdetail = userDao.findByEmailId(username);
        if(!Objects.isNull(userdetail))
            return new User(userdetail.getEmailId(),userdetail.getPassword(), new ArrayList<>());
        else{
            throw new UsernameNotFoundException("User not found");
        }

    }


}
