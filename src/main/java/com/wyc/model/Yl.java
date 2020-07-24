package com.wyc.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 2019/07/30
 */
@Entity
@Table(name = "t_yl")
public class Yl {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Yl() {
    }

    @Override
    public String toString() {
        return "Yl{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
