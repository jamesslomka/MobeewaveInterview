package com.mobeewave.airport.model;

/**
 *  Custom model for YUL nested response
 */

public class LandingTrack {
    private String landingTrackId;
    private boolean Occupied;

    public String getLandingTrackId() {
        return landingTrackId;
    }

    public void setLandingTrackId(String landingTrackId) {
        this.landingTrackId = landingTrackId;
    }

    public boolean isOccupied() {
        return Occupied;
    }

    public void setOccupied(boolean occupied) {
        Occupied = occupied;
    }
}
