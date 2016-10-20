# Java Project

## 项目实现：新闻的阅读软件

平台: android

架构:MVVM

设计风格:Material Design

数据来源:[newsApi.org](https://newsapi.org/)

实现原理:通过解析请求api传回的json数据而讲新闻信息通过列表视图的形式展现在ui上

开发组成员：刘瑾，胡芸薇，冀辰阳，卢雨婷，李坤峰

应用的框架：

| 功能             | 框架名称                     |
| -------------- | ------------------------ |
| Retrofit2.0    | 网络请求                     |
| Rxjava         | 响应式编程以及灵活的多线程            |
| Gson           | json数据的解析(ORM)           |
| support-design | material design的向下兼容(官方) |
| recyclerview   | 高效滑动列表组件(官方)             |
| data-binding   | 数据绑定(官方)                 |

### api请求示例

```json
{
"status": "ok",
"source": "techcrunch",
"sortBy": "top",
"articles": [
{
"author": "Mark Robinson",
"title": "Is VR a leap back in time for the games industry?",
"description": "When we look back through the annals of time, there, etched in the history books will be \"2016: The year of VR.\" And what a year it's been. We’ve already..",
"url": "http://social.techcrunch.com/2016/10/19/is-vr-a-leap-back-in-time-for-the-games-industry/",
"urlToImage": "https://tctechcrunch2011.files.wordpress.com/2016/10/gettyimages-462976831.jpg?w=764&amp;h=400&amp;crop=1",
"publishedAt": "2016-10-20T01:00:49Z"
},
{
"author": "Jake Bright",
"title": "IFC makes the first investments from its $30 million Startup Catalyst initiative",
"description": "The International Finance Corporation, the investment arm of the World Bank, said it has made a $4 million commitment to two new funds as part of its $30..",
"url": "http://social.techcrunch.com/2016/10/19/ifc-makes-the-first-investments-from-its-30-million-startup-catalyst-initiative/",
"urlToImage": "https://tctechcrunch2011.files.wordpress.com/2016/10/flat6labs-cairo4.jpg?w=764&amp;h=400&amp;crop=1",
"publishedAt": "2016-10-19T23:53:57Z"
},
]
}
```

请求方式：Get

请求参数(params):

| source | *(required)* - The identifer for the news source or blog you want headlines from. Use the /sources endpoint to locate this or use the [sources index](https://newsapi.org/sources). |
| ------ | ---------------------------------------- |
| apiKey | *(required)* - Your API key.             |
| sortBy | *(optional)* - Specify which type of list you want. The possible options are **top**, **latest** and **popular**. Note: not all options are available for all sources. Default: **top**.topRequests a list of the source's headlines sorted in the order they appear on its homepage.latestRequests a list of the source's headlines sorted in chronological order, newest first.popularRequests a list of the source's current most popular or currently trending headlines. |
