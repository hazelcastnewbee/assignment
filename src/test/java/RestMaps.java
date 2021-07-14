import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import top.jfunc.json.impl.JSONObject;

import javax.sound.sampled.AudioFormat;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

class Maps {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost/clusters/dev/maps";
    }

    @Test
    public void GetMaps() {
        ResponseBodyExtractionOptions r = given()
                .when()
                .get(baseURI)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().body();
        System.out.println(r);

        given()
                .log()
                .uri();
        RequestSpecification requestSpec= RestAssured.given().baseUri("http://localhost/clusters/dev").basePath("/maps");
        requestSpec.get();
        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(requestSpec);
        String retrieveURI = queryRequest.getBaseUri();
        byte[] a = retrieveURI.getBytes(StandardCharsets.UTF_8);
        System.out.println("Base URI is : "+retrieveURI);
        String retrievePath = queryRequest.getBasePath();
        System.out.println("Base PATH is : "+retrievePath);
        String b = bytesToHex(a);
        System.out.println(b);
    }

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

}
