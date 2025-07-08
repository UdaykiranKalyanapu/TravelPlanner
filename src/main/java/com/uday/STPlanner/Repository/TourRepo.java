package com.uday.STPlanner.Repository;

import com.uday.STPlanner.model.Tours;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourRepo extends MongoRepository <Tours, String>{
}
