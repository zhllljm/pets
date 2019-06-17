// pages/login/login.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    phone: "",
    password: "",
    message: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // 查看是否授权
    wx.getSetting({
      success: function (res) {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          wx.getUserInfo({
            success: function (res) {
              console.log(res.userInfo)
            }
          })
        }
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

  },
  //处理accountInput的触发事件
  accountInput: function (e) {
    var pe = e.detail.value;//从页面获取到用户输入的用户名/邮箱/手机号
    if (pe != '') {
      this.setData({ phone: pe });//把获取到的密码赋值给全局变量Date中的password
    }
  },
  //处理pwdBlurt的触发事件
  pwdBlur: function (e) {
    var pwd = e.detail.value;//从页面获取到用户输入的密码
    if (pwd != '') {
      this.setData({ password: pwd });//把获取到的密码赋值给全局变量Date中的password
    }
  },
  //处理login的触发事件
  login: function (e) {
    var _this=this
    wx.request({
      url: 'http://192.168.22.58:8762/member/login',//后面详细介绍
      //定义传到后台的数据
      data: {
        //从全局变量data中获取数据
        phone: this.data.phone,
        password: this.data.password,
      },
      method: 'post',//定义传到后台接受的是post方法还是get方法
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log("调用API成功");
        console.log(res)
        if(res.data.code == 200){
          wx.setStorageSync('openid', res.data.data)
          wx.switchTab({
            url: '../main/home/home',
          })
        }else{
          wx.showToast({
            icon: "clear",
            title: res.data.msg,
            duration: 1500
          })
        }
        
      },
      fail: function (res) {
        console.log("调用API失败");
      }
    })
  },
  reg :function(){
    wx.navigateTo({
      url: '../regist/regist',
    })
  },
  sqlogin: function (event){
    console.log(event.detail.userInfo)
    //使用
    var _this = this;
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.login({
            success: function (res) {
              var code = res.code;//登录凭证
              if (code) {
                //2、调用获取用户信息接口
                wx.getUserInfo({
                  lang: 'zh_CN',
                  success: function (res) {
                    console.log({ encryptedData: res.encryptedData, iv: res.iv, code: code })
                    //3.请求自己的服务器，解密用户信息 获取unionId等加密信息
                    wx.request({
                      url: 'http://192.168.22.58:8762/member/decodeUserInfo',//自己的服务接口地址
                      method: 'post',
                      header: {
                        'content-type': 'application/x-www-form-urlencoded'
                      },
                      data: { encryptedData: res.encryptedData, iv: res.iv, code: code },
                      success: function (res) {
                        console.log("调用API成功");
                        console.log(res)
                        if (res.data.code == 200) {
                          wx.setStorageSync('openid', res.data.data)
                          wx.switchTab({
                            url: '../main/home/home',
                          })
                        } else {
                          wx.showToast({
                            icon: "clear",
                            title: res.data.msg,
                            duration: 1500

                          })
                        }
                      },
                      fail: function () {
                        console.log('系统错误')
                      }
                    })
                  },
                  fail: function () {
                    console.log('获取用户信息失败')
                  }
                })

              } else {
                console.log('获取用户登录态失败！' + r.errMsg)
              }
            },
            fail: function () {
              console.log('登陆失败')
            }
          })

        } else {
          console.log('获取用户信息失败')

        }

      }
    })
  }
})