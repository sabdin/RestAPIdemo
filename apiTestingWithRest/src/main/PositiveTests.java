package main;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static main.Base.*;

public class PositiveTests {
    @Test
        public void testUSAbyName(){
        Response r =getCapitalCityByName("united states");
            assertCityName(r, "Washington, D.C.");
            assertStatusCode(r,200);
        }

    @Test
    public void testColByCode(){
        Response r =getCapitalCityByCode("col");
        assertCityName(r,"Bogota");
        assertStatusCode(r,200);
    }
    @Test
    public void testJapanByName(){
        Response r =getCapitalCityByName("japan");
        assertCityName(r, "tokyo");
        assertStatusCode(r,200);
    }
}
