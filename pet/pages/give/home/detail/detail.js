// pages/give/home/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperList: '',
    id: "",
    shuju: "",
    u:'',
    as:'',
    Userentity:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
    this.setData({
      id: options.id
    })
    var oid = wx.getStorageSync('openid')
    var _this = this
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
        console.log("用户信息" + _this.data.Userentity)
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
    var that = this;
    wx.request({
      url: 'http://192.168.22.58:8771/adoption/getRelationship',
      data: {
        adid: that.data.id
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      method: 'Post',
      dataType: 'json',
      success: function (res) {
        console.log(res.data);
        that.setData({
          shuju: res.data[0].adoption,
          swiperList: res.data[0].adoption.petImages,
          u: res.data[0].adoption.userEntity,
          as:res.data
        })
        console.log(that.data.swiperList)
      },
      fail: function (res) {
        console.log("调用失败");
      }
    })
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
  sibtn(){
    wx.navigateTo({
      url: '../../../chat/chat?id=' + this.data.Userentity.id + "&toname=" + this.data.u.username,
    })
  },
  shenbtn(){
    wx.navigateTo({
      url: '../apply/apply?id=' + this.data.Userentity.id,
    })
  }
})