package com.atguigu.gmall.index.controller;

import com.atguigu.gmall.common.bean.ResponseVo;
import com.atguigu.gmall.index.service.IndexService;
import com.atguigu.gmall.pms.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;

    @GetMapping
    public String toIndex(Model model){
        List<CategoryEntity> categories = this.indexService.queryLvl1Categories();
        model.addAttribute("categories",categories);

        // TODO: 加载其他数据
        return "index";
    }

    @GetMapping("/index/cates/{pid}")
    @ResponseBody
    public ResponseVo<List<CategoryEntity>> queryLvl2CategoriesWithSubsByPid(@PathVariable("pid")Long pid){
        List<CategoryEntity> categoryEntities = this.indexService.queryLvl2CategoriesWithSubsByPid(pid);
        return ResponseVo.ok(categoryEntities);
    }

    @GetMapping("index/test/lock")
    @ResponseBody
    public ResponseVo testLock(){
        this.indexService.testLock();
        return ResponseVo.ok();
    }

    @GetMapping("index/test/read")
    @ResponseBody
    public ResponseVo testRead(){
        this.indexService.testRead();
        return ResponseVo.ok("测试读方法。。。。。。");
    }

    @GetMapping("index/test/write")
    @ResponseBody
    public ResponseVo testWrite(){
        this.indexService.testWrite();
        return ResponseVo.ok("测试读方法。。。。。。");
    }

    @GetMapping("index/test/latch")
    @ResponseBody
    public ResponseVo testLatch(){
        this.indexService.testLatch();
        return ResponseVo.ok("班长锁门了。。。。。。");
    }

    @GetMapping("index/test/countdown")
    @ResponseBody
    public ResponseVo testCountDown(){
        this.indexService.testCountDown();
        return ResponseVo.ok("出来了一位同学=======");
    }
}
