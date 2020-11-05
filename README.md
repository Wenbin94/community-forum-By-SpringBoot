# community-forum-By-SpringBoot

基于SpringBoot+MyBatis实现Javaweb项目，并集成了MySQL,Redis，Kafka，Elasticsearch等。实现了账号注册，会话管理，文章发表，富文本编写显示，生成验证码，文章搜索，账号管理，过滤敏感词，评论私信点赞，事务管理等功能。
主要的技术点：

	1. 登录注册功能：使用kaptcha去生成验证码，使用邮件完成注册，Redis优化验证码的保存，解决分布式session问题
	2. 使用拦截器拦截用户请求，将用户信息绑定在ThreadLocal上
	3. 构建前缀树数据结构，实现对发表帖子评论的敏感词过滤
	4. 支持对帖子评论，也支持对评论进行回复
	5. 利用AOP对service的业务代码实现日志记录
	6. 利用Redis的zset并结合Redis实现点赞关注的功能
	7. 点赞关注后的系统通知，实时性不需要特别高，使用kafka实现异步的发送系统通知
	8. 使用ElasticSearch实现对帖子的搜索功能，以及结果的高亮显示
	9. SpringQuartz实现定时任务，完成热门帖子的分数计算模块
	10. 使用本地缓存Quartz缓存热门帖子优化热门帖子页面，提高了QPS( 每秒查询率)（10 - 200）




## 工具（tools）

JDK1.8；

IDEA：IntelliJ IDEA 2020.1.1 x64



## 界面

#### 首页

显示前十个文章，通过分页显示全部文章，默认按发表时间逆序，热度排行按公式排。并可以显示置顶加精贴。

![image-20201102175505880](https://github.com/Wenbin94/community-forum-By-SpringBoot/edit/master/img/image-20201102175505880.png)

#### 帖子文章详情

文章详情，通过Spring Security 权限控制并实现了点赞，评论回复，并使用Kafka构建异步消息系统。

![image-20201102182726622](https://github.com/Wenbin94/community-forum-By-SpringBoot/edit/master/img/image-20201102182726622.png)

![image-20201102182731536](https://github.com/Wenbin94/community-forum-By-SpringBoot/edit/master/img/image-20201102182731536.png)

#### 登录界面

验证账号密码及验证码，成功时生成凭证发给客户端，服务器通过Redis存储登录凭证。失败时跳回登录页。

![image-20201102183351103](https://github.com/Wenbin94/community-forum-By-SpringBoot/edit/master/img/image-20201102183351103.png)



#### 私信通知列表

使用Redis处理点赞，关注等功能

![image-20201102183445951](https://github.com/Wenbin94/community-forum-By-SpringBoot/edit/master/img/image-20201102183445951.png)

#### 文章发帖界面

集成markdown富文本编辑器。

![image-20201102183546721](https://github.com/Wenbin94/community-forum-By-SpringBoot/edit/master/img/image-20201102183546721.png)
