# SpringMVC_1128_JPA  
<img src="https://github.com/lucky85406/SpringMVC_1128_JPA/blob/master/src/main/webapp/portfolio/images/portfolio.png">

### 2020/02/14
```
* 0100:  
	完成修改，網頁正常執行，加入Readme.txt  
* 1400:
	watchlist.jsp 修改symbol,name 增加alert()顯示產品名稱  
	menu.jspf 修改side-menu.css 欄位風格設計  
	tstock.jsp 新增 auto_refresh 讓進入Tstock時自動更新價格  
	watch.jsp 新增標題出現觀察名稱  
	login bug 修改程式碼 investor.jsp , login.jsp , InvestorController.java , LoginController.java  
	*.jsp 新增 title資訊  
```
## 2020/02/18
```
* 2015:  
	com.mail.sendEmail 新增 Email驗證功能  
	Investor.java,InvestorController.java,LoginController.java 修改 新增 code,pass欄位  
            code 用來給使用者驗證碼  
            pass 用來判定新舊使用者  
	Investor.jsp 新增 code pass 欄位  
* 2055:  
	EmailService.java 新增 Email伺服器 用來寄送Email驗證信  
	springmvc-servlet 修改 <context:component-scan base-package="com.web.portfolio.*"/>  
	InvestorController.java 新增verify 當新增(add)使用者時寄送驗證信  
* 2135:  
	versify.jsp 新增  
	LoginFilter.java 修改 利用過濾器來導進versify.jsp  
	LoginController.java 新增 versify類別 回傳驗證資訊  
```
## 2020/02/22
```
* 1055:  
	investor.jsp 新增驗證功能 新增、修改時 balance值不為0或空值 
```
## 2020/02/23
```
* 0238:  
	LoginFilter.java 修改過濾器 使得Regist.jsp可略過過濾器
* 1138:
        regist.jsp 新增 基本註冊功能、信箱註冊功能
        forget.jsp 建立
        forget.jsp 新增 驗證碼控制，當驗證碼長度正確按鈕顯示
        ForgetController.java 建立
                       
```
## 2020/02/25
```
* 1908:  
	forget.jsp 新增 信箱驗證功能 輸入信箱傳送驗證碼
        forgetController.java 新增 get(),send()功能,取得使用者資料與寄送郵件
* 2000:
        forgetController.java 新增 update()功能,將取得的驗證碼輸入與資料比對，相符合才能正常更改密碼
        forgetController.java 修改 修改密碼時同時變更新的VerifyCode
* 2100:
        tstock.jsp、watchlist.jsp 修改 自動更新列表

                       
```