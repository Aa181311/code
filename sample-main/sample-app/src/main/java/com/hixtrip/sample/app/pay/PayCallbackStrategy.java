package com.hixtrip.sample.app.pay;

import com.hixtrip.sample.client.order.dto.CommandPayDTO;

public interface PayCallbackStrategy {
    String handlePayCallback(CommandPayDTO commandPayDTO);
}
