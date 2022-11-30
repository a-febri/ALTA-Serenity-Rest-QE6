<br />
<div align="center">
  <a href="https://github.com/a-febri/alta-API-automation-todoist">
    <img src="https://avatars0.githubusercontent.com/u/19369327?s=400&v=4" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">It is individual project to test API both manual and automation with rest assured on reqres.in</h3>
</div>

## Sample of test
```gherkin
Scenario: Get list resource valid path
Given Get list resource with valid path "unknown"
When Send request to get list resource
Then Should return 200 OK
And Response body page should be page 1 and total pages are 2
And Get list resource json schema validator
   ```

## How to Run
1. Clone this repository using this command
   ```sh
   git clone https://github.com/a-febri/ALTA-Serenity-Rest-QE6.git 
   ```
2. Change directory to project directory
   ```sh
   cd ALTA-Serenity-Rest-QE6
   ```
3. Run using this command below
   ```sh
   mvn clean verify
   ```

## Report
![api reqres](https://user-images.githubusercontent.com/109534135/204684923-74bf75e1-d947-4901-bea3-680b1835945d.JPG)


## Language and Tools
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![IntellijIDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Rest Assured](https://img.shields.io/badge/-rest%20assured-000000?style=for-the-badge&logoColor=black)
![Serenity BDD](https://img.shields.io/badge/-serenit%20ybdd-16a67a?style=for-the-badge&logoColor=black)
![Cucumber](https://img.shields.io/badge/-cucumber-4bc47b?style=for-the-badge&logoColor=black)

### Contact 
<p>
    <a href="https://www.linkedin.com/in/a-febri/" target="blank"><img src="https://img.shields.io/badge/-linkedin-181717?style=for-the-badge&logo=linkedin" /></a>
    <a href="mailto: arifebri12@gmail.com" target="blank"><img src="https://img.shields.io/badge/-gmail-181717?style=for-the-badge&logo=gmail" /></a>
<p>
