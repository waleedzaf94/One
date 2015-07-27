package com.clarity.one.model.instagram;

/**
 * Created by Waleed on 7/24/2015.
 */
public class Videos {

    private VideoObject low_bandwith;
    private VideoObject standard_resolution;
    private VideoObject low_resolution;

    public VideoObject getLow_bandwith() {
        return low_bandwith;
    }

    public void setLow_bandwith(VideoObject low_bandwith) {
        this.low_bandwith = low_bandwith;
    }

    public VideoObject getStandard_resolution() {
        return standard_resolution;
    }

    public void setStandard_resolution(VideoObject standard_resolution) {
        this.standard_resolution = standard_resolution;
    }

    public VideoObject getLow_resolution() {
        return low_resolution;
    }

    public void setLow_resolution(VideoObject low_resolution) {
        this.low_resolution = low_resolution;
    }
}
