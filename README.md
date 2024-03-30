这是一个RPC项目的简易实现。
RPC框架时后端研发人员使用的重要框架，目前业界比较知名有 Dubbo、Spring Cloud、gRPC 等，
本文参照Dubbo框架，实现自己的RPC框架。

<h3>RPC框架的结构</h3>
基本的RPC框架包括三部分，注册中心、服务端、客户端。以下是一个最简单的结构流程图。
<img src="images/基本的RPC框架.png">

##### 组成部分：

* 1、注册中心：用于注册和获取服务。
* 2、服务端：指提供服务的一方，也叫服务提供方 Provider
* 3、客户端：指调用服务的一方，也叫服务消费者 Consumer

##### 流程：

1. 服务端把服务信息注册到注册中心，通常包含服务端地址、接口类和方法
2. 客户端从注册中心获取对应服务的信息，注册中心会主动推送变化的服务
3. 客户端根据服务的信息，通过网络调用到服务端的接口

### RPC框架的设计

一个基本的RPC框架的设计，需要包含以下部分：

1. 注册中心：注册中心：注册中心负责服务信息的注册与查找。服务端在启动的时候，扫描所有的服务，然后将自己的服务地址和服务名注册到注册中心。客户端在调用服务之前，通过注册中心查找到服务的地址，就可以通过服务的地址调用到服务啦。常见的注册中心有 `Zookeeper`、`Eureka` 等。
2. 动态代理：客户端调用接口，需要框架能自己根据接口去远程调用服务，这一步是用户无感知的。这样一来，就需要使用到动态代理，用户调用接口，实际上是在调用动态生成的代理类。常见的动态代理有：`JDK Proxy`，`CGLib`，`Javassist` 等。
3. 网络传输：RPC 远程调用实际上就是网络传输，所以网络传输是 RPC 框架中必不可少的部分。网络框架有 `Java NIO`、`Netty` 框架等。
4. 自定义协议：网络传输需要制定好协议，一个良好的协议能提高传输的效率。
5. 序列化：网络传输肯定会涉及到序列化，常见的序列化有`Json`、`Protostuff`、`Kyro` 等。
6. 负载均衡：当请求调用量大的时候，需要增加服务端的数量，一旦增加，就会涉及到符合选择服务的问题，这就是负载均衡。常见的负载均衡策略有：轮询、随机、加权轮询、加权随机、一致性哈希等等。
7. 集群容错：当请求服务异常的时候，我们是应该直接报错呢？还是重试？还是请求其他服务？这个就是集群容错策略啦。



