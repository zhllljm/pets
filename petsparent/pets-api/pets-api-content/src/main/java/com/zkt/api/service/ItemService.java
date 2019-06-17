package com.zkt.api.service;

import com.zkt.entitys.ItemCat;
import com.zkt.entitys.Items;
import com.zkt.entitys.Manager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RequestMapping("content")
public interface ItemService {

    /**
     * ItemCat表接口方法
     *
     * @return
     */
    @RequestMapping("item/cat/list")
    List<ItemCat> getItemCatList();

    @PostMapping("item/cat/get")
    ItemCat getItemCatById(int id);


    @PostMapping(value = "uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String, Object> insertItemCat(@RequestPart("file") MultipartFile file,@RequestParam("name") String name );

    @PostMapping("/updateItemCat")
    Map<String, Object> updateItemCat(ItemCat itemCat);

    @PostMapping("/deleteItemCat")
    Map<String, Object> deleteItemCatById(Integer[] id);

    @PostMapping("/deleteItemCatById")
    Map<String, Object> deleteItemCat(int id);


    /**
     * Items表接口方法
     *
     * @return
     */
    @RequestMapping("item/list")
    List<Items> getItemList();

    @PostMapping("/item/get")
    Items getItemById(int wareid);

    @PostMapping("/item/gets")
    Items getItemsById(@RequestParam("wareid") int wareid);

    @PostMapping(value = "/saveImg",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<String, Object> saveImg(@RequestPart(value = "file")MultipartFile file,@RequestParam("wareid") int wareid);

    @PostMapping(value = "/saveItem")
    int saveItem(@RequestBody Items items);

    @PostMapping("/updateItem")
    Map<String, Object> updateItem(Items items);

    @PostMapping("/deleteItem")
    Map<String, Object> deleteItem(int[] wareid);

    @PostMapping("/deleteItemTo0")
    Map<String, Object> deleteItemTo0(int[] wareid);
    @PostMapping("/deleteItem0")
    Map<String,Object> deleteItem0(int wareid);

    /**
     * itemcat关联items 一对多查询
     */
    @PostMapping("/getItemCatAndItemsList")
    List<ItemCat> getItemCatAndItemsList();

    @PostMapping("/getItemBycid")
    List<Items> getItemBycid(@RequestParam ("cid") int cid);

    /**
     *  用户登录
     */
    @PostMapping("/localss")
    public Manager queryUserLogin(@RequestBody Manager manager);


}
