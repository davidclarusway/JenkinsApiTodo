package todo_test;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C02_GetTodo extends JsonPlaceHolderBaseUrl {
/*
     Given
       https://jsonplaceholder.typicode.com/todos/5

    When
        I send GET Request to the Url

    Then
        Status code is 200
    And
        response body is like {
                                    "userId": 1,
                                    "id": 5,
                                    "title": "laboriosam mollitia et enim quasi adipisci quia provident illum",
                                    "completed": false
                                }
*/

    @Test
    public void postRequestTest(){

        //Set the url
        spec.pathParams("first","todos","second","5");

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        response
                .then()
                .statusCode(200)
                .body("userId", equalTo(1),
                        "title",equalTo("laboriosam mollitia et enim quasi adipisci quia provident illum"),
                        "completed", equalTo(false));


    }
}
