package todo_test;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C04_DeleteTodo extends JsonPlaceHolderBaseUrl {
/*
     Given
       1) https://jsonplaceholder.typicode.com/todos/15
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
          }
    When
        I send Delete Request to the Url

    Then
        Status code is 200
    And
        response body is like
                                {

                                }
*/

    @Test
    public void postRequestTest() {

        //Set the url
        spec.pathParams("first", "todos", "second", 15);

        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");

        response.prettyPrint();

        //Do Assertion
        response
                .then()
                .statusCode(200)
                .body(equalTo("{}"));

    }
}
