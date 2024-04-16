package com.hixtrip.sample.domain.order.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
public class QuGoodsSku  {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private String id;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 规格信息json
     */
    private String specs;
    /**
     * 规格信息
     */
    private String simpleSpecs;
    /**
     * 配送模版id
     */
    private String freightTemplateId;
    /**
     * 是否是促销商品
     */
    private Boolean promotionFlag;
    /**
     * 促销价
     */
    private Double promotionPrice;
    /**
     * 原价
     */
    private Double reservedPrice;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品编号
     */
    private String sn;
    /**
     * 品牌id
     */
    private String brandId;
    /**
     * 分类path
     */
    private String categoryPath;
    /**
     * 计量单位
     */
    private String goodsUnit;

    /**
     * 重量
     */
    private Double weight;
    /**
     * 上架状态
     */
    private String marketEnable;

    /**
     * 商品价格
     */
    private Double price;
    /**
     * 成本价格
     */
    private Double cost;
    /**
     * 购买数量
     */
    private Integer buyCount;
    /**
     * 库存
     */
    private Integer quantity;
    /**
     * SPU编码
     */
    private String goodsSn;


}
