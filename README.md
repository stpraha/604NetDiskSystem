# 604NetDiskSystem
<br>
A Net Disk System based on java, mybatis, springmvc, maven
<br>

Still under development
-----------------------
Technology used now<br>
<br>
`spring`<br>
`springMVC`<br>
`maven`<br>
`mybatis`<br>
<br>
`bootstrap`<br>
`web uploader`<br>
`jsp`<br>

Some details
------------
Now picture files can be previewed in FilePage.<br>

Logs have been added in this program (Log4j2). After start running, in Tomcat `root/NetDisk/logs`, you can find logs.<br>



Some Sample Pictures
--------------------
1. Main page<br>
![pic1](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/filepageSample.png)

2. Upload page<br>
WebUploader(Baidu) has been used in this program to upload files.<strong>todo: chunked upload</strong><br>
![pic2](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/uploadSample.png)

3. File management page<br>
![pic3](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/filemanageSample.png)

4. Login/register page<br>
![pic4](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/loginSample.png)
![pic5](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/registerSample.png)

5. Error<br>
![pic6](https://github.com/stpraha/604NetDiskSystem/blob/master/SamplePics/nologinSample.png)



progress
--------
2019-04-16: mybatis is used in this project to deal with mysql.<br>

2019-04-25: use session to keep user-status.<br>

2019-04-26: user login status can be kept. fixed some bugs. Add user <strong>user verification</strong> in <strong>pages</strong> and <strong>controllers</strong>.<br>

2019-04-29: add simple download function.(not bug free)<br>

2019-05-05: add picture preview function. fix some bug. make the store path English.<br>

2019-05-10: add log function.

Although ModelAndView is too old, it is used here.<br>
Model, RedirectAttributes are invalid. I don't know why.<br>


what to do next: chunked upload. Manager function.<br>
