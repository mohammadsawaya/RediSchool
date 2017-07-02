package com.myexperience.service;

import antlr.collections.impl.LList;
import com.myexperience.domain.Rating;
import com.myexperience.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Mohammad on 07.06.2017.
 */
@Service
public class RatingService  {
    @Autowired
    private RatingRepository ratingRepository;

    public Rating addRating(Rating rating){
       rating.setCreatedDate(new Date());
        return this.ratingRepository.save(rating);

    }
    public List<Rating> findAll(){
        return this.ratingRepository.findAll();
    }

    public List<Rating> findByRatingGreaterThan(int greaterthan){


            return this.ratingRepository.findByRatingGreaterThan(greaterthan);
        }


}
