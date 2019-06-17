// pages/regist/regist.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    phone: "",
    password: "",
    message: "",
    images:"",
    username:"",
    email:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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

  },//点击图片选择手机相册或者电脑本地图片
  changeAvatar: function (e) {
    var _this = this
    wx.chooseImage({
      count: 1,// 默认9
      sizeType: ['original', 'compressed'],// 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'],// 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths;
        //这里是上传操作
        wx.uploadFile({
          url:'http://192.168.22.58:8762/member/uploadFileToFast', //里面填写你的上传图片服务器API接口的路径 
          filePath: tempFilePaths[0],//要上传文件资源的路径 String类型 
          name: 'file',//按个人情况修改，文件对应的 key,开发者在服务器端通过这个 key 可以获取到文件二进制内容，(后台接口规定的关于图片的请求参数)
          header: {
            "Content-Type": "multipart/form-data"//记得设置
          },
          success: function (res) {
            console.log(res)
            _this.setData({
              images:'http://119.23.74.128/'+ res.data
            })
          }
        })
      }
    })
  },
  //处理accountInput的触发事件
  userBlur: function (e) {
    var username = e.detail.value;//从页面获取到用户输入的用户名
    if (username != '') {
      this.setData({ username: username });//把获取到的密码赋值给date中的password
    }
  },
  mailBlur: function (e) {
    var email = e.detail.value;//从页面获取到用户输入的邮箱
    if (email != '') {
      this.setData({ email: email });//把获取到的密码赋值给date中的password
    }
  },
  accountInput: function (e) {
    var phone = e.detail.value;//从页面获取到用户输入的手机号
    if (phone != '') {
      this.setData({ phone: phone });//把获取到的密码赋值给date中的password
    }
  },
  //处理pwdBlur的触发事件
  pwdBlur: function (e) {
    var pwd = e.detail.value;//从页面获取到用户输入的密码
    if (pwd != '') {
      this.setData({ password: pwd });//把获取到的密码赋值给date中的password
    }
  },
  //处理register的触发事件
  register: function (e) {
    wx.request({
      url: 'http://192.168.22.58:8762/member/regist',
      //定义传到后台的数据
      data: {
        //从全局变量data中获取数据
        username: this.data.username,
        password: this.data.password,
        phone: this.data.phone,
        email:this.data.email,
        img: this.data.images
      },
      method: 'post',//定义传到后台接受的是post方法还是get方法
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log("调用API成功");
        console.log(res);
        wx.navigateBack({
          detal:1,
        })
      },
      fail: function (res) {
        console.log("调用API失败");
      }
    })
  }

})