// pages/find/find.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    date:'yyyy-MM-dd',
    zhong: [{
      id: 1, name: '猫猫'
    }, { id: 2, name: '狗狗' }, { id: 3, name: '其他' }],
    im:"",
    ni:"",
    lei:"",
    city:"",
    qi:"",
    tu:"",
    zong:"",
    shu:"",
    userid:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
    this.setData({
      userid:options.id
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
  DateChange(e) {
    this.setData({
      date: e.detail.value
    })
  },
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
          url: 'http://192.168.22.58:8772/find/picture', //里面填写你的上传图片服务器API接口的路径 
          filePath: tempFilePaths[0],//要上传文件资源的路径 String类型 
          name: 'files',//按个人情况修改，文件对应的 key,开发者在服务器端通过这个 key 可以获取到文件二进制内容，(后台接口规定的关于图片的请求参数)
          header: {
            "Content-Type": "multipart/form-data"//记得设置
          },
          success: function (res) {
            console.log(res)
            var ims=res.data
            if(ims !=""){
              _this.setData({
                im: ims
              })
            }
          }
        })
      }
    })
  },
  niBlur(e){
    var ni = e.detail.value;//从页面获取到用户输入的密码
    if (ni != '') {
      this.setData({ ni: ni });//把获取到的密码赋值给date中的password
    }
  },
  leichange(e){
    console.log(e.detail.value)
    this.setData({
      lei: e.detail.value
    })
    console.log(this.data.lei)
  },
  cityBlur(e) {
    var city = e.detail.value;
    if (city != '') {
      this.setData({ city: city });
    }
  },
  DateChange(e){
    console.log(e.detail.value)
    this.setData({ date: e.detail.value })
  },
  tuBlur(e){
    var tu = e.detail.value;
    if (tu != '') {
      this.setData({ tu: tu });
    }
    console.log(this.data.tu)
  },
  daychange(e) {
    console.log(e.detail.value)
    this.setData({
      day: e.detail.value
    })
    console.log(this.data.day)
  },
  zongchange(e) {
    console.log(e.detail.value)
    this.setData({
      zong: e.detail.value
    })
    console.log(this.data.zong)
  },
  textareaBInput(e) {
    var shu = e.detail.value;//从页面获取到用户输入的密码
    if (shu != '') {
      this.setData({ shu: shu });//把获取到的密码赋值给date中的password
    }
  },
  tibtn(){
    wx.request({
      url: 'http://192.168.22.58:8772/find/addpets',
      method:'post',
      data:{
        fimg: this.data.im,
        fname: this.data.ni,
        ftype: this.data.lei,
        fcity: this.data.city,
        ftime: this.data.date,
        faddress: this.data.tu,
        fontime: this.data.day,
        fkind: this.data.zong,
        fdesc: this.data.shu,
        userId:this.data.userid
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success:function(res){
        console.log(res.data.code)
        var d = res.data.code
        if(d=='200'){
          wx.navigateBack({
            delta: 1
          })
        }else{
          console.log("调用失败");
        }
      }
    })
  }
  
})