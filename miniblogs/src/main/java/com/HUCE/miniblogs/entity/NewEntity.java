package com.HUCE.miniblogs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "New")
public class NewEntity {
    @Id
    @Column(name="id",nullable = false)
    private String id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="summary",nullable = false)
    private String summary;

    @Column(name="content",nullable = false)
    private String content;

    @Column(name="image",nullable = false)
    private String image;

    @Column(name="createdate",nullable = false)
    private String createdate;

    @Column(name="cetogory",nullable = false)
    private String cetogory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCetogory() {
        return cetogory;
    }

    public void setCetogory(String cetogory) {
        this.cetogory = cetogory;
    }
}
