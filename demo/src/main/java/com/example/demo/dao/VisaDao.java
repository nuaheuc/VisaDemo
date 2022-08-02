package com.example.demo.dao;

import com.example.demo.model.Status;
import com.example.demo.model.Visa;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public interface VisaDao {

    int insertVisa(UUID id, Visa visa);

    default int addVisa(Visa visa){

        UUID id = UUID.randomUUID();
        visa.setStatus(Status.READY);
        return insertVisa(id, visa);
    }
    public List<Visa> processReadyVisas();
    public void updateStatus(HashMap<UUID, Visa> hm);
}
