webserver  tomcat 7 
mysql 5.5

//ÅúÁ¿É¾³ý
public boolean test(String id) { 
         String [] ids=id.split(","); 
          try { 
            SqlMapClient client = IbatisFactory.getSqlMapClient(); 
            client.delete("test", ids); 
            return true; 
        } catch (SQLException ex) { 
            ex.printStackTrace(); 
            return false; 
        } 
    } 





<delete id="test" > 
       delete from tablename where id in ( 
        <iterate  conjunction=",">#[]#</iterate>) 
</delete> 
