# Session

## Session与Cookie比较

- cookie客户端技术，只能存字符串。HttpSession服务器端的技术，它可以存对象。

## 方法

- void setAttribute(String name,Object value);
- Object getAttribute(String name);
- void removeAttribute(String name);
- HttpSession.getId():
- setMaxInactiveInterval(int interval)  设置session的存活时间
- invalidate() 使此会话无效
- getSession()
    1. 获取名称为JSESSIONID的cookie的值。
    2. 没有这样的cookie，创建一个新的HttpSession对象，分配一个唯一的SessionID，并且向客户端写了一个名字为JSESSIONID=sessionID的cookie
    3. 有这样的Cookie，获取cookie的值（即HttpSession对象的值），从服务器的内存中根据ID找那个HttpSession对象：
    4. 找到了：取出继续为你服务。
    5. 找不到：从2开始。



