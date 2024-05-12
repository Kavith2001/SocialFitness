package com.paf.socialmedia.repository.mealplan;

import com.paf.socialmedia.dto.MealPlanDTO;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;


    @Override
    public List<MealPlanDTO> findByText(String text) {

        final List<MealPlanDTO> mealPlan = new ArrayList<>();

        MongoDatabase database = client.getDatabase("socialmedia");
        MongoCollection<Document> collection = database.getCollection("MealPlan");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        result.forEach(doc -> mealPlan.add(converter.read(MealPlanDTO.class,doc)));

        return mealPlan;
    }
}
