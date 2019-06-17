package com.zkt.service.Impl;

import com.zkt.api.service.ItemService;
import com.zkt.entitys.ItemCat;
import com.zkt.entitys.Items;
import com.zkt.entitys.Manager;
import com.zkt.manage.ItemServiceManage;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemServiceManage itemServiceManage;

    /**
     * 功能描述:    itemcat表的ItemService接口实现
     *
     * @param:
     * @return:
     * @auther: zqq
     * @date: 2019/5/17 20:57
     */
    @Override
    @ApiOperation(value = "查询商品分类")
    public List<ItemCat> getItemCatList() {
        return itemServiceManage.getItemCatList();
    }

    @Override
    @ApiOperation(value = "根据id查询商品分类")
    public ItemCat getItemCatById(@RequestBody int id) {
        log.info("id"+id);
        return itemServiceManage.getItemCatById(id);
    }

    @Override
    @ApiOperation(value = "增加商品分类")
    public Map<String, Object> insertItemCat(@RequestPart("file") MultipartFile file,@RequestParam("name") String name ) {
        ItemCat itemCat=new ItemCat();
        itemCat.setName(name);
        log.info("进入controller层"+name+"分文件"+file);
        return itemServiceManage.insertItemCat(itemCat,file);
    }

    @Override
    @ApiOperation(value = "更新商品分类")
    public Map<String, Object> updateItemCat(@RequestBody ItemCat itemCat) {
        return itemServiceManage.updateItemCat(itemCat);
    }

    @Override
    @ApiOperation(value = "删除商品分类")
    public Map<String, Object> deleteItemCatById(@RequestBody Integer[] id) {
        log.info("商品id为"+id);
        return itemServiceManage.deleteItemCatById(id);
    }

    @Override
    public Map<String, Object> deleteItemCat(@RequestBody int id) {
        return itemServiceManage.deleteItemCat(id);
    }


    /**
     * 功能描述: items表ItemService接口实现
     *
     * @param:
     * @return:
     * @auther: zqq
     * @date: 2019/5/17 20:58
     */
    @Override
    @ApiOperation(value = "查询商品")
    public List<Items> getItemList() {
        return itemServiceManage.getItemList();
    }

    @Override
    @ApiOperation(value = "根据wareid查询商品")
    public Items getItemById(@RequestBody int wareid) {
        return itemServiceManage.getItemById(wareid);
    }

    @Override
    public Items getItemsById(@RequestParam("wareid") int wareid) {
        return itemServiceManage.getItemById(wareid);
    }

    @Override
    public Map<String, Object> saveImg(@RequestPart(value = "file")MultipartFile file,@RequestParam("wareid") int wareid) {
        log.info("进入Controller层" + file+"id为"+wareid);
        return itemServiceManage.saveimg(file,wareid);
    }


    @Override
    @ApiOperation(value = "增加商品")
    public int saveItem(@RequestBody Items items) {
        log.info("进入Controller层" + items);
        int wareid=itemServiceManage.saveItem(items);
        return wareid;
    }

    @Override
    @ApiOperation(value = "更新商品")
    public Map<String, Object> updateItem(@RequestBody Items items) {
        return itemServiceManage.updateItem(items);
    }

    @Override
    @ApiOperation(value = "删除商品")
    public Map<String, Object> deleteItem(@RequestBody int[] wareid) {
        return itemServiceManage.deleteItem(wareid);
    }

    @Override
    public Map<String, Object> deleteItemTo0(@RequestBody int[] wareid) {
        return itemServiceManage.deleteItemTo0(wareid);
    }

    @Override
    public Map<String, Object> deleteItem0(@RequestBody int wareid) {
        return itemServiceManage.deleteItem0(wareid);
    }


    @Override
    public List<ItemCat> getItemCatAndItemsList() {
        return itemServiceManage.getItemCatAndItemsList();
    }

    @Override
    public List<Items> getItemBycid(@RequestParam ("cid") int cid) {
        return itemServiceManage.getItemBycid(cid);
    }

    @Override
    public Manager queryUserLogin(@RequestBody Manager manager) {
        System.out.println("逻辑层：" + manager);
        return itemServiceManage.queryUserLogin(manager);
    }
}
