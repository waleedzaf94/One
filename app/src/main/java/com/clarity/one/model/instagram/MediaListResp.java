package com.clarity.one.model.instagram;

import java.util.List;

/**
 * Created by Waleed on 7/24/2015.
 */
public class MediaListResp {

    private Pagination pagination;
    private Meta meta;
    private List<MediaObject> data;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<MediaObject> getData() {
        return data;
    }

    public void setData(List<MediaObject> data) {
        this.data = data;
    }
}
