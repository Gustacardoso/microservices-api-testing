package test;
import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

public class BaseApi {

   @BeforeMethod
   public static void baseapi(){
      baseURI = property("api.baseUri", "API_BASE_URI", "http://localhost");
      basePath = property("api.basePath", "API_BASE_PATH", "/api");
      port = Integer.parseInt(property("api.port", "API_PORT", "8080"));

      config = RestAssuredConfig.newConfig().jsonConfig(JsonConfig.jsonConfig().numberReturnType(BIG_DECIMAL));
      enableLoggingOfRequestAndResponseIfValidationFails();
   }

   private static String property(String systemProperty, String envVar, String defaultValue) {
      String value = System.getProperty(systemProperty);
      if (value == null) {
         value = System.getenv(envVar);
      }
      return value == null ? defaultValue : value;
   }

}
