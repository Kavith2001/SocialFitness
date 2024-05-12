package com.paf.socialmedia.dto;

import java.util.Arrays;

public class MealPlanDTO {
    private String name;
    private String desc;
    private int cal;
    private String food[];

    public MealPlanDTO() {
    }

    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public String[] getFood() {
        return food;
    }

    public void setFood(String[] food) {
        this.food = food;
    }


    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", cal=" + cal +
                ", food=" + Arrays.toString(food) +
                '}';
    }
}
