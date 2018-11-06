package com.codeup.project.models;

import javax.persistence.*;

@Entity
@Table(name="ad_images")
public class Image {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post post;

    public Image() {
    }

    public Image(String path, Post post) {
        this.path = path;
        this.post = post;
    }

    public Image(long id, String path, Post post) {
        this.path = path;
        this.post = post;
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Post getPost() {
        return post;
    }

    public void setAd(Post post) {
        this.post = post;
    }
}
