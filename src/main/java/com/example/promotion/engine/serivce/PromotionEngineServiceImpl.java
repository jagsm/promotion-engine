package com.example.promotion.engine.serivce;

import com.example.promotion.engine.data.OrderRequest;
import com.example.promotion.engine.data.TotalValue;
import com.example.promotion.engine.util.PriceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.promotion.engine.DemoConstants.*;

/**
 * Service Implementation class for {@link PromotionEngineService}
 */
@Service
public class PromotionEngineServiceImpl implements PromotionEngineService {

    @Autowired
    private PriceConfig priceConfig;

    /**
     * calculate and returns the total value for an order request with configured price and promotions {@link PriceConfig}
     * @param orderRequest - orderRequest
     * @return
     */
    @Override
    public TotalValue calculateTotal(final OrderRequest orderRequest) {

        final Integer orderAType = orderRequest.getOrderAType();
        final Integer orderBType = orderRequest.getOrderBType();
        final Integer orderCType = orderRequest.getOrderCType();
        final Integer orderDType = orderRequest.getOrderDType();

        final Integer orderAPrice = orderAType !=null ? getPrice(ORDER_A_TYPE, orderRequest.getOrderAType()) : 0;
        final Integer orderBPrice = orderBType !=null ? getPrice(ORDER_B_TYPE, orderRequest.getOrderBType()) : 0;

        if (orderCType != null && orderDType != null) {
            if(orderCType == orderDType){
                return new TotalValue(orderAPrice+orderBPrice+getPrice(ORDER_CD_TYPE, orderDType));
            }else if(orderCType > orderDType){
                final Integer orderCDPrice = getPrice(ORDER_CD_TYPE, orderDType);
                final Integer  orderCPriceWithoutPromotion = getPrice(ORDER_C_TYPE, orderCType-orderDType);
                return new TotalValue(orderAPrice+orderBPrice+orderCDPrice+orderCPriceWithoutPromotion);
            }else {
                final Integer orderCDPrice = getPrice(ORDER_CD_TYPE, orderCType);
                final Integer  orderDPriceWithoutPromotion = getPrice(ORDER_D_TYPE, orderDType-orderCType);
                return new TotalValue(orderAPrice+orderBPrice+orderCDPrice + orderDPriceWithoutPromotion);
            }
        }
        final Integer orderCPrice = orderCType !=null ? getPrice(ORDER_C_TYPE, orderRequest.getOrderCType()) : 0;
        final Integer orderDPrice = orderDType !=null ? getPrice(ORDER_D_TYPE, orderRequest.getOrderDType()) : 0;
        return new TotalValue(orderAPrice+orderBPrice+orderCPrice+orderDPrice);
    }

    /**
     * calculate the value bases on price config
     * @param itemType - Item Type
     * @param orderSize - No of items
     * @return - Total value
     */
    private Integer getPrice(final String itemType, final Integer orderSize ){
        final Integer price = priceConfig.getPrice(itemType).getPrice();
        final Integer promotion = priceConfig.getPrice(itemType).getPromotion();
        final Integer promotionPrice = priceConfig.getPrice(itemType).getPromotionPrice();
        return (orderSize / promotion) * promotionPrice + (orderSize % promotion * price);
    }
}
