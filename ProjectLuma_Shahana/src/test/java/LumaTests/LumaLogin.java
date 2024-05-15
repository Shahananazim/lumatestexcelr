package LumaTests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import jdk.jfr.Timespan;

public class LumaLogin {
	  WebDriver dr;
	  SoftAssert softAssert = new SoftAssert(); 
	  
	  public LumaLogin(WebDriver idriver) {

			dr=idriver;

			PageFactory.initElements(dr, this);

		}
	  //Repository of WebElements
	  		@FindBy(linkText="Create an Account")WebElement createAcc;
	  		@FindBy(xpath="//input[@name='firstname']")WebElement fName;
			@FindBy(xpath="//input[@name='lastname']")WebElement lName;
			@FindBy(xpath="//input[@id='email_address']")WebElement emailAd;
			@FindBy(xpath="//input[@id='password']")WebElement pass1;
			@FindBy(xpath="//input[@name='password_confirmation']")WebElement pass2;
			@FindBy(xpath="//button[@title='Create an Account']")WebElement createAccBtn;
			@FindBy(xpath="//header/div[1]/div/ul/li[2]/a")WebElement signIn;
			@FindBy(xpath="//input[@id='email']")WebElement emailId ;
			@FindBy(xpath="//input[@id='pass']")WebElement pass3 ;
			@FindBy(xpath="//button[@id='send2']")WebElement signInBtn ;
			@FindBy(xpath="//header/div[1]/div/ul/li[2]/span/button")WebElement dropdown ;
			@FindBy(partialLinkText = "Sign Out")WebElement signOutBtn ;
			@FindBy(xpath="//nav/ul/li[2]/a")WebElement womenMenu ;
			@FindBy(xpath="//nav/ul/li[2]/ul/li[1]/a")WebElement womenTops ;
			@FindBy(xpath="//nav/ul/li[2]/ul/li[1]/ul/li[3]/a")WebElement womenTees ;
			@FindBy(xpath="//div[@class='filter-options']/div[2]/div")WebElement sizeFilter;
			@FindBy(xpath="//div[@class='filter-options']/div[2]/div[2]/div/div/a[3]/div")WebElement sizeM;
			@FindBy(xpath="//nav/ul/li[2]/ul/li[2]/a")WebElement womenBottoms;
			@FindBy(xpath="//nav/ul/li[2]/ul/li[2]/ul/li/a")WebElement womenPants;
			@FindBy(xpath="//div[@class='block-content filter-content']/div/div[4]/div[1]")WebElement coulourFilter ;
			@FindBy(xpath="//div[@class='block-content filter-content']/div/div[4]/div[2]/div/div/a[3]/div")WebElement grey;	
			@FindBy(xpath="//div[@class='block-content filter-content']/div/div[8]/div[1]")WebElement patterns;	
			@FindBy(xpath="//div[@class='block-content filter-content']/div/div[8]/div[2]/ol/li[1]/a")WebElement coulorBlocked;	
			@FindBy(xpath="//div[@class='block-content filter-content']/div/div[9]/div[1]")WebElement priceFilter ;
			@FindBy(xpath="//div[@class='block-content filter-content']/div/div[9]/div[2]/ol[1]/li[1]/a")WebElement fortydollars;
			@FindBy(xpath="//nav/ul/li[3]/a")WebElement menMenu ;
			@FindBy(xpath="//nav/ul/li[3]/ul/li[1]/a")WebElement menTops ;
			@FindBy(xpath="//nav/ul/li[3]/ul/li[1]/ul/li[1]/a")WebElement menJackets;
			@FindBy(xpath="//main[@id='maincontent']/div[3]/div[1]/div[3]/div[3]/select")WebElement sortBy;
			
