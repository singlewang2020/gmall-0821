package com.atguigu.gmall.wms.service;

import com.atguigu.gmall.wms.vo.SkuLockVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.wms.entity.WareSkuEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author XiangYu
 * @email 1457720646@qq.com
 * @date 2021-01-22 11:09:32
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageResultVo queryPage(PageParamVo paramVo);

    List<SkuLockVo> checkAndLock(List<SkuLockVo> lockVos, String orderToken);
}

