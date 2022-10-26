package com.juaracoding.restassured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class TestAPIRizkiMaulana {

    @Test
    public void testGet() {
        //
        JSONObject request = new JSONObject();
        request.put("name", "Mesin Cuci");
        request.put("category", "Elektronik");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .get("https://mern-backend-8881.herokuapp.com/products")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("name", "Mesin Cuci");
        request.put("category", "Elektronik");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://mern-backend-8881.herokuapp.com/products")
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void testPatch() {
        JSONObject request = new JSONObject();
        request.put("name", "Mesin Cuci");
        request.put("category", "Elektronik");
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://mern-backend-8881.herokuapp.com/products")
                .then()
                .statusCode(404)
                .log().all();
    }

    @Test
    public void testDelete() {

        when()
                .delete("https://mern-backend-8881.herokuapp.com/products")
                .then()
                .statusCode(404)
                .log().all();

    }

    @Test
    public void apiKeyAuth() {
        given()
                .queryParam("api_key", "62e210f1f0e24546b900e05f")
                .when()
                .get("https://mern-backend-8881.herokuapp.com/products")
                .then().statusCode(200);
    }
}
