package com.example.promotion.engine.util;

import com.example.promotion.engine.data.Price;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * config class to read the prices and promotions
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "server")
public class PriceConfig {

    private Map<String, Price>  priceMap;

    public Map<String, Price> getPriceMap() {
        return priceMap;
    }

    public void setPriceMap(Map<String, Price> priceMap) {
        this.priceMap = priceMap;
    }

    public Price getPrice(final String type){
        final Price price = this.getPriceMap().get(type);
        return price;
    }
}
