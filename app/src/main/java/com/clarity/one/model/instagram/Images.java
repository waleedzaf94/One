package com.clarity.one.model.instagram;

/**
 * Created by Waleed on 7/24/2015.
 */
public class Images {

    private ImageDetails low_resolution;
    private ImageDetails thumbnail;
    private ImageDetails standard_resolution;

    public ImageDetails getLow_resolution() {
        return low_resolution;
    }

    public void setLow_resolution(ImageDetails low_resolution) {
        this.low_resolution = low_resolution;
    }

    public ImageDetails getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageDetails thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ImageDetails getStandard_resolution() {
        return standard_resolution;
    }

    public void setStandard_resolution(ImageDetails standard_resolution) {
        this.standard_resolution = standard_resolution;
    }
}
