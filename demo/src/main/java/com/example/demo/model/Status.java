package com.example.demo.model;

public enum Status {
    READY("Ready"),
    PROCESSING("Processing"),
    DONE("Done");

    String status;

    Status(String status){
        this.status = status;
    }

}
