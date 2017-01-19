package com.shop.hibernate;

import com.shop.hibernate.interfaces.ProductDAO;
import com.shop.domain.Product;
import com.shop.service.local.ProductBuilderImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by RSzczygielski on 04.02.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class DatabaseConnectorImplTest {
    @Mock
    private SessionFactory sessionFactory;
    @Mock
    private Session session;
    @Mock
    private Query query;
    @InjectMocks
    private ProductDAO databaseConnector = new ProductDAOImpl();
    private Product product = new ProductBuilderImpl().build();
    private List< Product> listOfProduct = new ArrayList<>(Arrays.asList(product));

    @Test
    public void shouldReturnMapWithProductAndAmount() throws Exception {
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);
        Mockito.when(query.list()).thenReturn(listOfProduct);

        List<Product> result = databaseConnector.getListOfAllProduct();

        assertEquals(product, result.get(0));
    }

    @Test
    public void shouldReturnEmptyMapIfListOfProductIsEmpty() throws Exception {
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);
        Mockito.when(query.list()).thenReturn(Collections.emptyList());

        List<Product> result = databaseConnector.getListOfAllProduct();

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void verifyIfMethodResponsibilityForWritingToDatabaseIsCold() {
        ProductDAO databaseConnectorSpy = Mockito.spy(databaseConnector);
        Mockito.doNothing().when(databaseConnectorSpy).writeProductToBase(product);

        databaseConnectorSpy.writeProductToBase(product);

        Mockito.verify(databaseConnectorSpy, Mockito.atLeastOnce()).writeProductToBase(product);
    }
}