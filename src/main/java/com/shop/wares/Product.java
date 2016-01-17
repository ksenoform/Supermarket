package com.shop.wares;

import java.math.BigDecimal;

/**
 * Created by RSzczygielski on 17.01.16.
 */
public interface Product {
    public String getId();
    public void setId(String id);
    public String getName();
    public void setName(String name);
    public BigDecimal getNetPrice();
    public void setNetPrice(BigDecimal netPrice);
    public BigDecimal getTax();
    public void setTax(BigDecimal tax);
    public BigDecimal getTotalPrice();
}
