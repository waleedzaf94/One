package com.clarity.one.model.instagram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Waleed on 7/24/2015.
 */
public class MediaObject {

    private Attribution attribution;
    private List<String> tags = new ArrayList<>();
    private String type;
    private Location location;
    private Comments comments;
    private String filter;
    private String created_time;
    private String link;
    private Likes likes;
    private Images images;
    private List<UserInPhoto> users_in_photo = new ArrayList<>();
    private Caption caption;
    private boolean user_has_liked;
    private String id;
    private User user;
    private Videos videos;

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public List<UserInPhoto> getUsers_in_photo() {
        return users_in_photo;
    }

    public void setUsers_in_photo(List<UserInPhoto> users_in_photo) {
        this.users_in_photo = users_in_photo;
    }

    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public boolean isUser_has_liked() {
        return user_has_liked;
    }

    public void setUser_has_liked(boolean user_has_liked) {
        this.user_has_liked = user_has_liked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }
}
