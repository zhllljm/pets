Page({
  /**
   * 页面的初始数据
   */
  data: {
    swiperList: [{
      id: 0,
      type: 'image',
      url: '/pages/images/1.jpg'
    }, {
      id: 1,
      type: 'image',
      url: '/pages/images/2.jpg'
    },
    {
      id: 2,
      type: 'image',
      url: '/pages/images/3.jpg'
    }
    ],
    iconList: [{
      id: 1,
      icon: 'new',
      color: 'red',
      name: '助养'
    }, {
      id: 2,
      icon: 'explorefill',
      color: 'orange',
      name: '寻宠'
    }, {
      id: 3,
      icon: 'github',
      color: 'yellow',
      name: '领养'
    }, {
      id: 4,
      icon: 'group_fill',
      color: 'olive',
      name: '合作'
    }],
    gridCol: 4,
    skin: false
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
   var openid=wx.getStorageSync('openid');
   console.log(openid)
   if(openid == null||openid ==""){
     wx.redirectTo({
       url: '../../login/login',
     })
   }
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

  swiperclick: function (e) {
    console.log(e.currentTarget.dataset.id);

    var id = JSON.stringify(e.currentTarget.dataset.id);
    console.log(id);
      wx.navigateTo({
        url: '../goods/goods?id=' + id,
      })
  },

  cuclick:function(e){
    console.log(e.currentTarget.dataset.id);

    var id = JSON.stringify(e.currentTarget.dataset.id);
    console.log(id);
    if(id=='2'){
      wx.navigateTo({
        url: '../../find/home/home',
      })
    }else if(id=='3'){
      wx.navigateTo({
        url: '../../give/home/home',
      })
    }
  },
  heclick: function () {
    wx.navigateTo({
      url: '../logs/logs',
    })
  },
  xian : function(){
    wx.switchTab({
      url: '../../plugin/home/home',
    })
  }

})
