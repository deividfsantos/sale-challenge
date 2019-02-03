# sale-challenge

### Analyze Sales data and generate reports

This project goal is read data from the default directory, located at **HOME_PATH/data/in**. It just read **.dat** files and process all files inside the input default directory, generate metrics and create a flat file  with the name **FLAT_FILE_NAME.done.dat** inside the default output directory, located at **HOME_PATH/data/out**.

The input file has the following pattern:
- **Salesman data**<br>
001çCPFçNameçSalary
- **Customer data**<br>
002çCNPJçNameçBusiness Area
- **Sale data**<br>
003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

#### Test
`./graldew clean test`

#### Build
`./graldew clean build`

#### Run
`java -jar PROJECT_PATH/build/libs/sale-challenge-1.0.jar`

#### Technologies
- **Java 8**: To write the code.
- **JUnit 4.12**: To implement tests.
- **Gradle 3.5**: To automate the build.
