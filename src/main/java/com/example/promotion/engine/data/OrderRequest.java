package com.example.promotion.engine.data;

import static com.example.promotion.engine.DemoConstants.ORDER_A_TYPE;
import static com.example.promotion.engine.DemoConstants.ORDER_B_TYPE;
import static com.example.promotion.engine.DemoConstants.ORDER_C_TYPE;
import static com.example.promotion.engine.DemoConstants.ORDER_D_TYPE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderRequest {
    @JsonProperty(ORDER_A_TYPE)
    private Integer OrderAType;

    @JsonProperty(ORDER_B_TYPE)
    private Integer OrderBType;

    @JsonProperty(ORDER_C_TYPE)
    private Integer OrderCType;

    @JsonProperty(ORDER_D_TYPE)
    private Integer OrderDType;

    public OrderRequest(Integer orderAType, Integer orderBType, Integer orderCType, Integer orderDType) {
        OrderAType = orderAType;
        OrderBType = orderBType;
        OrderCType = orderCType;
        OrderDType = orderDType;
    }
    public Integer getOrderAType() {return OrderAType;}

    public Integer getOrderBType() {
        return OrderBType;
    }

    public Integer getOrderCType() {
        return OrderCType;
    }

    public Integer getOrderDType() {
        return OrderDType;
    }

}
