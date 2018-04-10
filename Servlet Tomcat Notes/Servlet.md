# Servlet

## 执行过程
![Servlet](Servlet执行过程.png)

## 核心类图
![Servlet](02Servlet规范的核心类图.jpg)

## Servlet生命周期

- 出生：（实例化-->初始化）第一次访问Servlet就出生（默认情况下）init()
- 活着：（服务）应用活着，servlet就活着 service()
- 死亡：（销毁）应用卸载了servlet就销毁。destroy()

## Servlet实现方式

- javax.servlet.Servlet接口（参见：编写一个servlet程序：）

- 继承javax.servlet.GenericServlet类(适配器模式)
 
- 继承javax.servlet.http.HttpServlet类（模板方法设计模式）
    - 常用
    - 不需要重写service()
    
## Servlet线程安全
    
- 线程同步与互斥

## Servlet线程同步

## ServletConfig

## ServletContext

- 单实例，代表当前整个应用对象



