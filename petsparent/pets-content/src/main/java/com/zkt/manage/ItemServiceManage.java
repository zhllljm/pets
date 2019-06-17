package com.zkt.manage;

import com.zkt.entitys.ItemCat;
import com.zkt.entitys.Items;
import com.zkt.entitys.Manager;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ItemServiceManage {

    /**
     * ItemCat表接口方法
     *
     * @return
     */
    List<ItemCat> getItemCatList();

    ItemCat getItemCatById(int id);

    Map<String, Object> insertItemCat(ItemCat itemCat , MultipartFile file);

    Map<String, Object> updateItemCat(ItemCat itemCat);

    Map<String, Object> deleteItemCatById(Integer[] id);

    Map<String, Object> deleteItemCat(int id);

    /**
     * Items表接口方法
     *
     * @return
     */
    List<Items> getItemList();

    Items getItemById(int wareid);

    Map<String, Object> saveimg(MultipartFile file, int wareid);

    int saveItem(Items items);

    Map<String, Object> updateItem(Items items);

    Map<String, Object> deleteItem(int[] wareid);

    Map<String,Object> deleteItemTo0(int[] wareid);

    Map<String,Object> deleteItem0(int wareid);

    /**
     * itemcat关联items 一对多查询
     */
    List<ItemCat> getItemCatAndItemsList();

    public List<Items> getItemBycid(int cid);

    /**
     *  用户登录
     */
    public Manager queryUserLogin(Manager manager);

}
