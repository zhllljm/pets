// page/component/new-pages/cart/cart.js
Page({
  data: {
    carts: "",               // 购物车列表
    hasList: true,          // 列表是否有数据
    totalPrice: 0,           // 总价，初始为0
    selectAllStatus: "",    // 全选状态，默认全选
    obj: {
      name: "hello"
    },
    cartItems: [],
    id:"",
  },

  onLoad: function (options) {
    console.log(options)
    this.setData({
      id:options.id
    })
  },

  onShow:function () {
    var _this = this
    console.log("用户信息" + _this.data.id)
    wx.request({
      url: 'http://192.168.22.58:8768/cart/getCartList',
      data: {
        userId: _this.data.id,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'post',//定义传到后台接受的是post方法还是get方法
      success: function (res) {
        console.log("调用API成功");
        console.log(res.data)
        _this.setData({
          carts: res.data
        })
        
      },

      fail: function (res) {
        console.log("调用API失败");
      }
    })   
    this.getTotalPrice();
  },
  /**
   * 当前商品选中事件
   */
  selectList(e) {
    console.log(e);
    const index = e.currentTarget.dataset.index;
    let carts = this.data.carts;
    console.log(carts)
    const selected = carts[index].selected;
    carts[index].selected = !selected;
    console.log(selected)
    this.setData({
      carts: carts
    });
    this.getTotalPrice();
    console.log(this.data.carts)
  },

  /**
   * 删除购物车当前商品
   */
  deleteList(e) {
    const index = e.currentTarget.dataset.index;
    let carts = this.data.carts;
    carts.splice(index, 1);
    this.setData({
      carts: carts
    });
    if (!carts.length) {
      this.setData({
        hasList: false
      });
    } else {
      this.getTotalPrice();
    }
  },

  /**
   * 购物车全选事件
   */
  selectAll(e) {
    let selectAllStatus = this.data.selectAllStatus;
    selectAllStatus = !selectAllStatus;
    let carts = this.data.carts;

    for (let i = 0; i < carts.length; i++) {
      carts[i].selected = selectAllStatus;
    }
    this.setData({
      selectAllStatus: selectAllStatus,
      carts: carts
    });
    this.getTotalPrice();
    console.log(this.data.carts)
  },

  /**
   * 绑定加数量事件
   */
  addCount(e) {
    const index = e.currentTarget.dataset.index;
    let carts = this.data.carts;
    let pronum = carts[index].pronum;
    pronum = pronum + 1;
    carts[index].pronum = pronum;
    this.setData({
      carts: carts
    });
    this.getTotalPrice();
    console.log(this.data.carts)
  },

  /**
   * 绑定减数量事件
   */
  minusCount(e) {
    const index = e.currentTarget.dataset.index;
    const obj = e.currentTarget.dataset.obj;
    let carts = this.data.carts;
    let pronum = carts[index].pronum;
    if (pronum <= 1) {
      return false;
    }
    pronum = pronum - 1;
    carts[index].pronum = pronum;
    this.setData({
      carts: carts
    });
    this.getTotalPrice();
  },

  /**
   * 计算总价
   */
  getTotalPrice() {
    let carts = this.data.carts;                  // 获取购物车列表
    let total = 0;
    for (let i = 0; i < carts.length; i++) {         // 循环列表得到每个数据
      if (carts[i].selected) {                     // 判断选中才会计算价格
        total += carts[i].pronum * carts[i].items[0].proprice;   // 所有价格加起来
      }
    }
    this.setData({                                // 最后赋值到data中渲染到页面
      carts: carts,
      totalPrice: total.toFixed(2)
    });
  },
  subtn: function () {
    var _this = this;
    var carts = _this.data.carts
    console.log(carts)
    carts.forEach(function (item, index) {
      console.log(item)
      if (item.selected) {
        console.log("被选中")
        _this.setData({
          cartItems: _this.data.cartItems.concat(item),
        })
      }
    })
    console.log(_this.data.cartItems)
    console.log(_this.data.totalPrice)
    if (_this.data.cartItems != ""){
      wx.navigateTo({
        url: '../../plugin/orders/orders?totalPrice=' + _this.data.totalPrice + '&id=' + _this.data.id
      })
      wx.setStorage({
        key: 'orders',
        data: _this.data.cartItems,
      })
    }else{
      wx.showToast({
        title: '请选择商品结算',
        duration: 1500

      })
    }
  }

})