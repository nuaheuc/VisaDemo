package com.example.demo.dao;

import com.example.demo.model.Status;
import com.example.demo.model.Visa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeVisaDataAccessService implements VisaDao{

    private static List<Visa> DB = new ArrayList<>();
    @Override
    public int insertVisa(UUID id, Visa visa) {

        Visa visaWithId = new Visa(id, visa.getNumber(), visa.getMonth(), visa.getYear(), visa.getStatus());
        System.out.println(visaWithId);
        DB.add(visaWithId);
        return 1;
    }

    @Override
    public synchronized int addVisa(Visa visa) {
        return VisaDao.super.addVisa(visa);
    }

    @Override
    public List<Visa> processReadyVisas() {

        List<Visa> readyVisas = new ArrayList<>();

        for(Visa visa: DB)
            if(visa.getStatus().equals(Status.READY))
                readyVisas.add(visa);

        return readyVisas;
    }

    public List<Visa> selectReady() {
        List<Visa> readies = new ArrayList<>();

        for(Visa visa: DB)
            if(visa.getStatus() == Status.READY) {
                visa.setStatus(Status.PROCESSING);
                readies.add(new Visa(visa));
            }
        return readies;
    }
    @Override
    public void updateStatus(HashMap<UUID, Visa> hm){

        for(Visa visa: DB)
            if(hm.containsKey(visa.getId()))
                visa.setStatus(hm.get(visa.getId()).getStatus());
    }
}
