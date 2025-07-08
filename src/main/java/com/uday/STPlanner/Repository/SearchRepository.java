package com.uday.STPlanner.Repository;

import com.uday.STPlanner.model.Tours;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchRepository {

    List<Tours> findTours (String text);
}
