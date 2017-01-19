package com.shop.service.local;

import com.shop.domain.Product;
import com.shop.hibernate.interfaces.ProductDAO;
import com.shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by Robert Szczygielski on 17.01.16.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

    @Autowired
    public void getProductAccess(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List getListOfAllProduct() {
        return productDAO.getListOfAllProduct();
    }

    @Override
    public void writeProductToBase(Product product) {
        productDAO.writeProductToBase(product);
    }

    @Override
    public List getAllProduct() {
        List productList = productDAO.getListOfAllProduct();
        return productList.isEmpty() ? Collections.EMPTY_LIST : productList;
    }

    @Override
    public Product getProductByID(Integer id) {
        Product product = productDAO.getProductById(id);
        return product != null
                ? product
                : new ProductBuilderImpl().build();
    }

    @Override
    public Product getProductByName(String name) {
        Product product = productDAO.getProductByName(name);
        return product != null
                ? product
                : new ProductBuilderImpl().build();
    }

    @Override
    public void putNewProductToWarehouse(Product product) {
        productDAO.writeProductToBase(product);
    }

    @Override
    public void addItemToProduct(Integer productId, Integer item) {
        Product product = productDAO.getProductById(productId);
        item = product.getItems() + item;
        product.setItems(item);
        productDAO.writeProductToBase(product);
    }

    @Override
    public void subItemFromProduct(Integer productId, Integer item) {
        Product product = productDAO.getProductById(productId);
        item = product.getItems() - item;
        product.setItems(item);
        productDAO.writeProductToBase(product);
    }

    @Override
    public String toString() {
        StringBuilder dataWitchAmount = new StringBuilder();
        final List<Product> products = productDAO.getListOfAllProduct();

        for (Product product : products) {
            dataWitchAmount.append(product);
            dataWitchAmount.append("\n");
        }

        return dataWitchAmount.toString();
    }
}
