package stepdefinitions;
//
//
//
//
//
//import java.io.File;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import pageobjects.LoginPage;
//import support.Driver;
//
//
//
//
//
//public class TryME extends Driver{
//	private static final Logger log = LogManager.getLogger(TryME.class);
//	public static final String google_PAGE = "https://www.google.com/";
//	private LoginPage loginPage = new LoginPage();
//	private TryMe tryOBJ = new TryMe();
//
//	public TryME() {
//		
//
//	        super(aDriver);
//
//	}
//
//	@Given("^I want to write a step with$")
//	public void i_want_to_write_a_step_with() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		//aDriver.navigate().to("www.https://google.com");
//		aDriver.navigate().to(google_PAGE);
//	    System.out.println("ben");
//	    //log.info("When: I login into yahoo mail");
//	    log.info("you na djd ");
//	    log.info("2222222");
//	    log.debug("debug me");
//	    log.error("error");
//	    log.warn("warm me");
//	    log.warn("another warning");
//	    
//	}
//	
//	@Then("^User Shol gggg$")
//	public void user_Shol() throws Throwable {
//		tryOBJ.load_yml_as_map_snake();
//	}
//	
//	@When("^I am able to get all fruits$")
//	public void i_am_able_to_write_it() throws Throwable {
//		tryOBJ.loadFromFile("/fruits.yml");
//	}
//	
//	@Then("^I get all fruit one at a time$")
//	public void i_get_all_fruit_one_at_a_time() throws Throwable {
//		tryOBJ.getIndividualFruit(".//src//test//dataFolder//data2.yml","address");
//		
//	}
//	
//
//
//}
