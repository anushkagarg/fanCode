package RunnerTest;

import com.aventstack.extentreports.ExtentTest;

import Request.Request;
import fancode.fancode.CommonActions.GetMethod;
import fancode.fancode.ReportOutput.OutputReports;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class Runner {
    private ExtentTest test;
    private List<Integer> userIds;

    @BeforeClass
    public void setUpClass() {
        OutputReports.initReport();
        
    }
    
    @Test(priority = 1)
    public void fetchUsersFromFanCodeCity() {
    	test = OutputReports.createTest("Fancode City can be identified by lat between ( -40 to 5) and long between ( 5 to 100) in users api");
    	Response responseBody = GetMethod.ResponseBody(Request.BaseURI(),
				Request.ResourceUsers());
    	List<Integer> userIds = responseBody.jsonPath().getList("findAll { user -> " +
                "def lat = Float.parseFloat(user.address.geo.lat); " +
                "def lng = Float.parseFloat(user.address.geo.lng); " +
                "lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100 }.id");

        this.userIds = userIds;
        test.info("Fetched users from FanCode city: " + userIds);
        Assert.assertFalse(userIds.isEmpty(), "No users found in FanCode city");
    }

   
    @Test(priority = 2)
    public void VerifyTodoAPI() {
    	test = OutputReports.createTest("Verify Todo Response and Status Code");

    	String responseBody = GetMethod.ResponseBody(Request.BaseURI(),
			Request.ResourceTodo()).asString();
    
		  JsonPath js1 = new JsonPath(responseBody);
		  List<Boolean> address = js1.getList("completed");
		  int countOfTrue = 0; 
		  for(int i=0;i<address.size();i++) {
			  if(address.get(i)) { 
				  countOfTrue++; }
			  } 
		  double truthPercentage = (countOfTrue*1.0)*100/(address.size());		

        test.info("True Percentage: " + truthPercentage);
    }
	
    

    @AfterClass
    public void tearDownClass() {
        OutputReports.flushReport();
    }
}