package com.qacart.todo.apis;

import com.qacart.todo.models.User;
import com.qacart.todo.utils.ConfigUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPI {


    private static UserAPI userAPI;

    private UserAPI()
    {}
    public  static  UserAPI getInstance(){
        if (userAPI== null)
        {
         userAPI = new UserAPI();
        }
        return userAPI;
    }

    public  Response register(User user) {

        return given()
                .baseUri(ConfigUtils.getInstance().getBaseUrl())
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/api/v1/users/register")
                .then()
                .extract().response();
    }
}
