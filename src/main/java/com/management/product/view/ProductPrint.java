package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {
    public void printAllProductList(List<ProductDTO> allProductList) {
        for (ProductDTO productDTO : allProductList) {
            System.out.println(productDTO);
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {
        System.out.println(searchCondition.getOption() + " 로 검색한 결과 :");
        for (ProductDTO productDTO : productList) {
            System.out.println(productDTO);
        }
    }

    public void printSuccessMessage(String successCode) {
        System.out.println(successCode);
    }

    public void printErrorMessage(String errorCode) {
        System.out.println(errorCode);
    }

}
