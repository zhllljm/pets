// pages/give/give.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgbox: [],//上传图片
    imgs:[],
    ni:"",
    sex:"",
    lei:"",
    yi:"",
    yu:"",
    qu:"",
    story:"",
    zhong:[{
      id:1,name:'猫猫'}, { id: 2, name: '狗狗'},{id:3,name:'其他' }],
    picker: ['1', '2', '3','4','5','6'],
    tij:[
      {id:1,name:'仅限同城'},
      {id:2, name: '按时打疫苗' },
      { id: 3, name: '同意适龄绝育' },
      { id: 4, name: '不得遗弃，转让，虐待' },
      { id: 5, name: '有防盗门，必须封网' },
      { id: 6, name: '接受领养前家访，领养后回访' },
      { id: 7, name: '家庭成员全员同意' },
      { id: 8, name: '工作稳定，有一定经济基础' },
    ],
    tj:"",
    userid:"",
    city:'',
    de:'',
    shuju:[],
    index:'',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
    this.setData({
      userid: options.id
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
  // 删除照片 &&
  imgDelete1: function (e) {
    let that = this;
    let index = e.currentTarget.dataset.deindex;
    let imgbox = this.data.imgbox;
    imgbox.splice(index, 1)
    that.setData({
      imgbox: imgbox
    });
  },
  // 上传图片 &&&
  addPic1: function (e) {
    var imgbox = this.data.imgbox;
    console.log(imgbox)
    var picid = e.currentTarget.dataset.pic;
    console.log(picid)
    var that = this;
    var n = 3;
    if (3 > imgbox.length > 0) {
      n = 3 - imgbox.length;
    } else if (imgbox.length == 3) {
      n = 1;
    }
    wx.chooseImage({
      count: 3, // 默认9
      sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // console.log(res.tempFilePaths)
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths

        if (imgbox.length == 0) {
          imgbox = tempFilePaths
        } else if (9 > imgbox.length) {
          imgbox = imgbox.concat(tempFilePaths);

        } else {
          imgbox[picid] = tempFilePaths[0];
        }
        that.setData({
          imgbox: imgbox
        });
        for (var i = 0; i < that.data.imgbox.length; i++) {
          console.log("i等于" + i)
          console.log(that.data.imgbox[i])
          wx.uploadFile({
            url: 'http://192.168.22.58:8771/adoption/picture', //里面填写你的上传图片服务器API接口的路径 
            filePath: that.data.imgbox[i],//要上传文件资源的路径 String类型 
            name: 'file',//按个人情况修改，文件对应的 key,开发者在服务器端通过这个 key 可以获取到文件二进制内容，(后台接口规定的关于图片的请求参数)
            header: {
              "Content-Type": "multipart/form-data"//记得设置
            },
            success: function (res) {
              console.log(res)
              that.setData({
                shuju: that.data.shuju.concat(res.data)
              })
            }
          })
          console.log(that.data.imgs)
        }

      }
    })
    console.log(that.data.imgbox)
  },
  cityin(e) {
    this.setData({
      city: e.detail.value
    })
    console.log(this.data.city)
  },
  dein(e) {
    this.setData({
      de: e.detail.value
    })
    console.log(this.data.de)
  },
  niin(e){
    this.setData({
      ni: e.detail.value
    })
    console.log(this.data.ni)
  },
  zongchange(e){
    console.log(e);
    var str=e.detail.value
    this.setData({
      lei:e.detail.value
    })
    console.log(this.data.lei);
  },
  PickerChange(e) {
    console.log(e);
    this.setData({
      index: e.detail.value
    })
  },
  sexchange(e) {
    console.log(e);
    var str = e.detail.value
    this.setData({
      sex: e.detail.value
    })
    console.log(this.data.sex);
  },
  yichange(e) {
    console.log(e);
    var str = e.detail.value
    this.setData({
      yi: e.detail.value
    })
    console.log(this.data.yi);
  },
  yuchange(e) {
    console.log(e);
    var str = e.detail.value
    this.setData({
      yu: e.detail.value
    })
    console.log(this.data.yu);
    console.log(this.data.userid);
  },
  quchange(e) {
    console.log(e);
    var str = e.detail.value
    this.setData({
      qu: e.detail.value
    })
    console.log(this.data.qu);
  },
  textareaBInput(e) {
    this.setData({
      story: e.detail.value
    })
    console.log(this.data.story)
  },
  tj(e){
    console.log(e.detail.value)
    this.setData({
      tj: e.detail.value
    })
    console.log(this.data.tj)
  },
  gbtn: function () {
    var that = this;
    var list=[]
    console.log(that.data.ni)
    that.setData({
      shuju: that.data.shuju.concat(that.data.ni), 
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.sex),
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.lei),
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.yi),
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.yu),
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.qu),
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.story),
    }) 
    that.setData({
      shuju: that.data.shuju.concat(that.data.tj),
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.city),
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.de),
    })
    that.setData({
      shuju: that.data.shuju.concat(that.data.userid),
    }),
    that.setData({
      shuju: that.data.shuju.concat(that.data.index),
    })
    wx.request({
      url: 'http://192.168.22.58:8771/adoption/insertAdopter',
      data: JSON.stringify(that.data.shuju),
      header: {
        'content-type': 'application/json' // 默认值
      },

      method: 'post',//定义传到后台接受的是post方法还是get方法
      success: function (res) {
        console.log("调用API成功");
        console.log(res)
        if(res.data.code==200){
          wx.navigateBack({
            delta: 1
          })
        }
      },
      fail: function (res) {
        console.log("调用API失败");
      }
    }) 
  },
  abtn(){
    console.log(this.data.imgs[0])
    console.log(this.data.imgs[1])
    console.log(this.data.imgs[2])
    console.log(this.data.shuju)
  }


})