package com.tgt.rysetii;

import com.tgt.rysetii.entity.LearningResource;
import com.tgt.rysetii.repository.LearningResourceRepository;
import com.tgt.rysetii.service.LearningResourceService;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.tgt.rysetii.entity.LearningResourceStatus.PUBLISHED;

@SpringBootApplication
public class LearningresourcesApiSaiVyshnaviApplication {

	public static void main(String[] args) {
       SpringApplication.run(LearningresourcesApiSaiVyshnaviApplication.class, args);
        /*LearningResourceService lr = (LearningResourceService)factory.getBean("learningResourceService");
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LearningResource l1=new LearningResource(1,"Sai",200,300,PUBLISHED, LocalDate.of(2020,12,23),LocalDate.now(),LocalDate.of(2022,2,12));
        LearningResource l2=new LearningResource(2,"Sai",200,300,PUBLISHED, LocalDate.of(2020,12,23),LocalDate.now(),LocalDate.of(2022,2,12));
        LearningResource l3=new LearningResource(3,"Sai",200,300,PUBLISHED, LocalDate.of(2020,12,23),LocalDate.now(),LocalDate.of(2022,2,12));
        List<LearningResource> l=new ArrayList<LearningResource>();
        l.add(l1);
        l.add(l2);
        l.add(l3);
		lr.saveLearningResources(l);*/

	}

}
