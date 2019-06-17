// pages/give/home/apply/apply.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    who: [{va:'麻麻'}, {va:'爸爸'}],
    big: [{ va: '70后' }, { va: '80后' }, { va: '90后' }, { va: '00后' }],
    work: [{ va: '无业' }, { va: '学生' }, { va: '工作' }, { va: '退休' }],
    yan: [{ va: '有经验' }, { va: '无经验' }],
    jie: [{ va: '单身' }, { va: '恋爱中' }, { va: '已婚' }],
    zhu: [{ va: '自住房' }, { va: '整租房' }, { va: '合租' }],
    money: [{ va: '小于3千' }, { va: '3千-6千' }, { va: '6千-1万' }, { va: '大于一万' }],
    a:"",
    b:"",
    c:"",
    d:"",
    e:"",
    f:"",
    g:"",
    h:"",
    id:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.id)
    this.setData({
      id: options.id
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
  whoTap(e){
    var that = this
    var this_checked = e.currentTarget.dataset.id
    var whoList = this.data.who//获取Json数组
    
    for (var i = 0; i < whoList.length; i++) {
      if (whoList[i].va == this_checked) {
        whoList[i].checked = true;//当前点击的位置为true即选中
      }
      else {
        whoList[i].checked = false;//其他的位置为false
      }
    }
    that.setData({
      who: whoList,
      a: this_checked
    })
    console.log(that.data.a)
  },
  bigTap(e) {
    var that = this
    var this_checked = e.currentTarget.dataset.id
    var bigList = this.data.big//获取Json数组

    for (var i = 0; i < bigList.length; i++) {
      if (bigList[i].va == this_checked) {
        bigList[i].checked = true;//当前点击的位置为true即选中
      }
      else {
        bigList[i].checked = false;//其他的位置为false
      }
    }
    that.setData({
      big: bigList,
      b: this_checked
    })
    console.log(that.data.b)

  },
  workTap(e) {
    var that = this
    var this_checked = e.currentTarget.dataset.id
    var workList = this.data.work//获取Json数组

    for (var i = 0; i < workList.length; i++) {
      if (workList[i].va == this_checked) {
        workList[i].checked = true;//当前点击的位置为true即选中
      }
      else {
        workList[i].checked = false;//其他的位置为false
      }
    }
    that.setData({
      work: workList,
      c: this_checked
    })
    console.log(that.data.c)

  },
  yanTap(e) {
    var that = this
    var this_checked = e.currentTarget.dataset.id
    var yanList = this.data.yan//获取Json数组

    for (var i = 0; i < yanList.length; i++) {
      if (yanList[i].va == this_checked) {
        yanList[i].checked = true;//当前点击的位置为true即选中
      }
      else {
        yanList[i].checked = false;//其他的位置为false
      }
    }
    that.setData({
      yan: yanList,
      d: this_checked
    })
    console.log(that.data.d)

  },
  zhuTap(e) {
    var that = this
    var this_checked = e.currentTarget.dataset.id
    var zhuList = this.data.zhu//获取Json数组

    for (var i = 0; i < zhuList.length; i++) {
      if (zhuList[i].va == this_checked) {
        zhuList[i].checked = true;//当前点击的位置为true即选中
      }
      else {
        zhuList[i].checked = false;//其他的位置为false
      }
    }
    that.setData({
      zhu: zhuList,
      f: this_checked
    })
    console.log(that.data.f)

  },
  jieTap(e) {
    var that = this
    var this_checked = e.currentTarget.dataset.id
    var jieList = this.data.jie//获取Json数组

    for (var i = 0; i < jieList.length; i++) {
      if (jieList[i].va == this_checked) {
        jieList[i].checked = true;//当前点击的位置为true即选中
      }
      else {
        jieList[i].checked = false;//其他的位置为false
      }
    }
    that.setData({
      jie: jieList,
      e: this_checked
    })
    console.log(that.data.e)

  },
  moneyTap(e) {
    var that = this
    var this_checked = e.currentTarget.dataset.id
    var moneyList = this.data.money//获取Json数组

    for (var i = 0; i < moneyList.length; i++) {
      if (moneyList[i].va == this_checked) {
        moneyList[i].checked = true;//当前点击的位置为true即选中
      }
      else {
        moneyList[i].checked = false;//其他的位置为false
      }
    }
    that.setData({
      money: moneyList,
      g: this_checked
    })
    console.log(that.data.g)

  },
  textareaBInput(e) {
    this.setData({
      h: e.detail.value
    })
    console.log(this.data.h)
  },
  tbtn(){
    wx.request({
      url: 'http://192.168.22.58:8771/adoption/saveadopter',
      method: 'post',
      data: {
        sex: this.data.a,
        age: this.data.b,
        status: this.data.c,
        experience: this.data.d,
        marriage: this.data.e,
        lodging: this.data.f,
        income: this.data.g,
        de: this.data.h,
        userId: this.data.id
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
        console.log(res.data.code)
        var d = res.data.code
        if (d == '200') {
          wx.navigateBack({
            delta: 3
          })
        } else {
          console.log("调用失败");
        }
      }
    })
  }


  
})