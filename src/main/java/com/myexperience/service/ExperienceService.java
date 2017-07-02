package com.myexperience.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.myexperience.domain.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myexperience.repository.ExperienceRepository;




/**
 * Created by Mohammad on 12.06.2017.
 */
@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    public Experience add(Experience experience)
    {

        experience.setCreatedDate(new Date());
        if(experience.getBody().length() > 5) {
            experience.setBody(experience.getBody());
            return this.experienceRepository.save(experience);

        }
        else
            return null;
    }

    public List<Experience> findAll()
    {
        return this.experienceRepository.findAll();
    }

    public List<Experience> findByStartDateAfter(){

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -7);
        dt = c.getTime();
        return this.experienceRepository.findByCreatedDateAfter(dt);
    }

}
