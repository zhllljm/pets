// pages/plugin/home/sale/sale.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    gridCol2: 2,
    skin: false,
    itemList: "",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this=this
    console.log(options.id)
    wx.request({
      url: 'http://192.168.22.58:8765/content/getItemBycid',
      data: {
        cid: options.id,
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

  }
})