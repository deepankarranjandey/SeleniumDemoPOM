package com.qacart.todo.testcases;

import com.qacart.todo.apis.UserAPI;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.models.User;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;

public class DummyTest extends BaseTest {

    public void dummy()
    {
        User user = new User();

        Response res= UserAPI.getInstance().register(user);
        String access_token=res.path("access_token");
        String userID=res.path("userID");
        String firstName=res.path("firstName");

        Cookie accessTokenCookie= new Cookie("access_token", access_token);
        Cookie userIDCookie= new Cookie("userID", userID);
        Cookie firstNameCookie= new Cookie("firstName", firstName);
    }
}
