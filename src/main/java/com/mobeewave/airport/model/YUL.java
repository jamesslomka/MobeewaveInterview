package com.mobeewave.airport.model;

import java.util.ArrayList;

/**
 *  Custom object for YUL endpoint response
 */
public class YUL  implements Airport{

    private boolean emergency;
    private int TotalNumberOfTerminal;
    private double NumberOfPlaneAtTerminal;
    private ArrayList<LandingTrack> landingTrack;

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public int getTotalNumberOfTerminal() {
        return TotalNumberOfTerminal;
    }

    public void setTotalNumberOfTerminal(int totalNumberOfTerminal) {
        TotalNumberOfTerminal = totalNumberOfTerminal;
    }

    public double getNumberOfPlaneAtTerminal() {
        return NumberOfPlaneAtTerminal;
    }

    public void setNumberOfPlaneAtTerminal(double numberOfPlaneAtTerminal) {
        NumberOfPlaneAtTerminal = numberOfPlaneAtTerminal;
    }

    public ArrayList<LandingTrack> getLandingTrack() {
        return landingTrack;
    }

    public void setLandingTrack(ArrayList<LandingTrack> landingTrack) {
        this.landingTrack = landingTrack;
    }
}
