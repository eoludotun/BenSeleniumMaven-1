package stepdefinitions;


import pageobjects.LoginPage;



//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class LoginSteps {
	//private static final Logger log = LogManager.getLogger(LoginSteps.class);

    LoginPage loginPage = new LoginPage();

    @Given("^User Signin using \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void userSigninUserAndPassword(String username,String password){

        assertThat(loginPage.gotoSignInPage(), is(true));
        loginPage.userLoginWith(username,password);
        //log.info("Given: Browser is open");
        System.out.println("Given: Browser is open");
       


    }

    @Then("^User Should Signin Successful$")
    public void successfulSignin(){
        assertThat(
                loginPage.signedInUser().
                        pageTitle(),
                not("Amazon Sign In"));


    }
//
//    @Then("^Notification Message should be \"([^\"]*)\"$")
//    public void messageShouldBeDisplayed(String message) throws Throwable {
//    	// log.info("Given: Browser is open");
//            assertThat(loginPage.errorMessages(),
//                hasItem(message));
//         //   log.info("Given: Browser is open");
//
//    }
//

}
