# SpringCloudStudy
❤️
五大组件：<br>
springcloud config:<br>


Ribbon:ribbon是netflix发布的负载均衡器，它有助于控制http和tcp客户端的行为<br>


Hystrix:Hystrix是由Netflix公司开源的一个延迟和容错库，用于隔离访问远程系统、服务或第三方库，防止级联失败，从而提升系统的可用性和容错性。Hystrix主要通过以下的几点实现延迟和容错：
        <br>包裹请求：使用HystrixCommand包裹对依赖的调用逻辑，每个命令在独立线程中执行。使用了设计模式中的命令模式。
        <br>跳闸机制：当某服务的错误率超过一定的阈值时，Hystrix可以自动或者手动跳闸，停止请求该服务一段时间。
        <br>资源隔离：Hystrix为每个依赖度维护了一个小型的线程池（或者信号量）。如果该线程池已满，发往该依赖的请求就被立即拒绝，而不是排队等待，从而加速失败判定。
        <br>监控：Hystrix可以近乎实时的监控运行指标和配置的变化，例如成功、失败、超时、被拒绝的请求等等。
        <br>回退机制：当请求失败、超时、被拒绝、或当断路器打开时，执行回退逻辑。回退逻辑由开发人员自行提供，例如返回一个缺省值。
        <br>自我修复：断路器打开一段时间后，会自动进入“半开”状态。<br>


Eurake:Eurake是netflix开源的服务发现组件，本身给予rest的服务，实现微服务的注册与发现<br>


zuul:zuul是什么 zuul 是netflix开源的一个API Gateway 服务器, 本质上是一个web servlet应用。 Zuul 在云平台上提供动态路由,监控,弹性,安全等边缘服务的框架。<br>


Feign:Feign是Netflix开发的声明式，模块化的http客户端
