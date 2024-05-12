package com.paf.socialmedia.repository.mealplan;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.paf.socialmedia.dto.MealPlanDTO;
public interface MealPlanRepository extends MongoRepository<MealPlanDTO, String> {
}
