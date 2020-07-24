package com.wyc.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 2019/07/30
 */
@Entity
@Table(name = "t_photo")
public class Photo{

    @Id
    @GeneratedValue
    private Long id;
    private String dz;
    private String message;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", dz='" + dz + '\'' +
                ", message='" + message + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Photo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
