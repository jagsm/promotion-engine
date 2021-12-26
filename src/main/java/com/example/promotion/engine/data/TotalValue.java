package com.example.promotion.engine.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.example.promotion.engine.DemoConstants.TOTAL_VALUE;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TotalValue {

    @JsonProperty(TOTAL_VALUE)
    private Integer totalValue;

    public TotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getTotalValue() {
        return totalValue;
    }
}