			@FindBy(xpath="//div[@class='products wrapper grid products-grid']/ol/li[1]/div[1]/a")WebElement firstTee;
			@FindBy(xpath="//div[@class='products wrapper grid products-grid']/ol/li[1]/div/div/strong/a")WebElement firstTeeName;
			@FindBy(xpath="//form[@id='product_addtocart_form']/div[1]/div/div/div[1]/div/div[4]")WebElement sizeL;
			@FindBy(xpath="//form[@id='product_addtocart_form']/div[1]/div/div/div[2]/div/div[1]")WebElement colorB;;
			@FindBy(xpath="//button[@id='product-addtocart-button']")WebElement addtoCart;
			@FindBy(xpath="//div[@class='page messages']/div/div/div/div")WebElement addedMsg;
			
			@FindBy(xpath="//header[@class='page-header']/div[2]/div[1]/a")WebElement myCart;
			@FindBy(partialLinkText = "View and Edit Cart")WebElement viewCart ;			
			// Declare a string variable
			String productName = "Desiree Fitness Tee";
			@FindBy(xpath="//div[@class='cart table-wrapper']//*[text()='Desiree Fitness Tee']")WebElement checkTee;
			
			@FindBy(xpath="//div[@class='product actions']/div[1]/a")WebElement editCart;
			@FindBy(xpath="//input[@id='qty']")WebElement updateCart;
			@FindBy(xpath="//button[@id='product-updatecart-button']")WebElement updateCartBtn;
			
			@FindBy(xpath="//div[@class='product actions']/div[2]/a")WebElement removeCart;
			@FindBy(xpath="//aside[2]/div[2]/footer/button[2]/span")WebElement removeCartConfirm;
			
			@FindBy(xpath="//div[@class='products wrapper grid products-grid']/ol/li[1]/div/div/div[4]/div/div[2]/a[1]")WebElement addToWishlist;
			
			@FindBy(partialLinkText = "My Wish List")WebElement myWishList ;
			@FindBy(xpath="//form[@class='form-wishlist-items']/div[1]/ol/li/div/strong/a")WebElement checkTeeWishList;
			@FindBy(xpath ="//button[@name='do']")WebElement updateList;
			@FindBy(xpath="//form[@class='form-wishlist-items']/div[1]/ol/li/div/div[3]/div[3]/a[2]")WebElement  removeWish;	
			@FindBy(xpath="//form[@class='form-wishlist-items']/div[1]/ol/li/div/a/span/span/img")WebElement image1;
			
			@FindBy(partialLinkText = "My Account")WebElement myAccount ;
			@FindBy(xpath="//main/div[2]/div[1]/div[5]/div[2]/div[2]/div[2]/a")WebElement myAddress;
			@FindBy(xpath="//input[@id='street_1']")WebElement myStreet;
			@FindBy(xpath="//input[@id='city']")WebElement myCity;
			@FindBy(xpath="//select[@id='region_id']")WebElement myState;
			@FindBy(xpath="//input[@id='zip']")WebElement myZipCode;
			@FindBy(xpath="//input[@id='telephone']")WebElement myContactnum;
			@FindBy(xpath="//button[@class='action save primary']")WebElement saveAddressBtn;

			@FindBy(xpath="//header/div[2]/div[1]/a")WebElement cartForCheckout;
			@FindBy(xpath="//button[@id='top-cart-btn-checkout']")WebElement proccedToCheckout;
			//@FindBy(xpath="//input[@name='ko_unique_1']")WebElement shipMethodBtn;
			@FindBy(xpath="//form[@id='co-shipping-method-form']/div[3]/div/button/span")WebElement nextBtn;
			@FindBy(xpath="//h1[@class='page-title']/span")WebElement thankYouMsg;
			@FindBy(name = "ko_unique_1")WebElement shipMethodBtn2;
			@FindBy(xpath ="//input[@name='billing-address-same-as-shipping']")WebElement chkBoxAddress;
			
			@FindBy(xpath ="//button[@class='action primary checkout']/span")WebElement checkoutBtn;

			@FindBy(xpath="//div[@class='content block-collapsible-nav-content']/ul/li[2]/a")WebElement myOrders;
			@FindBy(xpath="//table[@id='my-orders-table']/tbody/tr[1]/td[6]/a[1]")WebElement myRecentOrders;
			@FindBy(xpath="//table[@id='my-orders-table']/tbody/tr/td[1]/strong")WebElement prodName;
			
