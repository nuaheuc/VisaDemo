package com.example.demo.service;

import com.example.demo.dao.VisaDao;
import com.example.demo.model.Status;
import com.example.demo.model.Visa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class VisaService {

    private final VisaDao _visaDao;

    @Autowired
    public VisaService(@Qualifier("fakeDao") VisaDao visaDao){
        _visaDao = visaDao;
    }

    public int addVisa(Visa visa){
        return _visaDao.addVisa(visa);
    }
    
    @Scheduled(fixedDelayString = "${processDelay}")
    private synchronized void processReadyRequests(){

        List<Visa> readyVisas = _visaDao.processReadyVisas();
        HashMap<UUID, Visa> hm = new HashMap<>();
        for(Visa visa: readyVisas){

            System.out.println("Processing request: " + visa.getId());
            System.out.println("Finished processing request.");
            visa.setStatus(Status.DONE);
            hm.put(visa.getId(), visa);
        }
        _visaDao.updateStatus(hm);
    }
}
