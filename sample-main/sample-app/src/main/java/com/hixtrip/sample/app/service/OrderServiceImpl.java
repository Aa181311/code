package com.hixtrip.sample.app.service;

import com.hixtrip.sample.app.api.GoodsSkuService;
import com.hixtrip.sample.app.api.OrderService;
import com.hixtrip.sample.app.convertor.OrderConvertor;
import com.hixtrip.sample.client.order.dto.CommandOderCreateDTO;
import com.hixtrip.sample.domain.order.model.Order;
import com.hixtrip.sample.domain.order.model.QuGoodsSku;
import com.hixtrip.sample.domain.pay.PayDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * app层负责处理request请求，调用领域服务
 */
@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private GoodsSkuService goodsSkuService;
    @Autowired
    private PayDomainService payDomainService;

    @Override
    public String createOrder(CommandOderCreateDTO param) {
        //校验sku库存是否充足
        if (!checkSkuQuantity(param.getSkuId(), param.getAmount())) {
            return null;
        }
        //保存订单信息
        return save(param);
    }

    /**
     * 校验sku库存
     *
     * @param skuId
     * @param amount
     * @return
     */
    private boolean checkSkuQuantity(String skuId, Integer amount) {
        QuGoodsSku goodsSku = (QuGoodsSku) redisTemplate.opsForValue().get(skuId);
        if (StringUtils.isEmpty(goodsSku)) {
            //缓存获取不到库存信息,查询数据库sku信息,重新设置到缓存中
            QuGoodsSku one = goodsSkuService.getOne(skuId);
            if (!StringUtils.isEmpty(one)) {
                //当前库存小于购买数量
                if (one.getQuantity() < amount) {
                    return false;
                }
                //先把库存扣减下来,防止超卖,当订单创建失败时需要返回库存
                one.setQuantity(one.getQuantity() - amount);
                redisTemplate.opsForValue().set(skuId, one);
            }
        } else {
            return goodsSku.getQuantity() < amount;
        }
        return true;
    }

    private String save(CommandOderCreateDTO createDTO) {
        Order order = OrderConvertor.INSTANCE.order(createDTO);
        //保存订单信息
        return "saveOder";
    }
}
