package com.example.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public enum Month {

    DEFAULT("00"), JANUARY("01"), FEBRUARY("02"),
    MARCH("03"), APRIL("04"),
    MAY("05"), JUNE("06"),
    JULY("07"), AUGUST("08"),
    SEPTEMBER("09"), OCTOBER("10"),
    NOVEMBER("11"), DECEMBER("12");

    String monthNumber;

    Month(String monthNumber){
        this.monthNumber = monthNumber;
    }
}
