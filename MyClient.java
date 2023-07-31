import com.mashape.unirest.http.*;
import java.awt.Desktop;
import java.io.File;
import java.net.URI;

// ctrl shift minus ( collapse all functions )

public class MyClient 
{
    // uri = /
    public static String fetchIndex()
    {
        try
        {
          String url = "http://localhost:9000/";
          HttpResponse<String> res = 
                  Unirest.get(url).asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    // get(url)             --> send text
    public static String checkLogin(String u, String p)
    {
        try
        {
          String url = "http://localhost:9000/checkLogin?user="+u+"&pass="+p;   // query string
          HttpResponse<String> res = 
                  Unirest.get(url).asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }

    // post(url).field()    --> can send both (text + file)
    public static String signupUsingServer(String u, String p, 
                                           String m, String e, File ph)
    {
        try
        {
          String url = "http://localhost:9000/signup";
          
          // send text as       .query string
          // send file as       .field
          HttpResponse<String> res = 
                  Unirest.post(url)
                          .queryString("user", u)
                          .queryString("pass", p)
                          .queryString("mobile", m)
                          .queryString("email", e)
                          
                          .field("f1", ph)
                          .asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
        
    // Welcome Photo
    public static String getUserDetailFromServer(String u)
    {
        try
        {
          String url = "http://localhost:9000/getUserDetail?user="+u;
          HttpResponse<String> res = 
                  Unirest.get(url).asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    public static String getCategoryFromServer()
    {
        try
        {
          String url = "http://localhost:9000/getCategory";
          HttpResponse<String> res = 
                  Unirest.get(url).asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    public static String addCategory(String catname, File ph)
    {
        try
        {
          String url = "http://localhost:9000/addCategory";
          HttpResponse<String> res = 
                  Unirest.post(url)
                          .queryString("catname", catname)
                          .field("f1", ph)
                          .asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    public static String addVideo(String title, String desc, File poster, File video,
                                  String trailer, String catname, int runtime)
    {
        try
        {
          String url = "http://localhost:9000/addVideo";
          HttpResponse<String> res = 
                  Unirest.post(url)
                          .queryString("title", title)
                          .queryString("desc", desc)
                          .queryString("trailer", trailer)
                          .queryString("catname", catname)
                          .queryString("runtime", runtime+"")
                          
                          
                          .field("poster", poster)
                          .field("video", video)
                          .asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    public static String getVideosFromServer(String catname)
    {
        try
        {
          String url = "http://localhost:9000/getVideos?catname="+catname;
          HttpResponse<String> res = 
                  Unirest.get(url).asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    public static String getSingleVideoDetailFromServer(int vid)
    {
        try
        {
          String url = "http://localhost:9000/getVideoDetail?vid="+vid;
          HttpResponse<String> res = 
                  Unirest.get(url).asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return ex.toString();
        }
    }
    
    public static void playMovie(String movie_path)
    {
        try
        {
            Desktop.getDesktop().browse(URI.create("http://localhost:9000/playmovie?movie_path="+movie_path));
        }
        catch(Exception ex)
        {
            ex.toString();
        }
    }
    
    public static String checkAdminLoginFromServer(String u, String p)
    {
        try
        {
          String url = "http://localhost:9000/checkAdminLogin?user="+u+"&pass="+p;   // query string
          HttpResponse<String> res = 
                  Unirest.get(url).asString();
         
          String ans = res.getBody();
          return ans;
        }
        catch(Exception ex)
        {
            return ex.toString();
        }
    }
}