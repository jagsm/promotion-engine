package com.example.promotion.engine.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName("price")
public class Price {

    @JsonProperty
    private Integer price;

    @JsonProperty
    private Integer promotion;

    @JsonProperty
    private Integer promotionPrice;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public Integer getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Integer promotionPrice) {
        this.promotionPrice = promotionPrice;
    }
}
