package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.service.AttrGroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class SkuAttrValueMapperTest {

    @Autowired
    private SkuAttrValueMapper attrValueMapper;


    @Test
    void querySaleAttrsMappingSkuId() {
        System.out.println(this.attrValueMapper.querySaleAttrsMappingSkuId(Arrays.asList(81l, 82l, 83l, 84l, 85l, 86l, 87l, 88l, 89l)));
    }
}