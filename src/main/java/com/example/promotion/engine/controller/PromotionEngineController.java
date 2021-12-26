package com.example.promotion.engine.controller;

import com.example.promotion.engine.data.OrderRequest;
import com.example.promotion.engine.data.TotalValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.promotion.engine.serivce.PromotionEngineService;

/**
 * The {@link PromotionEngineController} class handles PromotionEngine api exposed REST endpoints
 */
@RestController
@Validated
public class PromotionEngineController {

    @Autowired
    private PromotionEngineService promotionEngineService;

    @PostMapping("/orders/order")
    public TotalValue order(@RequestBody final OrderRequest orderRequest){
       return  promotionEngineService.calculateTotal(orderRequest);

    }
}
