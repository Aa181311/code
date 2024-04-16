package com.hixtrip.sample.entry;

import com.hixtrip.sample.app.api.OrderService;
import com.hixtrip.sample.app.pay.PayCallbackStrategy;
import com.hixtrip.sample.app.pay.impl.DuplicatePayStrategy;
import com.hixtrip.sample.app.pay.impl.PayFailedStrategy;
import com.hixtrip.sample.app.pay.impl.PaySuccessStrategy;
import com.hixtrip.sample.client.order.dto.CommandOderCreateDTO;
import com.hixtrip.sample.client.order.dto.CommandPayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * todo 这是你要实现的
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    private final Map<String, PayCallbackStrategy> strategyMap = new HashMap<>();

    public OrderController() {
        // 初始化策略映射
        strategyMap.put("success", new PaySuccessStrategy());
        strategyMap.put("failed", new PayFailedStrategy());
        strategyMap.put("duplicate", new DuplicatePayStrategy());
    }

    /**
     * todo 这是你要实现的接口
     *
     * @param commandOderCreateDTO 入参对象
     * @return 请修改出参对象
     */
    @PostMapping(path = "/command/order/create")
    public String order(@RequestBody CommandOderCreateDTO commandOderCreateDTO) {
        //登录信息可以在这里模拟
        var userId = "1";
        commandOderCreateDTO.setUserId(userId);
        return  orderService.createOrder(commandOderCreateDTO);
    }

    /**
     * todo 这是模拟创建订单后，支付结果的回调通知
     * 【中、高级要求】需要使用策略模式处理至少三种场景：支付成功、支付失败、重复支付(自行设计回调报文进行重复判定)
     *
     * @param commandPayDTO 入参对象
     * @return 请修改出参对象
     */
    @PostMapping(path = "/command/order/pay/callback")
    public String payCallback(@RequestBody CommandPayDTO commandPayDTO) {
        PayCallbackStrategy strategy = strategyMap.get(commandPayDTO.getPayStatus());
        strategy.handlePayCallback(commandPayDTO);
        return "";
    }

}
