import com.vmm.JHTTPServer;
import java.io.*;
import java.util.*;
import vmm.DBLoader;
import java.sql.*;

public class MyServer extends JHTTPServer
{
    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) 
    {
        String ans = "";
        
        if(uri.equals("/"))
        {
            ans = "Welcome to My Server";
        }
        
        //--------------------------------------------------------------------------------------
        else if(uri.equals("/checkLogin"))
        {
            String u = parms.getProperty("user");   // rohit
            String p = parms.getProperty("pass");   // 123
            
            ans = "";
            
            // now check from Db
            try
            {
                String sql = "select * from users where username='"+u+"'and password='"+p+"'";
                ResultSet rs = DBLoader.executeSQL(sql);
                
                if(rs.next())
                {
                    ans = "Login Successfull ...";
                }
                else
                {
                    ans = "Login Failed !!!";
                }
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        else if(uri.equals("/signup"))
        {
            // 1.recieve text
            String u = parms.getProperty("user");
            String p = parms.getProperty("pass");
            String m = parms.getProperty("mobile");
            String e = parms.getProperty("email");
            
            // step 2 and 3, recieve files and save file on server
            String abspath = "src/uploads/users";
            String photo_name = saveFileOnServerWithOriginalName(files, parms, "f1", abspath);
            
            ans = "";
            
            // 4. record in DB (Insert)
            try 
            {
                String sql = "select * from users where username='"+u+"'";
                ResultSet rs = DBLoader.executeSQL(sql);
                
                if(rs.next())
                {
                    ans = "This username is Already Taken";
                }
                else
                {
                    // Insert
                    rs.moveToInsertRow();
                    
                    rs.updateString("username", u);
                    rs.updateString("password", p);
                    rs.updateString("mobile", m);
                    rs.updateString("email", e);
                    rs.updateString("photo", abspath+"/"+photo_name);
                    
                    rs.insertRow();
                    
                    ans = "Successfully added to Database";
                }
            }
            catch (Exception ex) 
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        
        else if(uri.equals("/getUserDetail"))
        {
            String u = parms.getProperty("user");   // rohit
            ans = "";
            
            // now check from DB
            try
            {
                String sql = "select * from users where username='"+u+"'";
                ResultSet rs = DBLoader.executeSQL(sql);
                String ph = "";
                
                if(rs.next())
                {
                    ph = rs.getString("photo");
                }
                
                ans = ph; 
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        
        else if(uri.equals("/getCategory"))
        {
            ans = "";
            
            try
            {
                String sql = "select * from category";
                ResultSet rs = DBLoader.executeSQL(sql);
                
                String catName, catPhoto;
                
                while(rs.next())
                {
                    catName = rs.getString("catname");
                    catPhoto = rs.getString("photo");
                    
                    ans = ans + catName+","+catPhoto+";";
                }
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        
        else if(uri.equals("/addCategory"))
        {
            String catname = parms.getProperty("catname");
            
            // step 2 and 3, recieve files and save file on server
            String abspath = "src/uploads/categories";
            String photo_name = saveFileOnServerWithOriginalName(files, parms, "f1", abspath);
            
            ans = "";
            
            // 4. record in DB (Insert)
            try 
            {
                String sql = "select * from category where catname='"+catname+"'";
                ResultSet rs = DBLoader.executeSQL(sql);
                
                if(rs.next())
                {
                    ans = "This category Already exist";
                }
                else
                {
                    // Insert
                    rs.moveToInsertRow();
                    
                    rs.updateString("catname", catname);
                    rs.updateString("photo", abspath+"/"+photo_name);
                    
                    rs.insertRow();
                    
                    ans = "Successfully added to Database";
                }
            }
            catch (Exception ex) 
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        
        else if(uri.equals("/addVideo"))
        {
            // 1. recieve Text
            String title = parms.getProperty("title");
            String desc = parms.getProperty("desc");
            String trailer = parms.getProperty("trailer");
            String catname = parms.getProperty("catname");
            String runtime = parms.getProperty("runtime");
           
            // 2,3. recieve and save file on server
            String abspath1 = "src/uploads/poster";
            String poster_name = saveFileOnServerWithOriginalName(files, parms, "poster", abspath1);
            
            String abspath2 = "src/uploads/video";
            String video_name = saveFileOnServerWithOriginalName(files, parms, "video", abspath2);
            
            // 4. now record in DB
            try
            {
                String sql = "select * from videos where vname='"+title+"'";
                ResultSet rs = DBLoader.executeSQL(sql);
                
                if(rs.next())
                {
                    ans = "This Video Name Already Exists !!!";
                }
                else
                {
                    rs.moveToInsertRow();
                    
                    rs.updateString("vname", title);
                    rs.updateString("description", desc);
                    // Files
                    rs.updateString("photo", abspath1+"/"+poster_name);
                    rs.updateString("videolink", abspath2+"/"+video_name);
                    
                    rs.updateString("trailerlink", trailer);
                    rs.updateString("catname", catname);
                    rs.updateString("runningtime", runtime);
                    
                    rs.insertRow();
                    
                    ans = "New Movie Added Successfully !!!";
                }
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        
        else if(uri.equals("/getVideos"))
        {
            String catname = parms.getProperty("catname");
            
            try
            {
                String sql = "select * from videos where catname='"+catname+"'";
                ResultSet rs = DBLoader.executeSQL(sql);
                
                while(rs.next())
                {
                    int vid = rs.getInt("vid");
                    String vname = rs.getString("vname");
                    String photo = rs.getString("photo");
                    
                    ans = ans + vid+","+vname+","+photo+";";
                }
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        
        else if(uri.equals("/getVideoDetail"))
        {
            int vid = Integer.parseInt(parms.getProperty("vid"));
            
            try
            {
                String sql = "select * from videos where vid="+vid;
                ResultSet rs = DBLoader.executeSQL(sql);
                
                if(rs.next())
                {
                    String vname = rs.getString("vname");
                    String desc = rs.getString("description");
                    String photo = rs.getString("photo");
                    String videolink = rs.getString("videolink");
                    String trailerlink = rs.getString("trailerlink");
                    String catname = rs.getString("catname");
                    String runningtime = rs.getString("runningtime");
                    
                    ans = vname+","+desc+","+photo+","+videolink+","+trailerlink+","+catname+","+runningtime;
                }
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        
        else if(uri.equals("/playmovie"))
        {
            String movie_path = parms.getProperty("movie_path");
            
            Response res = streamFile(movie_path, method, header);
            return res;
        }
        
        //--------------------------------------------------------------------------------------
        
        else if(uri.equals("/checkAdminLogin"))
        {
            String u = parms.getProperty("user");
            String p = parms.getProperty("pass");
            
            // now check from DB
            try
            {
                String sql = "select * from admin where username='"+u+"'and password='"+p+"'";
                ResultSet rs = DBLoader.executeSQL(sql);
                
                if(rs.next())
                {
                    ans = "success";
                }
                else
                {
                    ans = "fail";
                }
            }
            catch(Exception ex)
            {
                ans = ex.toString();
            }
        }
        
        //--------------------------------------------------------------------------------------
        
        else
        {
            ans = "Invalid uri";
        }
        
        Response res = new Response(HTTP_OK, "text/plain", ans);
        return res;
    }
    
    public MyServer(int port) throws IOException 
    {
        super(port);
    }
}