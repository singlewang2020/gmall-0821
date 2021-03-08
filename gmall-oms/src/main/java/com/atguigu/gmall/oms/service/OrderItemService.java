package com.atguigu.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;
import com.atguigu.gmall.oms.entity.OrderItemEntity;

/**
 * 订单项信息
 *
 * @author XiangYu
 * @email 1457720646@qq.com
 * @date 2021-02-28 11:18:29
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageResultVo queryPage(PageParamVo paramVo);
}

