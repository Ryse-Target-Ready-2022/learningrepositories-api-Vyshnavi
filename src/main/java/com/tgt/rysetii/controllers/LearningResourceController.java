package com.tgt.rysetii.controllers;

import com.tgt.rysetii.entity.LearningResource;
import com.tgt.rysetii.service.LearningResourceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/learningresources/v1")
public class LearningResourceController {

    private final LearningResourceService learningResourceService;
    public LearningResourceController(LearningResourceService learningResourceService)
    {
        this.learningResourceService=learningResourceService;
    }
    @GetMapping("/")
    public List<LearningResource> getAllLearningResources()
    {
        return learningResourceService.getLearningResources();
    }

    @GetMapping("/{learningResourceId}")
    public Optional<LearningResource> getAllLearningResources(@PathVariable int learningResourceId)
    {
        return learningResourceService.getLearningResourcesById(learningResourceId);
    }

    @PostMapping(value="/",consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveLearningResources(@RequestBody List<LearningResource> learningResources)
    {
        learningResourceService.saveLearningResources(learningResources);
    }

    @DeleteMapping(value="/learningresource/{learningResourceId}")
    public void deleteLearningResource(@PathVariable int learningResourceId)
    {
        learningResourceService.deleteLearningResourceById(learningResourceId);
    }



}
