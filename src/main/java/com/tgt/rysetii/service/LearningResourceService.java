package com.tgt.rysetii.service;

import com.tgt.rysetii.entity.LearningResource;
import com.tgt.rysetii.repository.LearningResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
@Service
public class LearningResourceService {

    private final LearningResourceRepository learningResourceRepository;

    public LearningResourceService(LearningResourceRepository learningResourceRepository)
    {this.learningResourceRepository=learningResourceRepository;}


    public List<LearningResource> getLearningResources()
    {
        return learningResourceRepository.findAll();
    }
    public void saveLearningResources(List<LearningResource> learningResources)
    {
        for(LearningResource learningResource:learningResources)
            learningResourceRepository.save(learningResource);
    }
    public List<Double> getProfitMargin()
    {
        List<LearningResource> learningResources=getLearningResources();
        List<Double> profitMargins=learningResources.stream()
                .map(lr->((lr.getSellingPrice()-lr.getCostPrice())/lr.getSellingPrice())).collect(toList());
        return profitMargins;
    }
    public List<LearningResource> sortLearningResourcesByProfitMargin()
    {
        List<LearningResource> learningResources=getLearningResources();
        learningResources.sort((lr1,lr2)->{
            Double profitMargin1=(lr1.getSellingPrice()-lr1.getCostPrice())/lr1.getSellingPrice();
            Double profitMargin2=(lr1.getSellingPrice()-lr1.getCostPrice())/lr1.getSellingPrice();
            return profitMargin2.compareTo(profitMargin1);
        });
        return learningResources;
    }

    public void deleteLearningResourceById(int learningResourceId) {
        learningResourceRepository.deleteById(learningResourceId);
    }

}