			@FindBy(xpath="//div[@class='columns']/div[1]/div[4]/ol/li[1]/div/a")WebElement firstJacket;
			@FindBy(xpath="//div[@class='reviews-actions']/a")WebElement addReviewLink;
			@FindBy(xpath="//label[@id='Rating_1_label']")WebElement oneStars;
			@FindBy(xpath="//input[@id='summary_field']")WebElement reviewSummary;
			@FindBy(xpath="//textarea[@id='review_field']")WebElement reviewDetails;
			@FindBy(xpath="//button[@class='action submit primary']")WebElement submitBtn;
			@FindBy(xpath="//input[@id='search']")WebElement searchBar;
			@FindBy(xpath="//nav/ul/li[6]/a")WebElement saleMenu ;
			@FindBy(xpath="//div[@class='blocks-promo']/a/span/span[2]")WebElement firstSaleItem;
			
		//@FindBy(xpath="")WebElement  ;	
	  
  public void launchBrowser() throws InterruptedException {
		
		dr.manage().window().maximize();
		dr.get("https://magento.softwaretestingboard.com/");
		Thread.sleep (2000);

  }
  
    public void createAccount() throws InterruptedException
  {
    	Thread.sleep (2000);
		createAcc.click();
		Thread.sleep (2000);
		fName.sendKeys("Shey");
		lName.sendKeys("Nz");
		emailAd.sendKeys("sha.nazim@gmail.com");
		pass1.sendKeys("Zaza1234!");
		pass2.sendKeys("Zaza1234!");
		createAccBtn.click();
  }
  
   public void signIn() throws InterruptedException
  {
	  Thread.sleep (2000);
	  signIn.click();
	  System.out.println("Signin  with Valid Credentials ");
	  pass3.sendKeys("Zaza1234!");
	  emailId.sendKeys("sha.nazim@gmail.com");
	  signInBtn.click();
	  Thread.sleep (8000);
	  //Verify if signed in and welcome message is displayed
	  WebElement welcomeMsg =dr.findElement(By.xpath("//header/div[1]/div/ul/li[1]/span"));
	  String actualGreeting=welcomeMsg.getText().substring(0,7);
	  softAssert.assertEquals(actualGreeting,"Welcome" , "Welcome Message not Displayed . SignIn Failed");
	  
  }
   //Data Driven Framework
   public void signInInvalidCred(int rownum) throws IOException, InterruptedException
   {
	   		
		  Thread.sleep (2000);
		  signIn.click();
	
        String filePath="src\\main\\resources\\testdata.xlsx";
		FileInputStream fls=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fls);
		XSSFSheet sheet=workbook.getSheet(workbook.getSheetName(0));
		
			
				int r=rownum;
				XSSFRow row=sheet.getRow(r);
				XSSFCell username=row.getCell(0);
				XSSFCell password=row.getCell(1);
				try {			
					emailId.sendKeys(username.toString());
					pass3.sendKeys(password.toString());
					signInBtn.click();
					Thread.sleep(2000);
					//Verify the Error Message is as expected
			        WebElement errMessage = dr.findElement(By.xpath("//main/div[2]/div[2]/div/div/div"));
			        String Output=errMessage.getText();
					String ExpectedOutput="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
					 softAssert.assertEquals(Output, ExpectedOutput, "Error Not As Expected");
				}
				catch (Exception e)
				{
					System.out.println("Invalid Data Email >>"+username + "Pass "+password +"SignIn Failed");
										
				}

