package com.hixtrip.sample.app.pay.impl;

import com.hixtrip.sample.app.pay.PayCallbackStrategy;
import com.hixtrip.sample.client.order.dto.CommandPayDTO;

public class DuplicatePayStrategy implements PayCallbackStrategy {
    @Override
    public String handlePayCallback(CommandPayDTO commandPayDTO) {
        // 处理重复支付逻辑
        return "重复支付处理逻辑";
    }
}
