package com.vat.service;

import org.springframework.stereotype.Service;

@Service
public class VatService {


    public Double calculateVAT(Double gross, Double vatRate) {
        return gross / (1 + (1 / vatRate)) ;
    }
}
