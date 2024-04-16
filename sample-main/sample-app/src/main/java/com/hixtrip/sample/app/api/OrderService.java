package com.hixtrip.sample.app.api;

import com.hixtrip.sample.client.order.dto.CommandOderCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 订单的service层
 */
public interface OrderService {

    /**
     * 创建订单
     * @param param 请求参数
     * @return
     */
    String createOrder(CommandOderCreateDTO param);
}
