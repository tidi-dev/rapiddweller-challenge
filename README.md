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

<h3>2. Trigger API</h3>

Endpoint: `localhost:8080/api/translator`

Method: POST

Body
```
{
    "text": "good morning",
    "targetLanguage": "de"
}
```
