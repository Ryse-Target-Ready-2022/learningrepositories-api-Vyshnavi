package com.tgt.rysetii.service;
import com.tgt.rysetii.entity.LearningResource;
import com.tgt.rysetii.entity.LearningResourceStatus;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class LearningResourceService {

    private List<LearningResource> getLearningResources()
    {
        File learningResourceFile=new File("LearningResources.csv");
        List<LearningResource> learningResources= new ArrayList<>();
        try
        {

            FileReader fileReader=new FileReader(learningResourceFile);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line=null;
            line= bufferedReader.readLine();
            while(line!=null)
            {
                String[] attributes=line.split(",");
                LearningResource learningResource=createLearningResource(attributes);
                learningResources.add(learningResource);
                line= bufferedReader.readLine();
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return learningResources;
    }

    private LearningResource createLearningResource(String[] attributes) {
        int id=Integer.parseInt(attributes[0].replaceAll("//D",""));
        String name=attributes[1];
        Double costPrice=Double.parseDouble(attributes[2]);
        Double sellingPrice=Double.parseDouble(attributes[3]);
        LearningResourceStatus learningResourceStatus= LearningResourceStatus.valueOf(attributes[4]);
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate createdDate=LocalDate.parse(attributes[5],dateTimeFormatter);
        LocalDate publishedDate=LocalDate.parse(attributes[6],dateTimeFormatter);
        LocalDate retiredDate=LocalDate.parse(attributes[7],dateTimeFormatter);
        LearningResource learningResource= new LearningResource(id, name, costPrice, sellingPrice, learningResourceStatus, createdDate, publishedDate, retiredDate);
        return learningResource;
    }
    public void saveLearningResources(List<LearningResource> learningResources)
    {
        final String csvDelimiter=",";
        try
        {
            File learningResourceFile=new File("LearningResources.csv");
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(learningResourceFile.getName(),true));
            for(LearningResource learningResource:learningResources)
            {
                bufferedWriter.newLine();
                StringBuffer line=new StringBuffer();
                line.append(learningResource.getId());
                line.append(csvDelimiter);
                line.append(learningResource.getName());
                line.append(csvDelimiter);
                line.append(learningResource.getCostPrice());
                line.append(csvDelimiter);
                line.append(learningResource.getSellingPrice());
                line.append(csvDelimiter);
                line.append(learningResource.getLearningResourceStatus());
                line.append(csvDelimiter);
                line.append(learningResource.getCreatedDate());
                line.append(csvDelimiter);
                line.append(learningResource.getPublishedDate());
                line.append(csvDelimiter);
                line.append(learningResource.getRetiredDate());
                bufferedWriter.write(line.toString());
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
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
}
