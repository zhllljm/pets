
// index/details.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    is_shoucang: 0,
    goods_info: { goods_id: 1, goods_title: "商品标题1", goods_price: '100', goods_yunfei: 0, goods_kucun: 100, goods_xiaoliang: 1, content: '商品介绍详情商品介绍详情商品介绍详情商品介绍详情商品介绍详情商品介绍详情商品介绍详情' },
    goods_img: [
      { 'img': 'http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg' },
      { 'img': 'http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg' },
      { 'img': 'http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg' },
      { 'img': 'http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg' },
    ],
    indicatorDots: true,
    autoplay: true,
    interval: 5000,
    duration: 1000,
    pjDataList: [{ headpic: 'http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg', author: '张三', add_time: '2018-06-01', content: '好评好评，真实太好了!' },
    { headpic: 'http://img02.tooopen.com/images/20150928/tooopen_sy_143912755726.jpg', author: '张三', add_time: '2018-06-01', content: '好评好评，真实太好了!' }
    ],//评价数据
  },


  previewImage: function (e) {
    var current = e.target.dataset.src;
    var href = this.data.imghref;
    var goodsimg = this.data.goods_img;
    var imglist = [];
    for (var i = 0; i < goodsimg.length; i++) {
      imglist[i] = href + goodsimg[i].img
    }
    wx.previewImage({
      current: current, // 当前显示图片的http链接  
      urls: imglist// 需要预览的图片http链接列表  
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
})
