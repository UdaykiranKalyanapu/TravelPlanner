package com.inn.travel.com.inn.travel.restImpl;

import com.inn.travel.com.inn.travel.constents.TravelConstants;
import com.inn.travel.com.inn.travel.rest.UserRest;
import com.inn.travel.com.inn.travel.service.UserService;
import com.inn.travel.com.inn.travel.utils.TravelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@Service
public class UserRestImpl implements UserRest {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<String> signup(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return TravelUtils.getResponseEntity(TravelConstants.errormessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
