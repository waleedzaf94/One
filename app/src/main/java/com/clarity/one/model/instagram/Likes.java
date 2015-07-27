package com.clarity.one.model.instagram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waleed on 7/24/2015.
 */
public class Likes {

    private int count;
    private List<User> data = new ArrayList<>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
