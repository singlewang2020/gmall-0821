package com.atguigu.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.pms.entity.SkuAttrValueEntity;

import java.util.Map;

/**
 * sku销售属性&值
 *
 * @author XiangYu
 * @email 1457720646@qq.com
 * @date 2021-01-18 19:05:27
 */
public interface SkuAttrValueService extends IService<SkuAttrValueEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}
