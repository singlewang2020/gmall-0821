package com.atguigu.gmall.oms.mapper;

import com.atguigu.gmall.oms.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单
 * 
 * @author XiangYu
 * @email 1457720646@qq.com
 * @date 2021-02-28 11:18:29
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {
	int updateStatus(@Param("orderToken")String orderToken,@Param("expectStatus")Integer expectStatus,@Param("targetStatus")Integer targetStatus);
}
