// page/component/orders/orders.js
Page({
  data: {
    address: "",
    hasAddress: "",
    total: 0,
    orders: "",
    luy:"",
    items:"",
    id:"",
    pronum:[],
    or:[],
  },

  onReady() {
  },

  onShow: function () {
    
  },
  onLoad: function (options) {
    var that=this;
    console.log("商品总价" + options.totalPrice + "用户id" + options.id);
    that.setData({
      total: options.totalPrice,
      id: options.id
    })
    wx.getStorage({
      key: 'orders',
      success: function(res) {
        console.log(res.data)
        that.setData({
          orders: res.data
        })
        wx.removeStorage({
          key: 'orders',
          success: function(res) {
            console.log(res)
          },
        })
      },
    })
    wx.request({
      url: 'http://192.168.22.58:8766/address/getAddressbymr',
      method: 'post',
      success: function (res) {
        console.log("调用API成功");
        console.log(res);
        that.setData({
          address: res.data,
          hasAddress: true,
        })
      },
      fail: function (res) {
        console.log("调用API失败");
      }
    })

    console.log("得到的数据为"+that.data.orders)
  },
  luBlur: function (e) {
    var lu = e.detail.value;
    console.log(lu)
    if (lu != '') {
      this.setData({ luy: lu });
    }
  },
  wxpay:function(){
    wx.showModal({
      title: '提示',
      content: '本系统只做演示，微信支付系统已屏蔽',
      text: 'center',
    })
  },
  yepay: function () {
    wx.showModal({
      title: '提示',
      content: '本系统只做演示，账户余额支付系统已屏蔽',
      text: 'center',
    })
  },
  ptpay:function(){
    var that=this;
    var orders=that.data.orders
    console.log(that.data.address.adderid)
    var id = { "adderid": that.data.address.adderid }
    var tota = {"totalfee": that.data.total}
    console.log(id)
    console.log(tota)
    var or = that.data.or
    orders.forEach(function (item, index) {
      console.log("数量"+item.items)
      var items = item.items
      console.log("商品的每条数据"+JSON.stringify(item))
      console.log("商品的每条数据" + JSON.stringify(item,items[0]))
      var obj={
        pronum:item.pronum,
        userId: item.userId,
        adderid: that.data.address.adderid,
        tatol: that.data.total,
        wareid: item.items[0].wareid,
        proprice: item.items[0].proprice,
        itemname: item.items[0].warename
      }
      or.push(obj)
    })
    that.setData({
      or: or
    })

    console.log("商品数据" + JSON.stringify            (that.data.or)) 

    wx.request({
      url: 'http://192.168.22.58:8769/order/saveOrder',
      data: JSON.stringify(that.data.or),
      header: {
        'content-type': 'application/json' // 默认值
      },

      method: 'post',//定义传到后台接受的是post方法还是get方法
      success: function (res) {
        console.log("调用API成功");
        console.log(res.data)
        if(res.data.code=200){
          wx.navigateBack({
            delta: 3
          })
        }
      },
      fail: function (res) {
        console.log("调用API失败");
      }
    })

  }
    
})