package com.myexperience.domain;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * Created by Mohammad on 07.06.2017.
 */
@Entity
@Table(name = "Rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true,nullable = false,precision = 19)
    private long Id;

    @Column(name = "rating",nullable = false,length = 255)
    private int rating;

    @Column(name = "comment" ,nullable = false,length = 255)
    private String comment;

    @Column(name = "createdDate",nullable = false,length = 255)
    private Date createdDate;

    public Rating(){}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreatedDate() {
        return createdDate.toString();
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
