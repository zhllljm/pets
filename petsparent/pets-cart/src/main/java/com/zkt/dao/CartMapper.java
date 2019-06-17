package com.zkt.dao;

import com.zkt.entitys.Cart;
import com.zkt.entitys.Items;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {

    /**
     * 查询当前用户所有购物车信息
     *
     * @param userId 用户id
     * @return
     */
    List<Items> getCartList(int userId);


    /**
     * 加入购物车
     *
     * @param pronum 商品数量
     * @param userId 用户id
     * @param wareId 商品id
     * @return
     */
    @Insert("insert into cart values(null,#{pronum},#{userId},#{wareId})")
    void insertCart(@Param("pronum")int pronum,@Param("userId") int userId,@Param("wareId") int wareId);


    /**
     * 删除购物车信息
     *
     * @param userId 用户id
     * @param wareid 商品id
     * @return
     */
    @Delete("delete from cart where userId=#{userId} and wareId=#{wareId}")
    void deleteCartItem(int userId, int wareid);

    /**
     * 清空当前用户购物车
     *
     * @param userId 用户id
     * @return
     */
    @Delete("delete from cart where userId=#{userId}")
    void clearCartItem(int userId);

    @Select("select * from cart where userId=#{userId} and wareId=#{wareId}")
    Cart selectCart(@Param("userId") int userId,@Param("wareId") int wareId);

    @Update("update cart set pronum=pronum+#{pronum} where wareId=#{wareId}")
    void upnum(@Param("pronum")int pronum,@Param("wareId") int wareId);
}
