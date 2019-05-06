package com.mobeewave.airport.controller;

import com.mobeewave.airport.service.Authorization;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@EnableAutoConfiguration
public class AuthorizationController {

     HashMap<String,String> returnRequest = new HashMap<>();

    /**
     *
     * @param request : POST via /v1/landing/authorization endpoint
     * @return application/json: with two keys, permissionGranted and trackId
     */
    @RequestMapping(produces = "application/json",value ="v1/landing/authorization", method = RequestMethod.POST)
    private HashMap<String,String> request(@RequestBody HashMap<String, String> request){

        ArrayList<String> granted;

        Authorization authorization = new Authorization();

        if(request.get("AirPort").equals("YUL")){
             granted = authorization.isGrantedYUL(request.get("AirPort"));
        }
        else if(request.get("AirPort").equals("LHR")){
             granted = authorization.isGrantedLHR(request.get("AirPort"));
        }
        else{
            throw new IllegalArgumentException("Airport must be codes YUL or LHR!");
        }

        returnRequest.put("permissionGranted",granted.get(0));
        returnRequest.put("trackId",granted.get(1));

        return returnRequest;
    }
}
