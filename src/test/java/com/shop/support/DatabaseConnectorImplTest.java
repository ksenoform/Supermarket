package com.shop.support;

import com.shop.wares.Product;
import com.shop.wares.ProductBuilderImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.spi.InjectService;
import org.junit.Before;
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
    private DatabaseConnector databaseConnector = new DatabaseConnectorImpl();;
    private Product product = new ProductBuilderImpl().build();
    private List<Product> listOfProduct = new ArrayList<>(Arrays.asList(product));

    @Test
    public void shouldReturnMapWithProductAndAmount() throws Exception {
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);
        Mockito.when(query.list()).thenReturn(listOfProduct);

        Map<Product, Integer> result = databaseConnector.readFromDatabase();

        assertEquals(new Integer(1), result.get(product));
    }

    @Test
    public void shouldReturnEmptyMapIfListOfProductIsEmpty() throws Exception {
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);
        Mockito.when(query.list()).thenReturn(Collections.emptyList());

        Map<Product, Integer> result = databaseConnector.readFromDatabase();

        assertEquals(Collections.emptyMap(), result);
    }

    @Test
    public void verifyIfMethodResponsibilityForWritingToDatabaseIsCold() {
        DatabaseConnector databaseConnectorSpy = Mockito.spy(databaseConnector);
        Mockito.doNothing().when(databaseConnectorSpy).writeToDatabase(product);

        databaseConnectorSpy.writeToDatabase(product);

        Mockito.verify(databaseConnectorSpy, Mockito.atLeastOnce()).writeToDatabase(product);
    }
}