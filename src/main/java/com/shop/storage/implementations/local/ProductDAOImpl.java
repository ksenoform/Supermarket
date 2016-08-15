package com.shop.storage.implementations.local;

import com.shop.dataacces.ProductAccess;
import com.shop.model.Product;
import com.shop.storage.interfaces.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public class ProductDAOImpl implements ProductDAO {
    ProductAccess productAccess;

    @Autowired
    public void getProductAccess(ProductAccess productAccess) {
        this.productAccess = productAccess;
    }

    @Override
    public List<Product> getListOfAllProduct() {
        return productAccess.getListOfAllProduct();
    }

    @Override
    public void writeProductToBase(Product product) {
        productAccess.writeProductToBase(product);
    }
}
