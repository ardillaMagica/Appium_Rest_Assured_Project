import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssured {

    //get
    @Test
    void getAllToDos(){
        given().when().get(K.TODOS).then().log().all();
    }

    @Test
    void getToDosByUserID(){
        given().when().get(K.findByUserID(5)).then().log().all();
    }

    //post
    @Test
    void postToDo(){
        given().contentType(ContentType.JSON).body(K.buildJSON(10, "new task", false))
                .post(K.TODOS).then().statusCode(201);
    }

    //put
    @Test
    void putTest(){
        given().contentType(ContentType.JSON).body(K.updateJSON(true))
                .put(K.TODOS + "/1").then().statusCode(200);
    }

    //delete
    @Test
    void deleteTest(){
        given().when().delete(K.TODOS + "/6").then().statusCode(200);
    }
}
