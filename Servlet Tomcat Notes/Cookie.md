# Cookie

## 属性

- name：名称不能唯一确定一个Cookie。路径可能不同。
- value：不能存中文。
- path：默认值是写Cookie的那个程序的访问路径
    - 比如：http://localhost:8080/day10_00_cookie/servlet/ck1写的Cookie
    - path就是：/day10_00_cookie/servlet 看当前创建cookie的资源（servlet）文件路径 
    - 客户端在访问服务器另外资源时，根据访问的路径来决定是否带着Cookie到服务器
    - 当前访问的路径如果是以cookie的path开头的路径，浏览器就带。否则不带。
- maxAge：cookie的缓存时间。默认是-1（默认存在浏览器的内存中）。单位是秒。
    - 负数：cookie的数据存在浏览器缓存中
    - 0：删除。路径要保持一致，否则可能删错人。
    - 正数：缓存（持久化到磁盘上）的时间
