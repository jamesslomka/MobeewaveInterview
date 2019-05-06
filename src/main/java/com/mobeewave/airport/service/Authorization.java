package com.mobeewave.airport.service;

import com.mobeewave.airport.model.LHR;
import com.mobeewave.airport.model.LandingTrack;
import com.mobeewave.airport.model.LandingTrackList;
import com.mobeewave.airport.model.YUL;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;

public class Authorization {

    /**
     * Logic for YUL Airport
     * @param airport
     * @return ArrayList<String> where index 0: permission gr anted (yes/no)
     *                                 index 1: track id
     */
    public ArrayList<String> isGrantedYUL(String airport){
        ArrayList<String> returnGrant = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        if(airport.equals("YUL")){
            YUL yul = restTemplate.getForObject("http://yulairport.mobeewave-hive.com:8082/v1/traffic/portair1234",YUL.class);

            assert yul != null;
            ArrayList<LandingTrack> landingTrackId = yul.getLandingTrack();

            double capacity  = yul.getNumberOfPlaneAtTerminal()/yul.getTotalNumberOfTerminal();
            String freeTrack = null;

            for (int i = 0; i <landingTrackId.size() ; i++) {
                if(!landingTrackId.get(i).isOccupied()){
                    freeTrack = landingTrackId.get(i).getLandingTrackId();
                }
            }

            if(!yul.isEmergency() && capacity < .9  ){
                returnGrant.add("yes");
                returnGrant.add((freeTrack));

            }
            else{
                returnGrant.add("no");
                returnGrant.add(null);
            }
        }
        return returnGrant;
    }

    /**
     * Logic for LHR Airport
     * @param airport
     * @return ArrayList<String> where index 0: permission granted (yes/no)
     *                                 index 1: track id
     */
    public ArrayList<String> isGrantedLHR(String airport){

        ArrayList<String> returnGrant = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();

        if(airport.equals("LHR")){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HashMap<String, String> map= new HashMap<>();
            map.put("Username", "Portair");
            map.put("Password","pa$$worD");

            HttpEntity<HashMap<String, String>> request = new HttpEntity<HashMap<String, String>>(map, headers);

            String url = "http://lhrairport.mobeewave-hive.com:8081/api/traffic";
            LHR lhr = restTemplate.postForObject(url,request,LHR.class);

            // For debug and sanity check
            // System.out.println(lhr.getStatusCode());

            ArrayList<LandingTrackList> landingTrackLists = lhr.getLandingTrackList();
            ArrayList<Integer> landingSize = lhr.getPlaneOnTrack();
            double capacity = lhr.getNumberOfGateOccupied() / lhr.getTotalNumberOfTerminal();

            int freeTrackPointer=0;
            String freeTrack;
            for (int i = 0; i <landingSize.size() ; i++) {
                if (landingSize.get(i)== 0){
                    freeTrackPointer= i;
                    break;
                }
            }
            freeTrack = landingTrackLists.get(freeTrackPointer).getName();

            if(!lhr.isEmergency() && capacity < 0.9 ){
                returnGrant.add("yes");
                returnGrant.add(freeTrack);
            }
            else{
                returnGrant.add("no");
                returnGrant.add(null);
            }

        }

        return returnGrant;
    }

}
