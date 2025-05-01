package com.inn.travel.com.inn.travel.serviceImpl;

import com.inn.travel.com.inn.travel.Model.User;
import com.inn.travel.com.inn.travel.constents.TravelConstants;
import com.inn.travel.com.inn.travel.dao.UserDao;
import com.inn.travel.com.inn.travel.service.UserService;
import com.inn.travel.com.inn.travel.utils.TravelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
        public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signUp {}", requestMap);
        try {
            if (validateSignupMap(requestMap)) {
                User user = userDao.findByEmailId(requestMap.get("emailId"));
                if (Objects.isNull(user)) {
                    userDao.save(getUserFromMap(requestMap));
                    return TravelUtils.getResponseEntity("Successfully registered", HttpStatus.OK);
                } else {
                    return TravelUtils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
                }
            } else {
                return TravelUtils.getResponseEntity(TravelConstants.Invalidmessage, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error("Exception in signUp: ", e);
            return TravelUtils.getResponseEntity(TravelConstants.errormessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private boolean validateSignupMap(Map<String, String> requestMap) {
        return requestMap.containsKey("name")
                && requestMap.containsKey("contact")
                && requestMap.containsKey("emailId")
                && requestMap.containsKey("password");
    }

    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setEmailId(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setContact(requestMap.get("contact"));
        user.setStatus("false");
        return user;
    }
}
