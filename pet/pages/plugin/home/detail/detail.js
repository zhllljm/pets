// pages/plugin/home/detail/detail.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    itemList :"",
    num: 1,
    Userentity:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this=this
    console.log(options.wareid)

    wx.request({
      url: 'http://192.168.22.58:8765/content/item/gets',
      data: {
        wareid: options.wareid,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'post',//定义传到后台接受的是post方法还是get方法
      success: function (res) {
        console.log("调用API成功");
        console.log(res.data)
        _this.setData({
          itemList: res.data
        })
      },
      fail: function (res) {
        console.log("调用API失败");
      }
    })
    var oid = wx.getStorageSync('openid')
    console.log(oid)
      wx.request({
        url: 'http://192.168.22.58:8762/member/getUser',
        data: {
          token: oid,
        },
        header: {
          "Content-Type": "application/x-www-form-urlencoded"
        },
        method: 'post',//定义传到后台接受的是post方法还是get方法
        success: function (res) {
          console.log("调用API成功");
          console.log(res.data.data)
          _this.setData({
            Userentity: res.data.data
          })
        },

        fail: function (res) {
          console.log("调用API失败");
        }
      })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log("plugin")
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  buybtn:function(){
      wx.navigateTo({
        url: '../../plugin/orders/orders?totalPrice=' + _this.data.totalPrice
      })
    if (this.data.cartItems !=""){
      wx.setStorage({
        key: 'orders',
        data: this.data.cartItems,
      })
    } else {
      wx.showToast({
        title: '请选择商品结算',
        duration: 1500

      })
    }
  },
  showModal(e) {
    this.setData({
      modalName: e.currentTarget.dataset.target
    })
  },
  hideModal(e) {
    this.setData({
      modalName: null
    })
  },
  cdown() {
    var that = this;
    if (that.data.num <= 1) {
      return false;
    } else {
      that.setData({
        num: that.data.num - 1
      })
    }
  },
  cadd() {
    var that = this;
    that.setData({
      num: that.data.num + 1
    })
  },
  gocar(){
    var _this=this
    console.log("进入购物车")
    wx.request({
      url: 'http://192.168.22.58:8768/cart/selectCart',
      data: {
        wareId: _this.data.itemList.wareid,
        userId: _this.data.Userentity.id
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      method: 'post',//定义传到后台接受的是post方法还是get方法
      success: function (res) {
        console.log("调用API成功");
        console.log(res.data)
        if(res.data !=""){
          console.log("数据不是空值");
          wx.request({
            url: 'http://192.168.22.58:8768/cart/upnum',
            data: {
              pronum: _this.data.num,
              wareId: _this.data.itemList.wareid,
            },
            header: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            method: 'post',//定义传到后台接受的是post方法还是get方法
            success: function (res) {
              console.log("调用修改参数成功");
              console.log(res)
            }
          })
        }else{
          console.log("数据是空值");
          wx.request({
            url: 'http://192.168.22.58:8768/cart/insertCart',
            data: {
              pronum: _this.data.num,
              wareId: _this.data.itemList.wareid,
              userId: _this.data.Userentity.id
            },
            header: {
              "Content-Type": "application/x-www-form-urlencoded"
            },
            method: 'post',//定义传到后台接受的是post方法还是get方法
            success: function (res) {
              console.log("添加购物车成功");
              console.log(res)
              _this.setData({
                modalName: null
              })
            }
          })
        }
      },

      fail: function (res) {
        console.log("调用API失败");
      }
    })
    
  },
  goorder(){
    console.log("立即购买")
  },
  cartbtn(){
    wx.navigateTo({
      url: '../../cart/cart?id=' + this.data.Userentity.id,
    })
  }
})