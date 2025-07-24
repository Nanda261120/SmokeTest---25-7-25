package Com.ACC.selenium.Interface;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import Com.ACC.selenium.BASE.Locatername;

public interface Interface {
	
	/**
	 * This method will launch the browser with given URL.
	 * @author nandakumar.r
	 * @param URL
	 * @exception NullPointerException, MalformedURLException, URISyntaxException, IOException
	 */
	public void setup(String URL);

	/**
	 * This method will launch the given URl with the given browser.
	 * @author nandakumar.r
	 * @param URL		
	 * @param browsername
	 * @return 
	 */
	public RemoteWebDriver setup(String browser,String URL);

	/**
	 * This action will close the active browser and leave the remaining windows or tabs open.
	 * @author nandakumar.r
	 */
	public void close();

	/**
	 * This action will close the entire browsers 
	 * @author nandakumar.r
	 */
	public void quit();

	/**
	 * This method is used to find a webelement in the page.
	 * @author nandakumar.r
	 * @param type
	 * @param value
	 * @return
	 */
	WebElement element(Locatername type, String value);

	/**
	 * This method is user to wait until the element is visiable and clear the existing value and TYPE.
	 * @author nandakumar.r
	 * @param value
	 */
	public void type (WebElement ele, String testdata);

	/**
	 * This method is used to wait until the element is visiable and gets the input.
	 * @author nandakumar.r
	 * @param value
	 */
	public void appendText (WebElement ele, String testdata);

	/**
	 * This menthod is user to wait until the element is enable and then click.
	 * @author nandakumar.r
	 * @param value
	 */
	public void click (WebElement ele);

	/**
	 * This method is user to wait until the element is visiable and then clear.
	 * @author nandakumar.r
	 * @param value
	 */
	public void Clear (WebElement ele);

	/**
	 * This method is user to switch to specfic tab
	 * @author nandakumar.r
	 * @param i
	 */
	public void switchtoWindow (int i);

	/**
	 * This method is used to switch to a frame within the DOM.
	 * @author nandakumar.r
	 * @param i
	 */
	public void switchtoframe (int i);

	/**
	 * This method is user to select the dropdown value using given value. 
	 * @author nandakumar.r
	 * @param ele
	 * @param value
	 */
	public void selectvalue(WebElement ele, String value);


	/**
	 * This method is user to select the dropdown value using given text. 
	 * @author nandakumar.r
	 * @param ele
	 * @param value
	 */
	public void selectText (WebElement ele, String text);


	/**
	 * This method is user to select the dropdown value using given index. 
	 * @author nandakumar.r
	 * @param ele
	 * @param value
	 */
	public void selectindex (WebElement ele, int position);

	/**	
	 * This function return the active page title
	 * @author nandakumar.r
	 * @return String
	 */

	String getTitle();

	/**	
	 * This function return the active page URL
	 * @author nandakumar.r
	 * @return String
	 */

	String getURL();

	/**	
	 * This function return the element is displayed or not
	 * @author nandakumar.r
	 * @return boolean
	 */

	boolean isDisplayed(WebElement ele);

	/**	
	 * This function return the element is selected or not
	 * @author nandakumar.r
	 * @return boolean
	 */
	boolean isSelected (WebElement ele);

	/**	
	 * This function return the element is enabled or not
	 * @author nandakumar.r
	 * @return boolean
	 */
	boolean isEnabled (WebElement ele);

/**
 * This fuction will load the property in the properties file.
 * @author nandakumar.r
 * @param value
 */
	void loadobject() ;
	
	String getTextFromApp(WebElement ele) ;
	
	
	 /**
	  * This function will clear and type the given text.
	  * @param ele
	  * @param Data
	  * @return
	  */
    void ClearAndType(WebElement ele, String Data);
    
    /**
     *  This function will clear and type the given numbers.
     * @param ele
     * @param Data
     */
    void intClearAndType (WebElement ele, int Data);
    
    /**
     * This function is used to click the current date 
     * @author nandakumar.r
     * @param ele
     */
    void CurrentdatePicker(WebElement ele);
    
    /**
     * This function is used to click the plus one year of current date 
     * @param ele
     */
    void PlusOneyeardatepicker(WebElement ele, int Year);
    
    /**
     * This method is user to select the drop down values using text.
     * @author nandakumar.r
     * @param ele
     * @param text
     */
    
    void selectDropdownUsingText(WebElement ele, String text);
    
    /**
     * This method is user to select the drop down values using value.
     * @author nandakumar.r
     * @param ele
     * @param value
     */
    void selectDropdownUsingvalue(WebElement ele, String value);
    
    /**
     * This method is user to select the drop down values using index.
     * @author nandakumar.r
     * @param ele
     * @param index
     */
    void selectDropdownUsingindex(WebElement ele, int index);
    
    /**
     * This method is used to scroll to the element 
     * @param ele
     */
    void scrollToElement (String xpath);
    /**
     * This method used to click on the dom using mouse.
     * @param xpath
     */
    
    void clickUsingMouse( WebElement ele);
    
    /**
     * This method used to double click on the element
     * @param ele
     */
    void doubleClickUsingMouse (WebElement ele);
    /**
     * This method is used to get the string, which is added by manually 
     * 
     * @author nandakumar.r
     * @param ele
     * @param data
     * @return
     */
    
    String getEntredTEXT( WebElement ele, String data);
    
    
    /**
     * This method is used to get the string, which is added by manually 
     * 
     * @author nandakumar.r
     *@param ele
     *@param ModuleName
     * @return
     */
    String asserts(WebElement ele, String ModuleName);
    
    /**
     * This method is used to get the string, which is added by manually 
     * 
     * @author nandakumar.r
     *@param ele
     * @return
     */
    void ScrolldownAndUp( WebElement ele);
    
 
     /**
      * This method is used to verify the entry in database, which is created in Application
      * @author nandakumar.r
      * @param Collection
      * @param key
      * @param VerifyDAta
      * @return
      */
    
Boolean DbAssert(String Collection, String key , int VerifyDAta );
    
}
