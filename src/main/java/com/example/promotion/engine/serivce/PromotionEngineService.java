package com.example.promotion.engine.serivce;

import com.example.promotion.engine.data.OrderRequest;
import com.example.promotion.engine.data.TotalValue;

/**
 * The interface for PromotionEngineService
 */
public interface PromotionEngineService {

    /**
     * calculate the total based on order request values
     * @param orderRequest - orderRequest
     * @return - Total value
     */
    public TotalValue calculateTotal(final OrderRequest orderRequest);
}
