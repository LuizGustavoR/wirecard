import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Constants;
import utils.ReadFile;

import static io.restassured.RestAssured.given;

public class OrderSteps {

    private static final String URL_ORDER = "/v2/orders";
    private static final String AUTH = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = Constants.URL_SANDBOX;
        RestAssured.port = 443;
    }

    // E-COMMERCE

    @Test(priority=0)
    public void make_order_success() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_success.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(201);

    }

    // Start required tests

    @Test(priority=1)
    public void make_order_required_ownId() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_required_ownId.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=2)
    public void make_order_required_currency() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_required_currency.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=3)
    public void make_order_required_product() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_required_product.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=4)
    public void make_order_required_quantity() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_required_quantity.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=5)
    public void make_order_required_price() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_required_price.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=6)
    public void make_order_required_customer() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_required_customer.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    // Start limit tests

    @Test(priority=7)
    public void make_order_limit_shipping() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_limit_shipping.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=8)
    public void make_order_limit_product() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_limit_product.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=9)
    public void make_order_limit_quantity() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_limit_quantity.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=10)
    public void make_order_limit_detail() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_limit_detail.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    @Test(priority=11)
    public void make_order_limit_price() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_limit_price.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(400);

    }

    // MARKETPLACE/PLATAFORMA

    @Test(priority=12)
    public void make_order_success_marketplace() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "order_success_marketplace.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_ORDER);
        resp.then().statusCode(201);

    }

}
