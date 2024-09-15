package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import javax.print.PrintService;
import java.util.List;
import java.util.Map;

public class ProductController {

    private final ProductService productService = new ProductService();
    private final ProductPrint productPrint = new ProductPrint();

    public void selectAllProductList() {
        List<ProductDTO> productList = productService.selectAllProductList();
        if (productList.isEmpty()) {
            productPrint.printErrorMessage("제품 목록이 없습니다.");
        } else {
            productPrint.printAllProductList(productList);
        }
    }

    public void selectProductByCondition(SearchCondition searchCondition) {
        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);
        if(productList.isEmpty()) {
            productPrint.printErrorMessage("제품 목록이 없습니다.");
        } else {
            productPrint.printProductList(productList, searchCondition);
        }
    }

    public void registNewProduct(ProductDTO product) {
        String code = product.getProductCode();
        String name = product.getProductName();
        String originalCost = product.getOriginalCost();
        String discountRate = product.getDiscountRate();
        String stockQuantity = product.getStockQuantity();
        String categoryCode = product.getCategoryCode();

        String releaseDate = product.getReleaseDate().replace("-", "");
        String productionStatus = "Y";
        String saleQuantity = "0";

        ProductDTO newProduct = new ProductDTO(
                code, name, originalCost, releaseDate, discountRate,
                saleQuantity, stockQuantity, categoryCode, productionStatus);


        if (productService.registNewProduct(newProduct)) {
            productPrint.printSuccessMessage("상품 등록 성공");
        } else {
            productPrint.printErrorMessage("상품 등록 실패");
        }

    }


    public void modifyProductInfo(ProductDTO product) {
        String code = product.getProductCode();
        String name = product.getProductName();
        String originalCost = product.getOriginalCost();
        String discountRate = product.getDiscountRate();
        String stockQuantity = product.getStockQuantity();
        String categoryCode = product.getCategoryCode();

        String releaseDate = product.getReleaseDate().replace("-", "");
        String productionStatus = product.getProductionStatus();
        String saleQuantity = product.getSalesQuantity();

        ProductDTO newProduct = new ProductDTO(
                code, name, originalCost, releaseDate, discountRate,
                saleQuantity, stockQuantity, categoryCode, productionStatus);


        if (productService.modifyProductInfo(newProduct)) {
            productPrint.printSuccessMessage("상품 수정 성공");
        } else {
            productPrint.printErrorMessage("상품 수정 실패");
        }
    }

    public void deleteProduct(Map<String, String> parameter) {
        if (productService.deleteProduct(parameter)) {
            productPrint.printSuccessMessage("상품 삭제 성공");
        } else {
            productPrint.printErrorMessage("상품 삭제 실패");
        }
    }
}
