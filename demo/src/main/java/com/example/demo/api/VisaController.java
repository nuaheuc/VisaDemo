package com.example.demo.api;

import com.example.demo.model.Visa;
import com.example.demo.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/v1/visa")
@RestController
public class VisaController {

    private final VisaService _visaService;

    @Autowired
    private VisaController(VisaService visaService){

        _visaService = visaService;
    }
    @PostMapping
    public void addVisa(@Valid @NotNull @RequestBody Visa visa){
        _visaService.addVisa(visa);
    }
}
