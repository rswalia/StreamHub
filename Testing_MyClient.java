public class Testing_MyClient 
{
    public static void main(String[] args) 
    {
        MyClient obj = new MyClient();
        
        String ans = obj.fetchIndex();
        System.out.println(ans);
    }
}