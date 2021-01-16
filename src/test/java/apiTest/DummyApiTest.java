package apiTest;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class DummyApiTest {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://dummy.restapiexample.com";

        basePath = "/api" ;
    }
    @AfterAll
    public static void tearDown(){
        reset();
    }
    @DisplayName("1.Testing /api/employees endpoint")
    @Test
    public void GetAllEmployees(){
        Response response = get("/v1/employees");
        response.prettyPrint();
        assertThat(response.statusCode(), is(200) ) ;
    }
    @DisplayName("2.Call one employee")
    @Test
    public void GetOneEmployee (){
        Response response = get("/v1/employee/5");
        response.prettyPrint();
        assertThat(response.statusCode(),is(200));
    }
    @DisplayName("3.Delete One employee")
    @Test
    public void DeleteOneEmployees(){
        Response response = get("/v1/delete/5");
        response.prettyPrint();
        assertThat(response.statusCode(), is(200) ) ; // There is a bug and it doesn't delete it
                                                           // First I have checked with POSTMAN to verify

        String message = response.jsonPath().getString("message");
        assertThat(message,is("successfully! deleted Records"));


    }
}