The Page Object Model (POM) is a design pattern in software automation testing, particularly beneficial in enhancing test maintenance and reducing code duplication. It serves as an abstraction layer for web pages in web application testing.

### Key Concepts of POM:

1. **Page Abstraction**: Each page in the application is represented as a class. These classes encapsulate the page's elements and behaviors, separating the page structure from the test scripts.

2. **Element Encapsulation**: Elements of the web page (like text boxes, buttons, etc.) are defined as variables in the page class. This approach allows changes to the page structure to be made in a single location rather than in every test script.

3. **Methods for Interaction**: Page classes provide methods to interact with the page elements. These methods act as an interface to the page, further decoupling the page details from the tests.

4. **Maintenance Efficiency**: Since the page structure and the test scripts are decoupled, any changes in the page layout will only require updates in the page class. This reduces the maintenance effort significantly.

5. **Readability and Reusability**: POM enhances test script readability and reusability. It allows for writing more concise and readable test scripts, as the complexity of interactions with page elements is hidden in the page classes.

### Advantages of POM:

- **Improved Test Maintenance**: Easier to maintain and update tests due to the separation of page-specific code and test logic.
- **Reusability of Code**: Common web page elements and behaviors are reused across different tests.
- **Increased Readability**: Tests become more readable and understandable, as the technical details are abstracted away.
- **Reduced Code Duplication**: Centralizes common web page interactions, reducing the duplication of code.

### Tools Used:
1. **Selenium**
2. **TestNG**
3. **Rest Assured**
4. **Allure reporting**
   

