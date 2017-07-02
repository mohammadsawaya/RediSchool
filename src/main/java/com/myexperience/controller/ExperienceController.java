package com.myexperience.controller;

import com.myexperience.domain.Experience;
import com.myexperience.service.ExperienceService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Mohammad on 12.06.2017.
 */
@RestController
@RequestMapping(value = "/{version}/myexperience", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;
    @RequestMapping(value = "/experience", method = RequestMethod.GET)
    public ResponseEntity<List<Experience>> getAllExperience(
            @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version
    )
    {
        List<Experience> ExperienceList = experienceService.findAll();
        return new ResponseEntity<>(ExperienceList, HttpStatus.OK);
    }

    @RequestMapping(value = "/experience", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Experience create(@RequestBody Experience experience, @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version)
    {
        return experienceService.add(experience);

    }

    @RequestMapping(value = "/experience/lastweek", method = RequestMethod.GET)
    public ResponseEntity<List<Experience>> getAllExperienceGreatedLastWeek(
            @ApiParam(name = "version", defaultValue = "v1") @PathVariable("version") String version


    )
    {
        List<Experience> experienceListForLastWeek = experienceService.findByStartDateAfter();
        return new ResponseEntity<>(experienceListForLastWeek, HttpStatus.OK);
    }
}

