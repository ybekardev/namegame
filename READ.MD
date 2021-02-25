#Willow Tree - Name Game

##How To Use?

The project is on the MASTER branch NOT on the main branch! 
Please switch to the master branch to see the code along the framework.
####For extra details follow this Read.MD file and folder src/main/resources/defect

##Tools Used / Tool Set

* Java
* Cucumber
* JUnit
* Selenium WebDriver
* Spring Boot Application Layer and Framework

...with some other additional dependencies which are generic and to be used along the project, such as Hamcrest Matchers, Json marshall / unmarshall libraries, 

##Design & Architecture
Inside the project, we target to load the namegame webpage and throught the UI interactions perform the required actions which are indicated for LOB purposes.
Within Java OOP concepts, initializing a PageObject to call the objects, methods and drivers for the specified UI actions.
Framework utilizes Spring Boot Application Structure, Cucumber BDD, Gherkin Language, JUnit reporting, and some other util methods to help us.

#Test Strategy
As the project is being short, non-dynamic and strict scenarios, I will focus in this with narrower spectrum.

####Scope of Testing
What features and functionality would you consider to be in or out of scope to be tested?
 
 The ones to be in:
  If the user can
    -see the pictures, 
    -click on the images, 
    -see the text & color change after each click, 
    -passing to the next page after the correct streak, 
    -able to see the counting on the bottom of the page,
  and so forth.
  
  The ones to be out of the scope: 
    -Could person have a better profile picture, Unifying and Listing the employees' background color of their head-shot. 
 
####Risk Analysis
Risks to the projects such as:
 ● What information/data will you need to test?
 The project LOB mostly focuses on the STREAK numbers, correct tries while clicking the correct image for the provided employee name in the header of the webpage.
     -Counter after each click,
     -Counter after each correct click
     -Counter after each incorrect click,
     -Counter after moving to another page.
 ● Are there any dependencies?
     -LinkedIn employee list feed with the information details provided to the application, this needs to be maintained properly and in time manner.
 ● Anything else you can think of?
     -Once someone else links himself/herself to WillowTree so the person will pop-up on the employee list and this will change the results
 
####Testing Objectives
 What are the testing goals or objectives? 
    User is able to click on the images and find the correct one while watching over the streak/count numbers and being able to move to the next page
 
 How do we know they’ve been achieved? 
     As the project is being a UI version, it is obvious we can observe the actions either user or autonomous takes. 
     In user case, we can come up with positive and negative scenarios to do the validations.
     For Automated project, we can use loggers or reporting tools to observe what is happening within/during/after this interaction.
     
 How could test automation contribute to the overall test strategy?
     Imagine the scenario involves in providing the report for the test scenarios you are performing for all 531 employees of Willow Tree.
     You have to do the 'clicks' for all cases and provide the image name + the web page header name. This has to be done manually.
     Besides, once in a month or so a new employee joins, and you have to either regression or smoke test of this testing set. 
     If there is something done over and over again while it takes a good amount of time, then I would think of AUTOMATION. 
     
####Defects
Create a defect report, with all relevant information, based on any issues discovered while testing. 
For this section, we’d like to see breadth and depth, writing a few defects with all details available followed by a list of all defects found (with minimal detail would be fine).

DEFECT - Employee picture is not visible
Details: If the user can't see the employee's face on the provided image then guessing may fail and this is a reasonable defect.
Attachment: Please see the file: src/main/resources/defect/defect1.png
Testing Date: 02/25/2021

DEFECT - Employee picture ame is not matching with the criteria
Details: Employee uses incorrect name format while uploading their images. The correct format should be (firstName + _ + lastName).png/.jpeg
Also, Once I tried automation on this to see if the employee header is also matching with the <img src="""> provided image link I saw this is not possible since many of different versions are used on picture names.
Attachment: Please see the file: src/main/resources/defect/defect2.png
Testing Date: 02/25/2021

####Test Automation
● Verified the indicated scenarios in one method since they are very related to each other.
  While the application is not being dynamic and criteria are not providing solid testing standards, I tried to accomplish the scenarios 
  in the best version with less care in DRY principle of the coding or improving the scenario health.
  
  While performing all these, I considered creating the framework, use the language properly, design better, and cover the wanted scenarios as a whole piece.
  I would do a better approach if I had more than 8 hours of validation on these test cases. But this is good amount to perform the skills, I guess.
  Please find the test automation cases here: src/main/java/spring/pages/LoginPage.java

    public void countingStrikes(){
        BrowserUtil.waitPlease(8);

        List<WebElement> webElementList = new ArrayList<>();
        webElementList.add(firstPicture);
        webElementList.add(secondPicture);
        webElementList.add(thirdPicture);
        webElementList.add(fourthPicture);
        webElementList.add(fifthPicture);

        int streakCounter = 0;
        while(true)
        for(WebElement wel : webElementList){

            wel.click();
            BrowserUtil.waitPlease(3);

            // Then Verify the streak counter is incrementing on correct selections
            if(streak.getText().equals("1")){
                streakCounter++;
                System.out.println("Streak trial number: " + streak.getText());
                System.out.println("SUCCESS, Streak is incremented by: " + streak.getText());

                // Verify name and displayed photos change after selecting the correct answer
                System.out.println("The displayed photo is changed after clicking from photo to: " + photoName.getAttribute("class"));
                assert (photoName.getAttribute("class").equals("photo correct"));

                //Verify that the correct counters are being incremented for tries and correct counters
                assert (valueOf(streakCounter).equals(correct.getText()));
                System.out.println("Correct number of trials: " + correct.getText());
                continue;
            }

            System.out.println("Streak trial number: " + streak.getText());
            String vl = streak.getText();

            // Verify the multiple “streak” counter resets after getting an incorrect answer
            assert (vl.equals("0"));

        }
    }
    
###Appreciating for the opportunity you provided.