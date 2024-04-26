package todo_test;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C01_CreateTodo extends JsonPlaceHolderBaseUrl {
/*
     Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
          }
    When
        I send POST Request to the Url

    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/

    @Test
    public void postRequestTest() {

        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data --> Payload
        String expectedData = """
                {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
                """;

        //Send the request and get the response
        Response response = given(spec)
                .body(expectedData)
                .post("{first}");

        response.prettyPrint();

        //Do Assertion
        response
                .then()
                .statusCode(201)
                .body("userId", equalTo(55),
                        "title", equalTo("Tidy your room"),
                        "completed", equalTo(false));


    }
}
