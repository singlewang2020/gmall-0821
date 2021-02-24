package com.atguigu.gmall.item.vo;

import com.atguigu.gmall.pms.entity.CategoryEntity;
import com.atguigu.gmall.pms.vo.ItemGroupVo;
import com.atguigu.gmall.pms.vo.SaleAttrValueVo;
import com.atguigu.gmall.pms.entity.SkuImagesEntity;
import com.atguigu.gmall.sms.vo.ItemSaleVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class ItemVo {
    // 1.面包屑： 分类
    private List<CategoryEntity> categories;

    // 2. 3.面包屑： 品牌
    private Long brandId;
    private String brandName;

    //4. 5.面包屑： spu
    private Long spuId;
    private String SpuName;

    // 6.7.8.9.10.11.中间的sku信息
    private Long skuId;
    private String title;
    private String subtitle;
    private BigDecimal price;
    private String defaultImage;
    private Integer weight;

    // 12.图片列表
    private List<SkuImagesEntity> images;

    // 13.营销信息
    private List<ItemSaleVo> sales;

    // 14.库存信息
    private Boolean store = false;

    // [{attrId:4, attrName: '颜色', attrValues: ['暗夜黑', '白天白']},
    // {attrId:5, attrName: '内存', attrValues: ['8G', '12G']},
    // {attrId:6, attrName: '存储', attrValues: ['128G', '256G']}]
    //15.跟当前sku相同的spu下的所有sku的营销属性列表
    private List<SaleAttrValueVo> saleAttrs;

    // {4: '暗夜黑', 5: '8G', 6: '128G'}
    // 16.当前sku的销售参数
    private Map<Long, Object> saleAttr;

    // 17.销售属性组合和skuId的映射关系
    // {'暗夜黑,8G,128G': 10, '白天白,12G,128G': 11}
    private String  skuJsons;

    //18.商品海报信息
    private List<String> spuImages;

    // 19.规格参数分组列表
    private List<ItemGroupVo> groups;
}
