package com.example.promotion.engine.service;

import com.example.promotion.engine.PromotionEngineApplication;
import com.example.promotion.engine.data.OrderRequest;
import com.example.promotion.engine.data.Price;
import com.example.promotion.engine.data.TotalValue;
import com.example.promotion.engine.serivce.PromotionEngineService;
import com.example.promotion.engine.serivce.PromotionEngineServiceImpl;
import com.example.promotion.engine.util.PriceConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {PromotionEngineApplication.class})
public class PromotionEngineServiceImplTest {

    @Autowired
    private PromotionEngineService serviceUnderTest;

    @Autowired
    private PriceConfig priceConfig;

    @Before
    public void setup() throws FileNotFoundException, IOException {
        try (FileInputStream fis = new FileInputStream(new File("src/main/resources/application.yml"))) {
            final Yaml yaml = new Yaml();
            final Iterable<Object> itr = yaml.loadAll(fis);
            final Map<String, Price> prices = new HashMap<>();
            for (final Object o : itr) {
                final LinkedHashMap<String, Object> serverConfig = (LinkedHashMap<String, Object>) ((LinkedHashMap<String, Object>) o).get("server");
                for (final Map.Entry<String, Object> priceMap : ((LinkedHashMap<String, Object>) serverConfig.get("pricemap")).entrySet()) {
                    final LinkedHashMap<String, Object> value = (LinkedHashMap<String, Object>) priceMap.getValue();
                    final Price price = new Price();
                    price.setPrice((Integer) value.get("price"));
                    price.setPromotion((Integer) value.get("promotion"));
                    price.setPromotionPrice((Integer) value.get("promotionPrice"));
                    prices.put(priceMap.getKey(), price);
                }
            }
            priceConfig.setPriceMap(prices);
        }
        serviceUnderTest = new PromotionEngineServiceImpl();
        ReflectionTestUtils.setField(serviceUnderTest, "priceConfig", priceConfig);
    }

    @Test
    public void testScenarioA() throws Exception {
        final OrderRequest orderRequest = new OrderRequest(1,1,1,0);
        final TotalValue totalValue = serviceUnderTest.calculateTotal(orderRequest);
        Assert.assertEquals(totalValue.getTotalValue() , new Integer(100));
    }
    @Test
    public void testScenarioB() throws Exception {
        final OrderRequest orderRequest = new OrderRequest(5,5,1,0);
        final TotalValue totalValue = serviceUnderTest.calculateTotal(orderRequest);
        Assert.assertEquals(totalValue.getTotalValue() , new Integer(370));
    }
    @Test
    public void testScenarioC() throws Exception {
        final OrderRequest orderRequest = new OrderRequest(3,5,1,1);
        final TotalValue totalValue = serviceUnderTest.calculateTotal(orderRequest);
        Assert.assertEquals(totalValue.getTotalValue() , new Integer(280));
    }
    @Test
    public void testCheckCAndDPromotionAppliedInTotal() throws Exception {
        final OrderRequest orderRequest = new OrderRequest(0,0,1,1);
        final TotalValue totalValue = serviceUnderTest.calculateTotal(orderRequest);
        Assert.assertEquals(totalValue.getTotalValue() , new Integer(30));
    }

    @Test
    public void testCheckAPromotionAppliedInTotal() throws Exception {
        final OrderRequest orderRequest = new OrderRequest(3,0,0,0);
        final TotalValue totalValue = serviceUnderTest.calculateTotal(orderRequest);
        Assert.assertEquals(totalValue.getTotalValue() , new Integer(130));
    }

    @Test
    public void testCheckBPromotionAppliedInTotal() throws Exception {
        final OrderRequest orderRequest = new OrderRequest(0,2,0,0);
        final TotalValue totalValue = serviceUnderTest.calculateTotal(orderRequest);
        Assert.assertEquals(totalValue.getTotalValue() , new Integer(45));
    }
}