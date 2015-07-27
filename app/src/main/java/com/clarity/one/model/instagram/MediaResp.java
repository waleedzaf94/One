package com.clarity.one.model.instagram;

/**
 * Created by Waleed on 7/24/2015.
 */
public class MediaResp {

    private Meta meta;
    private MediaObject data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public MediaObject getData() {
        return data;
    }

    public void setData(MediaObject data) {
        this.data = data;
    }
}
