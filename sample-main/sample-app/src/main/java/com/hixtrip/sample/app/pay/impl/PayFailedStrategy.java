package com.hixtrip.sample.app.pay.impl;

import com.hixtrip.sample.app.pay.PayCallbackStrategy;
import com.hixtrip.sample.client.order.dto.CommandPayDTO;

public class PayFailedStrategy implements PayCallbackStrategy {
    @Override
    public String handlePayCallback(CommandPayDTO commandPayDTO) {
        // 处理支付失败逻辑
        return "支付失败处理逻辑";
    }
}
