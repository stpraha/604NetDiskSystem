# 604NetDiskSystem
<br>
A Net Disk System based on java, mybatis, springmvc, maven
<br>

Still under development
-----------------------
到现在为止用到的技术：<br>
<strong>后端：</strong><br>
`spring`<br>
`springMVC`<br>
`maven`<br>
`mybatis`<br>
<strong>前端：</strong><br>
`bootstrap`<br>
`web uploader`<br>
`jsp`<br>

Some Sample Pictures
--------------------
1. 主界面展示图<br>
用了bootstrap的组件，分为公共文件，私人文件，说明页，个人中心（管理文件，上传文件，登录/注销）<br>
![pic1](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/filepageSample.png)

2. 文件上传页面展示图<br>
用了web uploader来进行文件上传，最大同时上传个数为3，<strong>todo: 实现文件拆分上传</strong><br>
![pic2](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/uploadSample.png)

3. 文件管理页面展示图<br>
![pic3](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/filemanageSample.png)

4. 登录/注册页面展示图<br>
![pic4](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/loginSample.png)
![pic5](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/registerSample.png)

4. 用户验证提示<br>
![pic6](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/nologinSample.png)



progress
--------
2019-4-16: mybatis is used in this project to deal with mysql.<br>

2019-4-25: use session to keep user-status.<br>

2019-4-26: user login status can be kept. fixed some bugs. Add user <strong>user verification</strong> in <strong>pages</strong> and <strong>controllers</strong>.<br>

2019-4-29: add simple download function.(not bug free)<br>

Although ModelAndView is too old, it is used here.<br>
Model, RedirectAttributes are invalid. I don't know why.<br>


what to do next: download file; user keep alive, user login status maintained<br>