				fls.close();
			
   }
   public void shopWomenTops() throws InterruptedException
   {
	   Actions actions = new Actions(dr);
	   actions.moveToElement(womenMenu).perform();
	   actions.moveToElement(womenTops).perform();
	   Thread.sleep(3000); 
	   womenTees.click();
	   
   }
   
   public void filterTees()
   {
	   sizeFilter.click();
	   sizeM.click();
   }
   

   public void multipleFilters() throws InterruptedException
   {
	   Actions actions = new Actions(dr);
	   actions.moveToElement(womenMenu).perform();
	   actions.moveToElement(womenBottoms).perform();
	   womenPants.click();	
	   Thread.sleep(2000); 
	   coulourFilter.click();
	   grey.click();
	   patterns.click();
	   coulorBlocked.click();
	   priceFilter.click();
	   fortydollars.click();
	   
   }

   public void checkNavs() throws InterruptedException
   {
	  
		Thread.sleep(2000);
		List<WebElement> mynavLinks=dr.findElements(By.xpath("//nav/ul/li/child::a"));
	

				for (int i=0;i<=5;i++)
			{
				WebElement link = mynavLinks.get(i);
				System.out.println(link.getText());
				link.click(); 
				
				Thread.sleep(500);
				mynavLinks = dr.findElements(By.xpath("//nav/ul/li/child::a"));
				}
   }
   public void shopmenJackets() throws InterruptedException
   {
	   Actions actions = new Actions(dr);
	   actions.moveToElement(menMenu).perform();
	   actions.moveToElement(menTops).perform();
	   Thread.sleep(3000); 
	   menJackets.click();
	   
   }
   
   public void shopMenSortJackets() throws InterruptedException
   {
	   Actions actions = new Actions(dr);
	   actions.moveToElement(menMenu).perform();
	   actions.moveToElement(menTops).perform();
	   Thread.sleep(3000); 
	   menJackets.click();
       Select dropdown1 = new Select(sortBy);
       dropdown1.selectByVisibleText("Price");
	   
   }
   
  public void addToCart() throws InterruptedException
  {
	  Actions actions = new Actions(dr);
	   actions.moveToElement(womenMenu).perform();
	   actions.moveToElement(womenTops).perform();
	   womenTees.click();
	   Thread.sleep(3000);
	   firstTee.click();
	   Thread.sleep(3000);
	   	sizeL.click();
	  	colorB.click();
	   Thread.sleep(3000);
	   	addtoCart.click();
	   	Thread.sleep(5000);
		 //verify if the added to cart message has appeared  
	   	try{
	   	String cartUpdateMsg=addedMsg.getText();
	   	String expectedAddMsg="You added ".concat(firstTeeName.getText()).concat(" to your shopping cart.");
	   		assertEquals(expectedAddMsg, cartUpdateMsg, "Assert Failed for Add to Cart Message" );
	   	}
	   	catch(Exception e)
	   	{
	   		System.out.println("Confirmation Message is Delayed/Not Found" );
	   	}
	   
  }
  
  public void checkCart() throws InterruptedException
  {
	  Thread.sleep(3000);
	  myCart.click();
	  viewCart.click();
	  if (checkTee.isDisplayed()) {
          System.out.println("Item is present in the cart.");
	  }else{
          System.out.println("Item is not present in the cart.");
	  }  
  }
  public void updateCart() throws InterruptedException 
  {
	  Thread.sleep(3000);
	  myCart.click();
	  editCart.click();
	  Thread.sleep(2000);
	  updateCart.clear();
	  updateCart.sendKeys("4");
	  updateCartBtn.click();
	  
  }
  
  public void removeCart() throws InterruptedException
  {
	  Thread.sleep(3000);
	  myCart.click();
	  removeCart.click();
	  Thread.sleep(2000);
	  removeCartConfirm.click();
  }
  
  public void addtoWishlist() throws InterruptedException
  {
		  Actions actions = new Actions(dr);
		   actions.moveToElement(womenMenu).perform();
		   actions.moveToElement(womenTops).perform();
		   womenTees.click();
		   Thread.sleep(3000);
		   	sizeL.click();
		  	colorB.click();
		   actions.moveToElement(firstTee).build().perform();
		   Thread.sleep(3000);
		   addToWishlist.click();
		   	Thread.sleep(5000);

  }

   
   public void wishListCheck() throws InterruptedException
   {
	   dropdown.click();
	   myWishList.click();	 
	   Thread.sleep(3000);
	   System.out.println("Item in WishList :"+checkTeeWishList.getText()+" is present");
   }
   
    
   public void removeFromWishList() throws InterruptedException
   {
	   updateList.click();
	   Actions actions = new Actions(dr);
	   actions.moveToElement(image1).build().perform();
	   removeWish.click();	   
   }
   
   public void addAddress() throws InterruptedException
   {
	   dropdown.click();
	   myAccount.click();
	   Thread.sleep(3000);
	   myAddress.click();
	   Thread.sleep(3000);
	   myStreet.clear();
	   myStreet.sendKeys("21 Rey Street , 4 A Road ");
	   myCity.clear();
	   myCity.sendKeys("ABS City");
	   Select dropdown2=new Select(myState);
	   dropdown2.selectByVisibleText("Idaho");
	   myContactnum.clear();
	   myContactnum.sendKeys("123456");
	   myZipCode.clear();
	   myZipCode.sendKeys("3457");
	   saveAddressBtn.click();
	   
   }
   public void checkout() throws InterruptedException
   {
	   Thread.sleep(3000);
	   cartForCheckout.click();
	   proccedToCheckout.click();
	   Thread.sleep(6000);
	   shipMethodBtn2.click();
	   nextBtn.click(); 
	   System.out.println("Clicked Next"); 
	   Thread.sleep(6000);
	   chkBoxAddress.click();
	   chkBoxAddress.click();
	   //Duration timeoutVal=Duration.ofSeconds(10);
	  // WebDriverWait wait = new WebDriverWait(dr, timeoutVal);
	   //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='action primary checkout']/span")));
	   checkoutBtn.click();
	   System.out.println("Clicked checkout"); 
	   Thread.sleep(5000);
	   try{
		   	String thankMessage=thankYouMsg.getText();
		   	String expectedThankMsg="Thank you for your purchase!";
		   		assertEquals(expectedThankMsg, thankMessage, "Assert Failed for Add to Cart Message" );
		   	}
		   	catch(Exception e)
		   	{
		   		System.out.println("Confirmation Message is Delayed/Not Found" );
		   	}	   
	   
   }
   
   
   public void checkOrders() throws InterruptedException
   {
		   dropdown.click();
		   myAccount.click();Thread.sleep(2000);
		   myOrders.click();Thread.sleep(2000);
		   JavascriptExecutor js = (JavascriptExecutor) dr; 
		   js.executeScript("window.scrollBy(40,900)");
		   myRecentOrders.click();Thread.sleep(2000);
		   System.out.println(productName.equals(prodName.getText()));
	   
   }
   
   public void navigationCheck() throws InterruptedException
   {
		Thread.sleep(1000);
		dr.navigate().to("https://magento.softwaretestingboard.com/sale.html");
		Thread.sleep(1000);
		dr.navigate().back();Thread.sleep(1000);
		dr.navigate().forward();Thread.sleep(1000);
		dr.navigate().refresh();Thread.sleep(1000);
   }
   
   
   public void addReview() throws InterruptedException
   {
	   shopmenJackets();Thread.sleep(2000);
	   firstJacket.click();Thread.sleep(2000);
	   addReviewLink.click();Thread.sleep(2000);
	   Actions actions = new Actions(dr);
	   actions.moveToElement(oneStars).perform();
	   oneStars.click();
	   reviewSummary.sendKeys("Not Good");
	   reviewDetails.sendKeys("Material Quality not good");
	   submitBtn.click();     
	   
   }
   
   public void searchBox()
   {
	   searchBar.click();
	   searchBar.sendKeys("Fusion Backpack");
		Actions actobj=new Actions(dr);
		actobj.sendKeys(Keys.ENTER);
		actobj.build().perform();
   }
   
   public void screenshotItem() throws InterruptedException, IOException
   {
	   saleMenu.click();Thread.sleep(2000);
	   
	   firstSaleItem.click();	   //click first element
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)dr;
		File src=ts.getScreenshotAs(OutputType.FILE);
				//ts.getScreenshotAs(OutputType.FILE);
		File tgt=new File("test-output\\ScreenShots\\Selenium_Screensw.png");
		FileHandler.copy(src, tgt);
		
		Thread.sleep(2000);
	   //take screenshot
   }
   
   
   
   public void signOut()
   {
	   dropdown.click();
	   signOutBtn.click();	   
   }
   

}
