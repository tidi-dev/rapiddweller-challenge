# Welcome to # Kotlin / Java Code Interpreter and Translator Challenge!
[Description](https://challenge-fst-240103878.rapiddweller.com/)
Hey there and a wonderful good day!

Thanks so much for applying to our recent position and your interest to become part of our dwellerTeam. We like to move further with your application.

We are seeking an  **enthusiastic**  and  **self-motivated developer**. You will be working on our  **modern technology stack**  and in an  **international environment**  that promotes collaboration within/across teams and managing both internal/external stakeholders.

We like to understand if working together in the future will be a good fit for you and us. As we are seeking a dweller who will be able to cope with our stack, and feel comfortable with our technical setup and upcoming challenges, we have prepared the following coding challenge for you.

## What included

 - [x] Kotlin 1.9.21
 - [x] Spring boot 3.2.1
 - [x] JDK 21
 - [x] Google cloud translate 2.33.0
 - [x] kotlin-scripting-jsr223 1.9.21
 - [x] Docker

 # STRUCTURE
## Back-End 
Path: `/rapiddweller/src/main/kotlin/daiho/codechallenge/rapiddweller`
```
├── RapiddwellerApplication.kt
├── config
│   ├── EnvConfig.kt
│   └── WebConfig.kt
├── controller
│   ├── IndexController.kt
│   ├── InterpreterController.kt
│   └── TranslatorController.kt
├── dto
│   ├── InterpreterRequestDto.kt
│   └── TranslatorRequestDto.kt
└── service
    ├── InterpreterService.kt
    └── TranslatorService.kt

5 directories, 10 files
```
* `config`: to organize configuration-related files or classes in a more structured manner (*Environment-specific Configurations*, *Third-Party Configuration Files*)
* `controller`: contains classes that define the application's endpoints, play a crucial role in handling web requests, processing data, and coordinating the flow of the application.
* `dto`: is used to encapsulate data that needs to be transferred between different layers of an application, typically between the presentation layer and the service layer
* `service`: is often used to organize classes that implement business logic and services and responsible for handling business logic, coordinating tasks, and interacting with data access (repository) layers

## Front-End 
Path: `/rapiddweller/src/main/resources`
```
├── static
│   ├── interpreter.html
│   └── translator.html
└── templates
    └── index.html

3 directories, 4 files
```
* `static`: is often used to store static resources that are served directly to clients, such as web browsers, without being processed by the server-side application logic.
* `templates`: is often used to store templates for dynamic content generation, primarily for server-side rendering of views.
# SETUP

Some comprehensive guidelines and necessary details to create the foundational infrastructure essential for subsequent processes.

## I. Replace env variable
> Ping me to get Google Translate API Key

* Run command `cp .env.local .env` to generate .env file
* Replace `API_KEY` with the given key

## II. Setup Docker

For the seamless installation and testing of software, it is advisable to establish a Docker environment.

* Execute this command `docker build -t rapiddweller .` to build image
* Execute this command `docker run -p 8080:8080 rapiddweller` to start docker

> The process may require some time due to the installation of dependencies and libraries.

## III. Import API Json
To expedite the setup for API testing in Postman, kindly import the file named "postman_api_collection.json."

# TESTING
This involves both UI testing and API testing methodologies. 
Right click on `src/main/resources/templates/index.html` to open home page

<img width="825" alt="image" src="https://github.com/tidi-dev/rapiddweller-challenge/assets/75537580/361479ce-1102-4044-8b5b-1ed1379c6ca0">

## Translator Testing
> A function for translating text between English and German

<h3>UI Testing</h3>

From the home page:
* choose `EN-DE Translator`
* input some text for German translating

<img width="522" alt="image" src="https://github.com/tidi-dev/rapiddweller-challenge/assets/75537580/fec2c2f1-c23d-41df-b14e-0a53f94927d5">

<h3>API Testing</h3>

```
> API: POST localhost:8080/api/translator
> Body
{
	"text": "good morning",
	"targetLanguage": "de"
}
```
<img width="551" alt="image" src="https://github.com/tidi-dev/rapiddweller-challenge/assets/75537580/361020c1-829e-469b-acf6-93bd2d99f84d">


## Interpreter Testing

> A backend service for interpreting code snippets within a predefined context. 

<h3>UI Testing</h3>

From the home page:
* choose `Code Interpreter`
* input some kotlin code

<img width="457" alt="image" src="https://github.com/tidi-dev/rapiddweller-challenge/assets/75537580/3aed6f73-66b9-42f5-9da0-79da10291c13">


<h3>API Testing</h3>

```
> API: POST localhost:8080/api/interpreter
> Body
{
	"input": "val x = 2 + 2"
}
```
<img width="584" alt="image" src="https://github.com/tidi-dev/rapiddweller-challenge/assets/75537580/19d2e55a-02d2-48e1-9c67-2090f99dc1f6">
