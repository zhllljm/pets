// pages/about/address/update/update.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    region:"",
    uid:"",
    adderid:"",
    addressList:"",
    province: "",
    market: "",
    district: "",
    detaadder: "",
    temphone: "",
    shname: "",
    mr: "",
    uid: "",
    isChecked:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.uid)
    console.log(options.adderid)
    this.setData({
      uid: options.uid,
      adderid: options.adderid
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
    var _this=this
    wx.request({
      url: 'http://192.168.22.58:8766/address/getlistbyid',
      //定义传到后台的数据
      data: {
        //从全局变量data中获取数据
        uid: this.data.uid,
        adderid: this.data.adderid
      },
      method: 'post',//定义传到后台接受的是post方法还是get方法
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log("调用API成功");
        console.log(res.data[0]);
        console.log(res.data[0].mr);
        if(res.data[0].mr !="1"){
          console.log("不是默认")
          _this.setData({
            addressList: res.data[0],
            region: [res.data[0].province, res.data[0].market, res.data[0].district],
            mr: res.data[0].mr,
            province: res.data[0].province,
            market: res.data[0].market,
            district: res.data[0].district,
            detaadder: res.data[0].detaadder,
            temphone: res.data[0].temphone,
            shname: res.data[0].shname,
            uid: res.data[0].uid,
          });
        }else{
          console.log("默认")
          _this.setData({
            addressList: res.data[0],
            region: [res.data[0].province, res.data[0].market, res.data[0].district],
            isChecked:"true",
            mr: res.data[0].mr,
            province: res.data[0].province,
            market: res.data[0].market,
            district: res.data[0].district,
            detaadder: res.data[0].detaadder,
            temphone: res.data[0].temphone,
            shname: res.data[0].shname,
            uid: res.data[0].uid,
          });
          console.log(_this.data.isChecked)
        }
      },
      fail: function (res) {
        console.log("调用API失败");
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
    console.log(name)
    if (name != '') {
      this.setData({ shname: name });//把获取到的密码赋值给date中的password
    }
  },
  //处理accountInput的触发事件
  phoneBlur: function (e) {
    var phone = e.detail.value;//从页面获取到用户输入的用户名
    console.log(phone)
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
    if (checkedValue) {
      this.setData({
        mr: "1"
      })
    } else {
      this.setData({
        mr: '0'
      })
    };
    console.log(this.data.mr)
  },
  upbtn: function () {
    wx.request({
      url: 'http://192.168.22.58:8766/address/up',
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
        uid: this.data.uid,
        adderid: this.data.adderid
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
  },
  delbtn: function () {
    wx.request({
      url: 'http://192.168.22.58:8766/address/del',
      //定义传到后台的数据
      data: {
        //从全局变量data中获取数据
        adderid: this.data.adderid
      },
      method: 'post',//定义传到后台接受的是post方法还是get方法
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
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