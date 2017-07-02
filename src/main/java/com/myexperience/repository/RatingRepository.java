package com.myexperience.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myexperience.domain.Rating;

import java.util.List;

/**
 * Created by Mohammad on 07.06.2017.
 */
@Repository("RatingRepository")
public interface RatingRepository extends JpaRepository<Rating,Long> {
List<Rating> findByRatingGreaterThan(int rating);
}

