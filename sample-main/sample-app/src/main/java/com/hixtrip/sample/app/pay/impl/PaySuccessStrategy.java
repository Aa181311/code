package com.hixtrip.sample.app.pay.impl;

import com.hixtrip.sample.app.pay.PayCallbackStrategy;
import com.hixtrip.sample.client.order.dto.CommandPayDTO;

public class PaySuccessStrategy implements PayCallbackStrategy {
    @Override
    public String handlePayCallback(CommandPayDTO commandPayDTO) {
        // 处理支付成功逻辑
        return "支付成功处理逻辑";
    }
}
