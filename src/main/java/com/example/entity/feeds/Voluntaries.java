package com.example.entity.feeds;

import com.example.configs.JpaArrayConverter;
import com.example.configs.JpaConverterJson;
import com.example.entity.Profile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "cl_feed_voluntaries")
public class Voluntaries implements Feed{

    @Id
    @GeneratedValue
    @Column(name = "id",nullable =false)
    Long id;

    @Column(name = "user_id",nullable =false, insertable = false, updatable = false)
     Long user_id;

    @Column(name = "title",nullable =false)
    String title;

    @Column(name = "content",nullable =false)
    String content;

    @Convert(converter = JpaArrayConverter.class)
    @Column(name = "feed_media",nullable =false)
    JSONArray feed_media;

    @Convert(converter = JpaConverterJson.class)
    @Column(name = "location",nullable =false)
    private JSONObject location;

    @Column(name = "place_id",nullable =false)
    String place_id="987";

    @Column(name = "datetime_post", nullable = false)
    Timestamp datetime_post;

    @Column(name = "datetime_start", nullable = false)
    Timestamp datetime_start;

    @Column(name = "datetime_end", nullable = false)
    Timestamp datetime_end;

    @ManyToOne
    Profile user;

    transient Integer users_joined;

    transient Integer vote_status;



    public Integer getVote_status() {
        return vote_status;
    }

    public void setVote_status(Integer vote_status) {
        this.vote_status = vote_status;
    }

    public Integer getUsers_joined() {
        return users_joined;
    }

    public void setUsers_joined(Integer users_joined) {
        this.users_joined = users_joined;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }


    public JSONObject getLocation() {
        return location;
    }

    public void setLocation(JSONObject location) {
        this.location = location;
    }



    public Voluntaries() {
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Profile getUser() {
        return user;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public void setUser(Profile user) {
        this.user = user;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public JSONArray getFeed_media() {
        return feed_media;
    }

    public void setFeed_media(JSONArray feed_media) {
        this.feed_media = feed_media;
    }

    public Timestamp getDatetime_post() {
        return datetime_post;
    }

    public void setDatetime_post(Timestamp datetime_post) {
        this.datetime_post = datetime_post;
    }

    public Timestamp getDatetime_start() {
        return datetime_start;
    }

    public void setDatetime_start(Timestamp datetime_start) {
        this.datetime_start = datetime_start;
    }

    public Timestamp getDatetime_end() {
        return datetime_end;
    }

    public void setDatetime_end(Timestamp datetime_end) {
        this.datetime_end = datetime_end;
    }

    public Voluntaries(Profile user, Long user_id, String title, String content, JSONArray feed_media, JSONObject location, String place_id, Timestamp datetime_post, Timestamp datetime_start, Timestamp datetime_end) {
        this.user = user;
        this.user_id = (long)50;
        this.title = title;
        this.content = content;
        this.feed_media = feed_media;
        this.location = location;
        this.place_id = "676";
        this.datetime_post = datetime_post;
        this.datetime_start = datetime_start;
        this.datetime_end = datetime_end;
    }

    @Override
    public String toString() {
        return "Voluntaries{" +
                "id=" + id +
                ", user_id=" + user +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", feed_media='" + feed_media + '\'' +
                ", location='" + location + '\'' +
                ", place_id='" + place_id + '\'' +
                ", date_time_post=" + datetime_post +
                ", date_time_start=" + datetime_start +
                ", date_time_end=" + datetime_end +
                '}';
    }
}