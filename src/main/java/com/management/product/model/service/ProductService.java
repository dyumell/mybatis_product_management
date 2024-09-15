package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        try (SqlSession sqlSession = com.common.Template.getSqlSession()) {
            productDAO = sqlSession.getMapper(ProductDAO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ProductDTO> selectAllProductList() {
        try (SqlSession sqlSession = com.common.Template.getSqlSession()) {
            productDAO = sqlSession.getMapper(ProductDAO.class);
            return productDAO.selectAllProductList();
        }
    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {
        try (SqlSession sqlSession = com.common.Template.getSqlSession()) {
            productDAO = sqlSession.getMapper(ProductDAO.class);
            return productDAO.selectProductByCondition(searchCondition);
        }
    }

    public boolean registNewProduct(ProductDTO product) {
        try ( SqlSession sqlSession = com.common.Template.getSqlSession() ) {
            int result = productDAO.insertProduct(product);
            sqlSession.commit();
            return result > 0;
        }
    }

    public boolean modifyProductInfo(ProductDTO product) {
        try (SqlSession sqlSession = com.common.Template.getSqlSession()) {
            int result = productDAO.updateProduct(product);
            sqlSession.commit();
            return result > 0;
        }
    }

    public boolean deleteProduct(Map<String, String> parameter) {
        try (SqlSession sqlSession = com.common.Template.getSqlSession()) {
            String productCode = parameter.get("productCode");
            int result = productDAO.deleteProduct(productCode);
            sqlSession.commit();
            return result > 0;
        }
    }
}
