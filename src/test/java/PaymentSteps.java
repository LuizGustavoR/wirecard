import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Constants;
import utils.ReadFile;

import static io.restassured.RestAssured.given;

public class PaymentSteps {

    private static final String URL_ORDER = "/v2/orders";
    private static final String URL_PAYMENTS = "/v2/orders/{order-id}/payments";
    private static final String AUTH = "Authorization";
    private static final String CONTENT_TYPE = "Content-Type";

    @BeforeTest
    public void setup() {
        RestAssured.baseURI = Constants.URL_SANDBOX;
        RestAssured.port = 443;
    }

    private String idOrder;

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

        JsonPath jsonPath = new JsonPath(resp.getBody().asString());
        idOrder = jsonPath.getString("id");

    }

    @Test(priority=1)
    public void make_payment_success() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_success.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(201);

    }

    @Test(priority=2)
    public void make_payment_already_payed() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_success.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=3)
    public void make_payment_id_not_found() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_success.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", "abcd"));
        resp.then().statusCode(404);

    }

    // Start required tests

    @Test(priority=4)
    public void make_payment_required_fundingInstrument() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_fundingInstrument.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=5)
    public void make_payment_required_method() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_method.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=6)
    public void make_payment_required_fullname() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_fullname.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=7)
    public void make_payment_required_birthdate() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_birthdate.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=8)
    public void make_payment_required_phone() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_phone.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=9)
    public void make_payment_required_countryCode() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_countryCode.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=10)
    public void make_payment_required_number() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_number.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=11)
    public void make_payment_required_taxDocument() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_taxDocument.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=12)
    public void make_payment_required_taxDoc_type() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_taxDoc_type.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=13)
    public void make_payment_required_taxDoc_number() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_required_taxDoc_number.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    // Start limit tests

    @Test(priority=14)
    public void make_payment_limit_areaCode() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_limit_areaCode.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=15)
    public void make_payment_limit_cnpj() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_limit_cnpj.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=16)
    public void make_payment_limit_countryCode() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_limit_countryCode.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=17)
    public void make_payment_limit_cpf() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_limit_cpf.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=18)
    public void make_payment_limit_fullname() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_limit_fullname.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

    @Test(priority=19)
    public void make_payment_limit_number() {

        String file = ReadFile.getFile(Constants.JSON_PATH + "payment_limit_number.json");
        JSONObject jsonObject = new JSONObject(file);

        Response resp = given().
                header(CONTENT_TYPE, "application/json").
                header(AUTH, Constants.AUTHORIZATION).
                body(jsonObject.toString()).
                when().
                post(URL_PAYMENTS.replace("{order-id}", idOrder));
        resp.then().statusCode(400);

    }

}
