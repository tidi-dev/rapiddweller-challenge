# rapiddweller-challenge

<h2>I. Setup Docker</h2>
  
- Execute this command `docker build -t rapiddweller .` to build image
- Execute this command `docker run -p 8080:8080 rapiddweller` to start docker

<h2>II. Text Translation</h2>

Note: *Checkout to branch `feat/translator_api`*
<h3>1. Replace API key</h3>

In file `src/main/kotlin/daiho/codechallenge/rapiddweller/service/TranslatorService.kt`, replace api key
```
    private val translate: Translate = TranslateOptions.newBuilder()
        .setApiKey("PING_ME_TO_GET_API_KEY")
        .build()
```

<h3>2. Test with API</h3>

Endpoint: `localhost:8080/api/translator`

Method: POST

Body
```
{
    "text": "good morning",
    "targetLanguage": "de"
}
```

<h3>3. Test with UI</h3>

- Right click on `src/main/resources/templates/index.html` to open home page
<img width="825" alt="image" src="https://github.com/tidi-dev/rapiddweller-challenge/assets/75537580/361479ce-1102-4044-8b5b-1ed1379c6ca0">

- Choose `EN-DE Translator`
<img width="522" alt="image" src="https://github.com/tidi-dev/rapiddweller-challenge/assets/75537580/fec2c2f1-c23d-41df-b14e-0a53f94927d5">

