package com.clarity.one.model.instagram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waleed on 7/24/2015.
 */
public class Comments {

    private int count;
    private List<Caption> data = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Caption> getData() {
        return data;
    }

    public void setData(List<Caption> data) {
        this.data = data;
    }
}
