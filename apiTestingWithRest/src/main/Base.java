package main;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

public class Base {

	public static Response getCapitalCityByName(String countryName) {
		String url = "https://restcountries.com/v3.1/name/" + countryName;
		RequestSpecification restAssured= RestAssured.given();
		Response response= restAssured.get(url);
		return response;
	}

	public static Response getCapitalCityByCode(String ... countryCode) {
	if(countryCode.length==1) {
		String url="https://restcountries.com/v3.1/alpha/" +countryCode[0];
		RequestSpecification restAssured= RestAssured.given();
		Response response= restAssured.get(url);
		return response;
	}
	else {
	String url="https://restcountries.com/v3.1/codes=";

	for(String i : countryCode){
          url = url.concat(","+i);
      }
		RequestSpecification restAssured= RestAssured.given();
		Response response= restAssured.get(url);
		return response;
	}

	}
	public static void assertStatusCode(Response r,int a)	{
		Assert.assertEquals(r.statusCode(),a);
	}

	public static void assertCityName(Response r, String expected)	{
		JsonPath json = r.jsonPath();
		String cap=json.get("[0].capital").toString().replace("[", "").replace("]", "");
		String cap2 = StringUtils.stripAccents(cap).toLowerCase();
		String expected2=expected.toLowerCase();
		Assert.assertEquals(cap2, expected2);
	}


	}
