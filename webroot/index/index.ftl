<html>
    <head>
		<title>HELLO,YILE IM MANAGER</title>
	</head>
	<body>IM MANAGER INDEX FTL  我是管理首页！</body>

   <hr/>  上次登录历史：
      ${loginHis}


    <hr/> 新闻管理 
        <form name=form  method=post action=../msg/query.htm>
                <td colspan=2><input type=submit value=新闻管理入口ajax /></td>
        </form>
        <form name=form method=post action=../msg/deleteById.htm?id=1>
             <td colspan=2><input type=submit value=新闻管理删除ajax参数如：id=1 /></td>
        </form>
        <form name=form  method=post action=../msg/update.htm?id=2&msgTitle="teeeee"&remark="remark1111"&msgContenxt="ddddddddddddddd">
            <td colspan=2><input type=submit value=新闻管理更新ajax参数如：id=2&msgTitle="teeeee"&remark="remark1111"&msgContenxt="ddddddddddddddd" /></td>
        </form>

       <form name=form  method=post action=../msg/deleteBatch.htm?ids=1|2|3>
            <td colspan=2><input type=submit value=新闻管理更新批量删除参数如：1|2|3 /></td>
        </form>
       
         <form name=form  method=post action=../msg/insert.htm?msgTitle=teeeee&remark=remark1111&msgContenxt=ddddddddddddddd>
            <td colspan=2><input type=submit value=新闻管理新建ajax参数如:?msgTitle="teeeee"&remark="remark1111"&msgContenxt="ddddddddddddddd"  /></td>
        </form>
        
        
     <hr/> 反馈管理
     
       <form name=form  method=post action=../fb/query.htm>
                <td colspan=2><input type=submit value=反馈ajax /></td>
        </form>
        <form name=form method=post action=../fb/deleteById.htm?id=1>
             <td colspan=2><input type=submit value=反馈ajax删除ajax参数如：id=1 /></td>
        </form>

       <form name=form  method=post action=../fb/deleteBatch.htm?ids=1|2|3>
            <td colspan=2><input type=submit value=反馈ajax批量删除参数如：1|2|3 /></td>
        </form>
       
         <form name=form  method=post action=../fb/insert.htm?fdContext=顶顶顶顶顶&connect=12908655654&companyName=tx>
            <td colspan=2><input type=submit value=反馈ajax新建ajax参数如:?fdContext=顶顶顶顶顶&connect=12908655654&companyName=tx  /></td>
        </form>
        
        
        <hr/> 用户管理
     
        <form name=form  method=post action=../um/query.htm>
                <td colspan=2><input type=submit value=用户管理ajax /></td>
        </form>
        <form name=form method=post action=../um/deleteById.htm?id=1>
             <td colspan=2><input type=submit value=用户管理删除ajax参数如：id=1 /></td>
        </form>
        <form name=form  method=post action=../um/update.htm?id=2&loginName=dingchen&userName=dingchen&idetify=tx&deptment=dx&pwd=123>
            <td colspan=2><input type=submit value=用户管理管理更新ajax参数如：id=2&loginName=dingchen&userName=dingchen&idetify=tx&deptment=dx&pwd=123ssss" /></td>
        </form>

       <form name=form  method=post action=../um/deleteBatch.htm?ids=1|2|3>
            <td colspan=2><input type=submit value=用户管理管理更新批量删除参数如：1|2|3 /></td>
        </form>
       
         <form name=form  method=post action=../um/insert.htm?loginName=dingchen&userName=dingchen&idetify=tx&deptment=dx&pwd=123>
            <td colspan=2><input type=submit value=用户管理管理新建ajax参数如:?loginName=dingchen&userName=dingchen&idetify=tx&deptment=dx&pwd=123"  /></td>
        </form>

        
</html> 