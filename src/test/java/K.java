import org.testng.annotations.Test;

public class K {


    public static final String TODOS = "https://jsonplaceholder.typicode.com/todos";

    public static final String CLOCK = "com.google.android.deskclock:";
    public static String findByUserID(int id){
        return TODOS + "?userId=" + id;
    }

    public static String updateJSON(Boolean status){
//        return "{\n \"userId\": " + userId + ",\n\"title\": " + title + ",\n\"completed\": " + status + "\n}";
//        return "{\n\"completed\": " + status + "\n}";
        return "{\"completed\": " + status + "}";
    }
    public static String buildJSON(int userId, String title, Boolean status){
//        return "{\n \"userId\": " + userId + ",\n\"title\": " + title + ",\n\"completed\": " + status + "\n}";
        return "{\n\"userId\": " + userId + ",\n\"title\":\" " + title + "\",\n\"completed\": " + status + "\n}";
    }
}



/*
{
    "userId": 10,
    "id": 200,
    "title": "ipsam aperiam voluptates qui",
    "completed": false
  }
 */












