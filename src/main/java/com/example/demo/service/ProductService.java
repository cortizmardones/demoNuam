package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ResultBusinessLogic;

public interface ProductService {

    boolean matchesCompanyRut(String companyRut);
    ResultBusinessLogic applySpecificBusinessLogic(ProductRequest request);

}
