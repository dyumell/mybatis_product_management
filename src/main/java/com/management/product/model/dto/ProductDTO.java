package com.management.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString @AllArgsConstructor
public class ProductDTO implements Serializable {
    // 롬복 어노테이션으로 게터 / 세터 / 투스트링 / 모든 파라미터를 받는 생성자 대체
    private String productCode;

    private String productName;

    private String originalCost;

    private String releaseDate;

    private String discountRate;

    private String salesQuantity;

    private String stockQuantity;

    private String categoryCode;

    private String productionStatus;

    public ProductDTO() {}
}
