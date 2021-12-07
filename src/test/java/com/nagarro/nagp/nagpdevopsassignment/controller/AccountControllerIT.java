package com.nagarro.nagp.nagpdevopsassignment.controller;

import com.google.gson.Gson;
import com.nagarro.nagp.nagpdevopsassignment.NagpDevopsAssignmentApplication;
import com.nagarro.nagp.nagpdevopsassignment.model.common.UserRole;
import com.nagarro.nagp.nagpdevopsassignment.model.request.AccountRequestDTO;
import com.nagarro.nagp.nagpdevopsassignment.model.response.AccountResponseDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { NagpDevopsAssignmentApplication.class })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerIT {

    public static final String ACCOUNT_URI_PATH = "/account/";
    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        RestAssured.port = this.port;
    }

    @Test
    public void shouldSaveAccount() {
        AccountRequestDTO accountRequestDTO = AccountRequestDTO.builder()
                .firstName("FirstName")
                .lastName("LastName")
                .username("TestUserName")
                .password("TestPassword")
                .userRole(UserRole.CUSTOMER)
                .build();

        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(new Gson().toJson(accountRequestDTO))
                .when()
                .post(ACCOUNT_URI_PATH)
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());

        response = RestAssured.
                given().
                accept(ContentType.JSON).
                when().
                get(ACCOUNT_URI_PATH).
                then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                extract().response();

        assertEquals(200, response.statusCode());

        Long id = response.jsonPath().getList("", AccountResponseDTO.class).get(0).getId();

        response = RestAssured.given()
                .when()
                .delete(ACCOUNT_URI_PATH + id)
                .then()
                .extract().response();

        assertEquals(200, response.statusCode());



    }
}
