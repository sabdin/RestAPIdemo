package main;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static main.Base.*;

public class NegativeTests {
    @Test
    public void testNegUSAbyName() {
        Response r = getCapitalCityByName("unite states");
        assertStatusCode(r, 404);
    }

    @Test
    public void testNegColByCode() {
        Response r = getCapitalCityByCode("code=col");
        assertStatusCode(r, 400);
    }

}
