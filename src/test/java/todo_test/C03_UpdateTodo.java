package todo_test;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C03_UpdateTodo extends JsonPlaceHolderBaseUrl {
/*
     Given
       1) https://jsonplaceholder.typicode.com/todos/15
       2)  {
             "userId": 55,
             "title": "Read Books",
             "completed": false
            }
    When
        I send PUT Request to the Url

    Then
        Status code is 200
    And
        response body is like {
                                "userId": 55,
                                "title": "Read Books",
                                "completed": false,
                                "id": 201
                                }
*/

    @Test
    public void postRequestTest() {

        //Set the url
        spec.pathParams("first", "todos", "second", "15");

        //Set the expected data --> Payload
        String expectedData = """
                {
                    "userId": 55,
                    "title": "Read Books",
                    "completed": false
                }
                """;
        //Send the request and get the response
        Response response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        response
                .then()
                .statusCode(200)
                .body("userId", equalTo(55),
                        "title", equalTo("Read Books"),
                        "completed", equalTo(false));

    }
}
