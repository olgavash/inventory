package com.inventory.dto;


import com.inventory.models.CountSheet;

import java.util.ArrayList;

public class CountSheetListDto {

    private ArrayList<CountSheet> counts;

    public CountSheetListDto() {
        this.counts = new ArrayList<>();
    }

    public CountSheetListDto(ArrayList<CountSheet> counts) {
        this.counts = counts;
    }

    public ArrayList<CountSheet> getCounts() {
        return counts;
    }

    public void setCounts(ArrayList<CountSheet> counts) {
        this.counts = counts;
    }

    public void addCount(CountSheet count) {
        this.counts.add(count);
    }

    public int size() {
        int size = counts.size();
        return size;
    }
}