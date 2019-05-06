package com.mobeewave.airport.model;

import java.util.ArrayList;

/**
 *  Custom model for LHR endpoint response object
 */
public class LHR implements Airport {

    private boolean Emergency;
    private int TotalNumberOfTerminal;
    private double numberOfGateOccupied;
    ArrayList<LandingTrackList> landingTrackList;
    ArrayList<Integer> planeOnTrack;

    public ArrayList<Integer> getPlaneOnTrack() {
        return planeOnTrack;
    }

    public void setPlaneOnTrack(ArrayList<Integer> planeOnTrack) {
        this.planeOnTrack = planeOnTrack;
    }

    public boolean isEmergency() {
        return Emergency;
    }

    public void setEmergency(boolean emergency) {
        Emergency = emergency;
    }

    public int getTotalNumberOfTerminal() {
        return TotalNumberOfTerminal;
    }

    public void setTotalNumberOfTerminal(int totalNumberOfTerminal) {
        TotalNumberOfTerminal = totalNumberOfTerminal;
    }

    public double getNumberOfGateOccupied() {
        return numberOfGateOccupied;
    }

    public void setNumberOfGateOccupied(double numberOfGateOccupied) {
        this.numberOfGateOccupied = numberOfGateOccupied;
    }

    public ArrayList<LandingTrackList> getLandingTrackList() {
        return landingTrackList;
    }

    public void setLandingTrackList(ArrayList<LandingTrackList> landingTrackList) {
        this.landingTrackList = landingTrackList;
    }
}
