package stepdefinitions;


import pageobjects.HomePage;
import pageobjects.SearchPage;
import pageobjects.SearchResultsPage;



import java.util.logging.LogManager;
import java.util.logging.Logger;



public class SearchSteps  {


    private HomePage homePage = new HomePage();
    private SearchPage searchPage = new SearchPage();
    private SearchResultsPage searchResultsPage = new SearchResultsPage();
    protected final Logger logger = LogManager.getLogger(this);



    @Given("^User navigates to Amazon$")
    public void userNavigateToAmazon(){

       homePage.gotoAmazon();
      // logger.warn("Failed to send loading screenshot to Capture.");
      // logger.info("you");
    }

    @Then("^User should be on Amazon page$")
    public void pageShouldBeAmazon(){

        assertThat(
                homePage.pageTitle().
                        contains("Amazon.co.uk"),
                is(true));

    }

    @Given("^User search for \"([^\"]*)\"$")
    public void userSearchFor(String searchKeyword){

        searchPage.searchKeyword(searchKeyword);
        searchPage.submitSearch();
     //   logger.warn("Failed to send loading screenshot to Capture.");
       // logger.info("you");

    }


    @Then("^search results should contains \"([^\"]*)\"$")
    public void searchResultsShouldContain(String searchKeyword){

        assertThat(
                searchResultsPage.
                getResultTitles().toString()
                .contains(searchKeyword),is(true));

    }

    @Then("^No results should be returned$")
    public void noSearchResultReturned(){

        assertThat(
                searchResultsPage.
                        zeroSearchResults(),
                is(true));

    }
    @Then("^Message \"([^\"]*)\" should be displayed$")
    public void invalidSearchMessageShouldBeDisplayed(String message){

            assertThat(searchResultsPage
                    .searchErrorMessage(),
                    containsString(message));
            //logger.warn("Failed to send loading screenshot to Capture.");
            //logger.info("you");

    }

    @When("^User Applies Category Filter \"([^\"]*)\"$")
    public void userFiltersByCategory(String category){

        searchResultsPage.filterByCategory(category);


    }

    @Then("^Results Should be Filtered with \"([^\"]*)\"$")
    public void resultsShouldBeFilteredBy(String filter){

            assertThat(searchResultsPage.
                    resultFilteredBy(filter),is(true));

    }


    @Given("^Sort By \"([^\"]*)\"$")
    public void userSortBy(String sortBy){

        searchResultsPage.sortBy(sortBy);

    }

    @Then("^Result should be Sorted By \"([^\"]*)\"$")
    public void resultShouldBeSortedBy(String sortedBy){

        assertThat(
                searchResultsPage.sortedBy(),
                containsString(sortedBy));
    }
   

}
