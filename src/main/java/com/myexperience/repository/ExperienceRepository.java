package com.myexperience.repository;

import com.myexperience.domain.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Mohammad on 07.06.2017.
 */
@Repository("ExperienceRepository")
public interface ExperienceRepository extends JpaRepository <Experience,Long> {
    List<Experience> findByCreatedDateAfter(Date curentDate);

}
