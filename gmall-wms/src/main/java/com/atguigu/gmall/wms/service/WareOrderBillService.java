package com.atguigu.gmall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.wms.entity.WareOrderBillEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author XiangYu
 * @email 1457720646@qq.com
 * @date 2021-01-22 11:09:32
 */
public interface WareOrderBillService extends IService<WareOrderBillEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

