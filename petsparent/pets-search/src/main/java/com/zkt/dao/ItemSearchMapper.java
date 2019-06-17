package com.zkt.dao;

import com.zkt.entity.SearchItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemSearchMapper {
    /**
     * 查询searchItem所有信息
     * @return
     */
    public List<SearchItem> getAllList();

    SearchItem getItemById(long itemId);
}
