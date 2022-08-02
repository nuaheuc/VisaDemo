package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.util.UUID;

public class Visa {

    private final UUID _id;
    @NotBlank
    private final String _number;
    @Min(value= 2022, message="must be equal or greater than 2022")
    private final int _year;
    @NotNull
    private Month _month;
    private Status _status;

    public Visa(@JsonProperty("id") UUID id, @JsonProperty("number") String number,
                @JsonProperty("month") Month month, @JsonProperty("year") int year,
                @JsonProperty("status") Status status){
        _id = id;
        _number = number;
        _month = month;
        _year = year;
        _status = status;
    }
    public Visa(Visa visa){

        _id = visa._id;
        _number = visa._number;
        _month = visa._month;
        _year = visa._year;
        _status = visa._status;
    }
    public UUID getId(){
        return _id;
    }
    public String getNumber(){
        return _number;
    }
    public Month getMonth(){
        return _month;
    }
    public int getYear(){
        return _year;
    }
    public Status getStatus(){
        return _status;
    }
    public void setStatus(Status status){
        _status = status;
    }
    @Override
    public String toString(){
        return  "Id: " + _id + "\n" +
                "Visa number: " + _number.substring(0,6) +
                "******" + _number.substring(_number.length() - 4) + "\n" +
                "Status: " + _status + "\n" +
                "Month: " + _month + "\n" +
                "Year: " + _year;
    }
}
