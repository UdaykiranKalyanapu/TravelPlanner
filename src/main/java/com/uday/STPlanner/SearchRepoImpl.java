package com.uday.STPlanner;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.uday.STPlanner.Repository.SearchRepository;
import com.uday.STPlanner.model.Tours;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class SearchRepoImpl implements SearchRepository {

    @Autowired
    MongoClient client;
@Autowired
    MongoConverter convertor;

    @Override
    public List<Tours> findTours(String text){
        final List<Tours> tours = new ArrayList<>();



        MongoDatabase database = client.getDatabase("tours");
        MongoCollection<Document> collection = database.getCollection("toursavailable");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", "countryName")))));
        result.forEach(item -> tours.add(convertor.read(Tours.class,item)));
        return tours;


    }
}
