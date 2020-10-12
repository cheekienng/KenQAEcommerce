# **QA Automation Engineer – E-Commerce**

This project search the product named [iPhone] in both [https://eBay.com.my](https://eBay.com.my/) and [https://www.Lazada.com.my](https://www.Lazada.com.my/). Results collected from both platforms and sorted by price in ascending order. Eventually, the list of sorted products will be displayed in product.html file stored in the application directory.

-----------------------------------------


**Built With**


IntelliJ
 OpenJDK-15
 Maven


[Dependencies]

 jar\_files.zip
 
 org.apache.commons.io
 
 slf4j-jdk14-2.0.0-alpha1.jar
 
 slf4j-api-2.0.0-alpha1.jar
 
 webdrivermanager-3.8.1.jar
 
 selenium-java-3.141.59.zip

-----------------------------------------


**Modules**

This project consists of:

**[KenQAEcommerce-framework]**
 BasedPage class inherited by Page Objects module for initializing and setting driver information.

**[KenQAEcommerce-page-objects]**
 ProductListingPage is the main page to run and see the list of sorted results.

**[KenQAEcommerce-regression-tests]**
Created to place all the regression test cases. The module is blank for now.

**[KenQAEcommerce-report]**
Pass in the array list and this module will generate report to be displayed in product.html

**[KenQAEcommerce-model-class]**
ProductModelClass used to define all the properties of [Product]. Used in both Page Object module and Report module.

-----------------------------------------


**Running the tests**

1. Use IntelliJ to open the main project folder [KenQAEcommerce]
2. Run page [ProductListingPage.java] in [KenQAEcommerce-page-objects] module
3. Chrome browser will launch and run the automated test. Eventually [product.html] will be displayed.

-----------------------------------------


**Authors**


- Ken Ng
