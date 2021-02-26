package com.atguigu.gmall.search.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.atguigu.gmall.search.pojo.Goods;

public interface GoodsRepository extends ElasticsearchRepository<Goods, Long> {
}
