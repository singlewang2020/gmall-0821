package com.atguigu.gmall.pms;

import com.atguigu.gmall.pms.mapper.SkuMapper;
import com.atguigu.gmall.pms.service.SkuAttrValueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GmallPmsApplicationTests {

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private SkuAttrValueService attrValueService;

    @Test
    void contextLoads() {
//        // 查询出spu下所有的sku
//        List<SkuEntity> skuEntities = this.skuMapper.selectList(new QueryWrapper<SkuEntity>().eq("spu_Id", 41));
//        // 搜索所有的skuId
//        List<Long> skuIds = skuEntities.stream().map(SkuEntity::getId).collect(Collectors.toList());
//        // 查询sku对应的销售属性
//        List<SkuAttrValueEntity> skuAttrValueEntities = this.attrValueService.list(new QueryWrapper<SkuAttrValueEntity>().in("sku_id", skuIds).orderByAsc("attr_id"));
//        // 以attrId分组: attrId-Key  List<SkuAttrValueEntity>-value
//        Map<Object, List<SkuAttrValueEntity>> map = skuAttrValueEntities.stream().collect(Collectors.groupingBy(t ->t.getAttrId()));
//        System.out.println(map);
        System.out.println(this.attrValueService.querySaleAttrsBySpuId(41l));
    }

}
