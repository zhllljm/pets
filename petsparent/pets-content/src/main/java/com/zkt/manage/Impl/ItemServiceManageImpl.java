package com.zkt.manage.Impl;

import com.zkt.common.api.BaseApiService;
import com.zkt.common.file.CommonFileUtil;
import com.zkt.constants.Constants;
import com.zkt.dao.ItemMapper;
import com.zkt.entitys.ItemCat;
import com.zkt.entitys.Items;
import com.zkt.entitys.Manager;
import com.zkt.entitys.Wareimg;
import com.zkt.manage.ItemServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ItemServiceManageImpl extends BaseApiService implements ItemServiceManage {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private CommonFileUtil commonFileUtil;



    /**
     * 功能描述: itemcat表的ItemServiceManage接口实现
     *
     * @param:
     * @return:
     * @auther: zqq
     * @date: 2019/5/17 21:04
     */
    @Override
    public List<ItemCat> getItemCatList() {
        System.out.println("进入Service层");
        List<ItemCat> list = itemMapper.getItemCatList();
        System.out.println(list);
        return itemMapper.getItemCatList();
    }

    @Override
    public ItemCat getItemCatById(int id) {
        System.out.println("进入Service层");
        ItemCat itemCat = itemMapper.getItemCatById(id);
        System.out.println(itemCat);
        return itemMapper.getItemCatById(id);
    }

    @Override
    public Map<String, Object> insertItemCat(ItemCat itemCat , MultipartFile file) {

        log.info("进入逻辑层====分类"+itemCat+"文件"+file);

        String img=uoloadFileToFast(file);
        log.info("img路径"+img);
        String nweImg= Constants.F_W_IP+img;
        itemCat.setImg(nweImg);
        log.info("数据"+itemCat);
        itemMapper.insertItemCat(itemCat);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> updateItemCat(ItemCat itemCat) {
        itemMapper.updateItemCat(itemCat);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> deleteItemCatById(Integer[] id) {
        for (int ids :
                id) {
            itemMapper.deleteItem(ids);
        }
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> deleteItemCat(int id) {
        itemMapper.deleteItemCat(id);
        return setResultSuccess();
    }

    /**
     * 功能描述:  items表ItemServiceManage接口实现
     *
     * @param:
     * @return:
     * @auther: zqq
     * @date: 2019/5/17 21:06
     */
    @Override
    public List<Items> getItemList() {
        log.info("进入逻辑实现层");
        System.out.println("进入逻辑实现层");
        List<Items> itemsList = itemMapper.getItemList();
        return itemsList;
    }

    @Override
    public Items getItemById(int wareid) {
        log.info("进入逻辑实现层");
        System.out.println("进入逻辑实现层");
        Items items = itemMapper.getItemById(wareid);
        return items;
    }

    @Override
    public Map<String, Object> saveimg(MultipartFile file, int wareid) {
        log.info("进入逻辑层==商品"+wareid+"文件"+file);

        String img=uoloadFileToFast(file);
        log.info("img路径"+img);
        String nweImg= Constants.F_W_IP+img;
        Wareimg wareimg=new Wareimg();
        wareimg.setLimg(nweImg);
        wareimg.setWareid(wareid);
        log.info("数据"+wareimg);
        itemMapper.saveImg(wareimg);
        return setResultSuccess();
    }

    @Override
    public int saveItem(Items items) {
        log.info("进入逻辑实现层--items为" + items);
        items.setWarestatus('1');
         itemMapper.saveItem(items);
        log.info("获取的id大大大大" + items.getWareid());
        return items.getWareid();
    }

    @Override
    public Map<String, Object> updateItem(Items items) {
        itemMapper.updateItem(items);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> deleteItem(int[] wareid) {
        for (int ids :
                wareid) {
            itemMapper.deleteItem(ids);
        }

        return setResultSuccess();
    }

    @Override
    public Map<String, Object> deleteItemTo0(int[] wareid) {
        for (int ids :
                wareid) {
            itemMapper.deleteItem(ids);
        }
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> deleteItem0(int wareid) {
        itemMapper.deleteItem0(wareid);
        return setResultSuccess();
    }


    public String uoloadFileToFast(MultipartFile file) {
        try{
            if (file.isEmpty()){
                log.info("文件不存在");
            }
            String path=null;
            path=commonFileUtil.uploadFile(file);
            log.info("文件路径"+path);
            return path;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ItemCat> getItemCatAndItemsList() {
        log.info("进入逻辑层getItemCatAndItemsList()");
        List<ItemCat> itemCats = itemMapper.getItemCatAndItemsList();
        for (ItemCat item:
             itemCats) {
            System.out.println(item);
        }
        return itemCats;
    }

    @Override
    public List<Items> getItemBycid(int cid) {
        return itemMapper.getItemBycid(cid);
    }


    @Override
    public Manager queryUserLogin(Manager manager) {
        return itemMapper.queryUserLogin(manager);
    }
}
