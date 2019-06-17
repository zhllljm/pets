// pages/about/address/add/add.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    region: ['广东省', '广州市', '海珠区'],
    province:"广东省",
    market:"广州市",
    district:"海珠区",
    detaadder:"",
    temphone:"",
    shname:"",
    mr:"0",
    uid:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.uid)
    this.setData({
      uid:options.uid
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

  },
  RegionChange: function (e) {
    console.log(e.detail.value[0])
    this.setData({
      region: e.detail.value,
      province: e.detail.value[0],
      market: e.detail.value[1],
      district: e.detail.value[2],
    })
  },
  //处理accountInput的触发事件
  userBlur: function (e) {
    var name = e.detail.value;//从页面获取到用户输入的用户名
    if (name != '') {
      this.setData({ shname: name });//把获取到的密码赋值给date中的password
    }
  },
  //处理accountInput的触发事件
  phoneBlur: function (e) {
    var phone = e.detail.value;//从页面获取到用户输入的用户名
    if (phone != '') {
      this.setData({ temphone: phone });//把获取到的密码赋值给date中的password
    }
  },
  //处理accountInput的触发事件
  xiBlur: function (e) {
    var xi = e.detail.value;//从页面获取到用户输入的用户名
    if (xi != '') {
      this.setData({ detaadder: xi });//把获取到的密码赋值给date中的password
    }
  },
  switchChange: function (event) {
    var checkedValue = event.detail.value;
    if(checkedValue){
      this.setData({
        mr:"1"
      })
    }else{
      this.setData({
        mr:'0'
      })
    };
    console.log(this.data.mr)
  },
  addbtn: function(){
    wx.request({
      url: 'http://192.168.22.58:8766/address/add',
      //定义传到后台的数据
      data: {
        //从全局变量data中获取数据
        province: this.data.province,
        market: this.data.market,
        district: this.data.district,
        detaadder: this.data.detaadder,
        temphone: this.data.temphone,
        shname: this.data.shname,
        mr: this.data.mr,
        uid: this.data.uid
      },
      method: 'post',//定义传到后台接受的是post方法还是get方法
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log("调用API成功");
        console.log(res);
        wx.navigateBack({
          delta: 1
        })
      },
      fail: function (res) {
        console.log("调用API失败");
      }
    })
  }
})