// pages/about/order/order.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userId:"",
    currtab: 0,
    swipertab: [{ name: '全部', index: 0 }, { name: '待付款', index: 1 }, { name: '已付款', index: 2 }, { name: '待发货', index: 3 }, { name: '待评价', index: 4 }],
    all:"",
    dai:"",
    yi:"",
    fa:"",
    ping:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
    this.setData({
      userId:options.id
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    // 页面渲染完成
    this.getDeviceInfo()
    this.orderShow()

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

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
  getDeviceInfo: function () {
    let that = this
    wx.getSystemInfo({
      success: function (res) {
        that.setData({
          deviceW: res.windowWidth,
          deviceH: res.windowHeight
        })
      }
    })
  },
  tabSwitch: function (e) {
    var that = this
    if (this.data.currtab === e.target.dataset.current) {
      return false
    } else {
      that.setData({
        currtab: e.target.dataset.current
      })
    }
  },

  tabChange: function (e) {
    this.setData({ currtab: e.detail.current })
    this.orderShow()
  },

  orderShow: function () {
    let that = this
    switch (this.data.currtab) {
      case 0:
        that.alreadyShow()
        break
      case 1:
        that.waitPayShow()
        break
      case 2:
        that.lostShow()
        break
      case 3:
        that.faShow()
        break
      case 4:
        that.pingShow()
        break
    }
  },
  alreadyShow: function () {
    var that=this;
    console.log("全查")
    wx.request({
      url: 'http://192.168.22.58:8769/order/lookOrders',
      method: 'post',
      data: {
        userId: that.data.userId
      },
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      success: function (res) {
       console.log(res) 
       that.setData({
         all:res.data
       })
      }
    })
      
  },

  waitPayShow: function () {
    console.log("代付款")
  },

  lostShow: function () {
    console.log("已付款")
  },

  faShow: function () {
    console.log("代发货")
  },

  pingShow: function () {
    console.log("待评价")
  }

})