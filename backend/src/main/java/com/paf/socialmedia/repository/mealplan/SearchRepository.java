package com.paf.socialmedia.repository.mealplan;

import com.paf.socialmedia.dto.MealPlanDTO;

import java.util.List;
public interface SearchRepository {
    List<MealPlanDTO> findByText(String text);
}
