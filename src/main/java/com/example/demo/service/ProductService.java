package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ResultBusinessLogic;

public interface ProductService {

    boolean validCompanyRut(String companyRut);
    ResultBusinessLogic applySpecificBusinessLogic(ProductRequest request);

}
