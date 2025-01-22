Demo Recording : https://drive.google.com/file/d/1FGC_52FLWNJm-LxXXirBLMcBK_ja3Q2t/view?usp=sharing
# Google Form Automation

## Overview
This project automates the process of filling out a Google Form using Selenium in Java with TestNG and Gradle.

## Project Requirements
- **Programming Language:** Java
- **Testing Framework:** TestNG
- **Build Tool:** Gradle
- **Automation Tool:** Selenium WebDriver

## Activity Breakdown

### Steps to Automate
1. **Navigate to the Google Form**  
   - Open the provided Google Form link.

2. **Fill Text Fields**  
   - Enter `Crio Learner` in the first text box.
   - Write down `I want to be the best QA Engineer! 1710572021`, where `1710572021` is dynamically generated using the current epoch time.

3. **Select Radio Button**  
   - Choose the option for Automation Testing experience.

4. **Select Checkboxes**  
   - Check `Java`, `Selenium`, and `TestNG` options.

5. **Select Dropdown Value**  
   - Choose the preferred way to be addressed.

6. **Provide Date Field**  
   - Enter the date as the current date minus 7 days (calculated dynamically).

7. **Enter Time Field**  
   - Set the time to `07:30` (either AM/PM or 24-hour format).

8. **Submit the Form**  
   - Click the submit button and confirm form submission.
   - Print the success message displayed on the website to the console.
   - 

## Setup and Execution

### Prerequisites
Ensure the following are installed on your system:
- Java (JDK 8 or above)
- Gradle
- Chrome WebDriver (matching your browser version)

### Running the Tests
1. Clone the repository:
   
   git clone <repository-url>
   cd google-form-automation

2. Build the project with Gradle:
   
   gradle build
  
3. Execute the test case:
  
   gradle test
  
