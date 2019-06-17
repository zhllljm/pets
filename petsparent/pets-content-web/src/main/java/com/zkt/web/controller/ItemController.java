package com.zkt.web.controller;

import com.zkt.entitys.ItemCat;
import com.zkt.entitys.Items;
import com.zkt.entitys.Manager;
import com.zkt.web.feign.ItemFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ItemController {

    @Autowired
    private ItemFeign itemFeign;


    /**
     * 功能描述:    itemcat表控制层返回
     *
     * @param:
     * @return:
     * @auther: zqq
     * @date: 2019/5/17 21:16
     */
    @GetMapping("/getItemcat")
    public List<ItemCat> getItemCatList() {
        log.info("进入商品分类");
        return itemFeign.getItemCatList();
    }

    @PostMapping("/getItemCatById")
    public ItemCat getItemCatById(int id) {
        ItemCat itemCat = itemFeign.getItemCatById(id);
        System.out.println("进入编辑页面");
        log.info("商品分类数据"+itemCat);
        return itemCat;
    }

    @PostMapping("/insertItemCat")
    public Map<String, Object> insertItemCat(ItemCat itemCat,MultipartFile file) {
        log.info("返回数据"+itemCat+"文件数据"+file);
        Map<String, Object> list=itemFeign.insertItemCat(file,itemCat.getName());
        return list;
    }

    @PostMapping("/updateItemCat")
    public Map<String, Object> updateItemCat(ItemCat itemCat) {

        return itemFeign.updateItemCat(itemCat);
    }

    @PostMapping("/deleteItemCat")
    public Map<String, Object> deleteItemCatById(Integer[] cks) {
        System.out.println("商品id为"+cks);
        return itemFeign.deleteItemCatById(cks);
    }

    @PostMapping("deleteItemCatById")
    public Map<String, Object> deleteItemCat(int id) {
        return itemFeign.deleteItemCat(id);
    }

    /**
     * 功能描述:    items表控制层返回
     *
     * @return:  List<Items>
     * @auther: zqq
     * @date: 2019/5/17 21:17
     */
    @GetMapping("/getItems")
    public List<Items> getItemList() {
        log.info("进入商品表");
        List<Items> list=itemFeign.getItemList();
        log.info("商品信息为"+list);
        return list;
    }

    @PostMapping("/getItemById")
    public Items getItemById( int id) {
        System.out.println("根据id查询商品数据");
        log.info("商品数据"+id);
        return itemFeign.getItemById(id);
    }

    @PostMapping("/saveItem")
    public Map<String, Object> saveItem(Items items,MultipartFile[] file) {
        log.info("item为" + items+"---添加商品返回id");
        int wareid=itemFeign.saveItem(items);
        Map<String, Object> map=null;
        for (MultipartFile files:
             file) {
            log.info("文件为" +files+"---添加图片到数据库与服务器");
            map=itemFeign.saveImg(files,wareid);
        }
        return map;
    }

    @PostMapping("/updateItem")
    public Map<String, Object> updateItem(Items items) {
        return itemFeign.updateItem(items);
    }

    @PostMapping("/deleteItem")
    public Map<String, Object> deleteItem( int[] wareid) {
        log.info("删除的商品信息id"+wareid);
        return itemFeign.deleteItem(wareid);
    }

    @PostMapping("/deleteItemTo0")
    public Map<String, Object> deleteItemTo0( int[] cks) {
        log.info("下架的商品"+cks);
        return itemFeign.deleteItemTo0(cks);
    }

    @PostMapping("/deleteItem0")
    public Map<String, Object> deleteItem0(int id) {
        return itemFeign.deleteItem0(id);
    }


}
