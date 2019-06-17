// pages/plugin/home/home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [{
      id: 0,
      type: 'image',
      url: '/pages/images/1.jpg'
    }, {
      id: 1,
      type: 'image',
      url: '/pages/images/2.jpg'
    },
    {
      id: 2,
      type: 'image',
      url: '/pages/images/3.jpg'
    }
    ],
    gridCol: 4,
    gridCol2:2,
    skin: false,
    itemss: "",
    fenlist:"",
    keyword:"",
    Userentity:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this=this
    wx.showLoading({
      title: '加载中',
    })
    setTimeout(function () {
      wx.hideLoading()
    }, 2000)
    wx.request({
      method: 'post',
      url: 'http://192.168.22.58:8765/content/getItemCatAndItemsList',
      success: function(e){
        console.log(e.data)
        _this.setData({
          itemss: e.data
        });
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

  /** bind   
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    console.log("asdasdasd")
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

  as : function(){
    var itemss=this.data.itemss
    console.log(itemss)
  },
  shopcar :function(){
    wx.navigateTo({
      url: '../cart/cart?id='+ this.data.Userentity.id,
    })
  },
  itembtn :function(){
    wx.navigateTo({
      url: '../home/detail/detail',
    })
  },
  searchput: function (e) {
    var key = e.detail.value;//从页面获取到用户输入的用户名
    console.log(key)
    if (key != '') {
      this.setData({ keyword: key });//把获取到的密码赋值给date中的password
    }
  },
  searchbtn:function(){
    wx.request({
      url: 'http://192.168.22.53:8767/item/search',
      method:'POST',
      data: {
        keyword: this.data.keyword,
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
        console.log("调用API成功");
        console.log(res.data.itemList)
        let itemList = res.data.itemList
        if(itemList !=""){
          console.log("返回数据不为空")
          wx.setStorage({
            key: 'itemList',
            data: res.data.itemList,
          })
          wx.navigateTo({
            url: '../home/search/search',
          })
        }
      },
      fail: function (res) {
        console.log("调用API失败");
      }
    })
  }
})