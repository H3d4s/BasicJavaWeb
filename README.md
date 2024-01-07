Tech: JDBC, JSP, Servlet, Jquery, tomcat, mysql,jdk 1.8	
Web có 3 page chính: 
	- Home page, User page, Admin page:
Mô tả: 
+ Home page bao gồm các nút để register, login, logout
	+ khi vào sẽ vào default là home page sau đó sẽ dựa vào phân quyền account mà redirect tới User hoặc Admin
	+ Duy trì login dựa vào session : Có 1 class SessionManager.java để quản lý 
Vậy web sẽ đi từ: Homepage: index.jsp -> trải qua phân quyền: login.java -> admin homepage/user homepage 

