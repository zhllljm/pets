// pages/sock/sock.js
let socketOpen = false;
var socketMsgQueue = [];
Page({
  /**
   * 页面的初始数据
   */
  data: {
    msg: "",
    list: [],
    u: "",
    m: "",
    shuju:[],
    userId:'',
    id:"",
    username:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
    console.log("传输的名字为" + options.toname)
    this.setData({
      id:options.id,
      username: options.toname
    })
    this.linkSocket();
  },

  // 链接websocket
  linkSocket() {

    let that = this

    wx.connectSocket({

      url: 'ws://192.168.22.58:8773/chat/'+that.data.id,

      success() {

        socketOpen = true;

        that.initEventHandle()

      }

    })

  },

  // 链接成功之后处理
  initEventHandle() {
    let that = this
    wx.onSocketMessage((res) => {
      // 数据处理
      that.setMessage(res.data)
    })
    wx.onSocketOpen(() => {
      console.log('WebSocket连接打开')
    })
    wx.onSocketError((res) => {
      console.log('WebSocket连接打开失败')
      this.reconnect()
    })
    wx.onSocketClose((res) => {
      console.log('WebSocket 已关闭！');
      socketOpen = false;
      this.reconnect()
    })

  },

  // 断线重连
  reconnect() {
    if (this.lockReconnect) return;
    this.lockReconnect = true;
    clearTimeout(this.timer)
    if (this.data.limit < 12) {
      this.timer = setTimeout(() => {
        this.linkSocket();
        this.lockReconnect = false;
      }, 5000);
      this.setData({
        limit: this.data.limit + 1
      })
    }
  },

  // 发送
  megInput(e) {
    let msg = e.detail.value;
    this.setData({
      msg: msg
    })
  },

  sendEvent() {
    let that = this;
    let msg = that.data.msg;
    if (msg == "") {
      wx.showToast({
        title: '信息不能为空',
        icon: 'none',
        mask: true,
      });
      return;
    }
    if (socketOpen) {
      wx.sendSocketMessage({
        data: msg,
        success(res) {
          that.setData({
            msg: ""
          })
        }
      })
    } else {
      wx.showToast({
        title: '链接已断,重新链接',
        icon: 'none',
        mask: true,
      });
    }
  },
  setMessage(res) {
    var that = this;
    let list = that.data.list;
    list.push(JSON.parse(res));
    console.log(list)
    console.log(list.length)
    var le=list.length-1
    
    console.log(list[le].userId)
    that.setData({
      m: list[le].message,
      userId: list[le].userId
    })
    wx.request({
      url: 'http://192.168.22.58:8762/member/getUserbyid',
      data: {
        id: that.data.userId
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded' // 默认值
      },
      method: 'Post',
      dataType: 'json',
      success: function (res) {
        console.log(res);
        var obj = {
          name: res.data.username,
          img: res.data.img,
          id: res.data.id,
          mes: that.data.m
        }
        let shuju=that.data.shuju
        shuju.push(obj);
        that.setData({
          shuju: shuju
        })
        console.log(that.data.shuju)
      },
      fail: function (res) {
        console.log("调用失败");
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
 
})