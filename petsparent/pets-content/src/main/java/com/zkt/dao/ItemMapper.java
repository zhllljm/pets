package com.zkt.dao;

import com.zkt.entitys.ItemCat;
import com.zkt.entitys.Items;
import com.zkt.entitys.Manager;
import com.zkt.entitys.Wareimg;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ItemMapper {

    /**
     * ItemCat表接口方法
     *
     * @return
     */
    @Select("select * from itemcat")
    List<ItemCat> getItemCatList();

    @Select("select * from itemcat where id=#{id}")
    ItemCat getItemCatById(int id);

    @Insert("insert into itemcat values(null,#{name},#{img})")
    void insertItemCat(ItemCat itemCat);

    @Update("update itemcat set name=#{name},img=#{img} where id=#{id}")
    void updateItemCat(ItemCat itemCat);

    @Delete("delete from itemcat where id=#{id}")
    void deleteItemCatId(int id);

    @Delete("delete from itemcat where id=#{id}")
    void deleteItemCat(int id);

    /**
     * Items表接口方法
     *
     * @return
     */
    List<Items> getItemList();

    Items getItemById(int wareid);

    int saveItem(Items items);

    @Update("update items set warename=#{warename},proprice=#{proprice},warefreight=#{warefreight},wareimg=#{wareimg},cid=#{cid} where wareid=#{wareid}")
    void updateItem(Items items);

    @Delete("delete from items where wareid=#{wareid}")
    void deleteItem(int wareid);

    @Update("update items set warestatus='0' where wareid=#{wareid}")
    void deleteItemTo0(int[] wareid);

    @Update("update items set warestatus='0' where wareid=#{wareid}")
    void deleteItem0(int wareid);

    @Insert("insert into wareimg values(null,#{limg},#{wareid})")
    void saveImg(Wareimg wareimg);

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
