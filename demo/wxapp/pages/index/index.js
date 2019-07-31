 //index.js
//获取应用实例
var app = getApp()
Page({
  // 页面初始数据
  data: {
        imgUrls: '/images/image/10023.jpg',
        background: ['demo-text-1', 'demo-text-2', 'demo-text-3','demo-text-4'],
        indicatorDots: false,    //提示点
        circular: true,         //衔接滑动
        autoplay: false,        //自动播放
        vertical:false,
        interval:10,           //自动切换
        previousMargin: 90,     //前边距离
        nextMargin: 90          //后边距离
  },
  changeIndicatorDots: function (e) {
        this.setData({
                indicatorDots: !this.data.indicatorDots
        })
  },
  onLoad:function(){
    wx.showLoading({
      title: '正在加载',
      icon:"loading",
      duration: 1000
    })
    var that = this
    //首页列表
    wx.request({
      url: 'https://www.runcui.net:8080/productInfo/findAll',
      success: function (res) {   
        var dd = res.data[0].image    
        that.setData({
          productData: res.data
        })
      }
    })
  },
  //点击书籍 跳转至详情页
  navigateDetail: function(e){
    var aid = e.currentTarget.dataset.aid
    wx.navigateTo({
      url: '../detail/detail?aid='+aid
    })
  },
  //点击购买 微信支付
  buy:function(e){
    //参数：价格 名称 
    app.wxpay(e)
  }
  
})
