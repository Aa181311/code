package com.hixtrip.sample.app.api;

import com.hixtrip.sample.domain.order.model.QuGoodsSku;

/**
 * sku的service层
 *
 */
public interface GoodsSkuService {
    QuGoodsSku getOne(String skuId);
}
