package LumaTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.annotations.AfterSuite;

public class CallingLumaTests {
	WebDriver dr=new ChromeDriver();
	
	LumaLogin objLogin;	
	
	  @BeforeMethod
  public void launchBrowserTest() throws InterruptedException {
	  System.out.println("Before Method : URL Launch");	  
	  objLogin=new LumaLogin(dr);
	  objLogin.launchBrowser();
	  }	 
	
  @Test(priority = 1)  //TestCase to Create Account
  public void createAccountTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  objLogin.createAccount();
  }

  @Test(priority = 2) //Negative TestCase : Valid User with Incorrect Password 
  public void PassInvalidTest() throws InterruptedException, IOException {
	  objLogin=new LumaLogin(dr);
	  objLogin.signInInvalidCred(1);
  }
  @Test(priority = 3) //Negative TestCase : Invalid /non exsting user email address 
  public void  emailInvalidTest() throws InterruptedException, IOException {
	  objLogin=new LumaLogin(dr);
	  objLogin.signInInvalidCred(2);
  }
  @Test(priority = 4)  //Negative TestCase : Email Address in wrong format . @ /.com not present 
  public void  incorrectEmailformat() throws InterruptedException, IOException {
	  objLogin=new LumaLogin(dr);
	  objLogin.signInInvalidCred(3);
  }
  @Test(priority = 5) //TestCase to Signin with valid credentials 
  public void signInTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  objLogin.signIn();
  } 

  @Test(priority = 6) //TestCase to select a submenu under womens category
  public void shopWomenTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  objLogin.shopWomenTops();
  }
  
  @Test(priority = 7)     //TestCase to verify filter 
  public void filterTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  objLogin.shopWomenTops();
	  objLogin.filterTees();
  } 
  
  @Test(priority = 8)     //TestCase to verify multiple filters 
  public void multipleFilterTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  objLogin.multipleFilters();
	  
  } 
  
  @Test(priority=9)   // Testcase to hover through the navigation links and click each link once 
  public void checkNavTest () throws InterruptedException
  {
	  objLogin.checkNavs();
	  
	  
  } 
  
  
  @Test(priority = 10)  //TestCase to select a submenu under mens category
  public void shopMenTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  objLogin.shopmenJackets();
  }
  
  @Test(priority = 11)  //TestCase to select a submenu under mens category and sort by price
  public void shopMenSortByTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  objLogin.shopMenSortJackets();
  }
  
  
  
  //addToCart 
  
  @Test(priority = 12)   //TestCase to verify add to cart feature
  public void addToCartTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  objLogin.addToCart();
  }
  
  @Test(priority = 13,dependsOnMethods = { "addToCartTest" }) //Test case to verify the item in cart still remains after a logout.this testcase should run only after add to cart 
  public void cartAfterSignout() throws InterruptedException
  {
	  
	  objLogin=new LumaLogin(dr);
	  objLogin.signOut();
	  objLogin.signIn();
	  objLogin.checkCart();
  }
  
  @Test(priority = 14,dependsOnMethods = { "addToCartTest" }) //Test case to verify if Quantity can be updated in Cart.this testcase should run only after add to cart
  public void updateCartTest() throws InterruptedException
  {
	  objLogin.updateCart();
  }
  
  
  @Test(priority = 15,dependsOnMethods = { "addToCartTest" }) //Test case to verify if item can be removed from cart using Delete button.this testcase should run only after add to cart
  public void removeFromCartTest() throws InterruptedException
  {
	  objLogin.removeCart();
  }
    
  //TestCase to verify add to WishList Feature
  @Test(priority = 16)  
  public void addtoWishlistTest() throws InterruptedException
  {
	  objLogin.addtoWishlist();
  }
  
  // wishListCheck()
  @Test(priority = 17)   //Test case to validate the WishList
  public void checkWishList() throws InterruptedException
  {
	  objLogin.wishListCheck();
	  
  }  
  
  @Test(priority = 18)  //TestCase to verify remove from WishList feature
  public void removeWishListTest() throws InterruptedException
  {
	  objLogin.wishListCheck();
	  objLogin.removeFromWishList();
  }


  @Test(priority = 19)   //TestCase to Verify add address feature
  public void addressTest() throws InterruptedException
  {
	  objLogin.addAddress();
  } 
  
 
  @Test(priority = 20)   //TestCase to Verify if checkout working as expected
  public void checkoutTest() throws InterruptedException
  {
	  objLogin.addToCart();//Calling add to cart to add an item to the cart before Checkout
	  objLogin.checkout();
  }   
  
  
  @Test(priority = 21)    //TestCase to Verify if orders is updated
  public void checkOrdersTest () throws InterruptedException
  {
	  objLogin.checkOrders();
	}  
    
  //Window Navigation
  @Test(priority = 22)   //TestCase to Verify browser window navigations(back and forward)
  public void navigateTest () throws InterruptedException
  {
	  objLogin.navigationCheck();
	  
  }     
  //Add Review
  @Test(priority = 23)    //TestCase to add review
  public void addReviewTest () throws InterruptedException
  {
	  objLogin.addReview();
	  
  } 
   
  @Test(priority = 24)    //TestCase to Verify Search Feature from the Search Bar
  public void searchboxTest () throws InterruptedException
  {
	  objLogin.searchBox();
	  
  } 
  
  //screenshot 
  @Test(priority=25)   //TestCase to Verify a ScreenShot Capture Scenario 
  public void ScreenshotsTest () throws InterruptedException, IOException
  {
	  objLogin.screenshotItem();
	  
	  
  }   


  @Test(priority = 26) // TestCase to verify SignOut
  public void signOutTest() throws InterruptedException {
	  objLogin=new LumaLogin(dr);
	  //objLogin.signIn();
	  objLogin.signOut();
  }  
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");	  
  }
  
  

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Test Suite Begin Step ");
  }

  @AfterSuite
  @SuppressWarnings("all")
  public void afterSuite() {
	  System.out.println("Test Suite end Step ");
	  dr.close();
  }

}
