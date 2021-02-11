ScopeAI Java SDK
======================

A simple client for the ScopeMedia API _ScopeAI_

* Try the ScopeAI demo at:
* Sign up for a free account at: https://console.scopemedia.com/#/signup
* Read the documentation at: https://docs.scopemedia.com/

Installation
------------
* Clone or download this repository
* Run `gradlew install` on windows or `gradle install` on macOS or unix

### Gradle:

Add the following to the dependencies section of your `build.gradle`:

```groovy
// Add the client to your dependencies:
dependencies {
    compile 'com.scopemedia.api:java-sdk:3.0.0'
}

// Make sure you have the Maven Local Repository in your Gradle File
repositories {
    mavenLocal()
}
```

### Maven:

Add the following to your dependencies:

```xml
<dependency>
  <groupId>com.scopemedia.api</groupId>
  <artifactId>java-sdk</artifactId>
  <version>3.0.0</version>
</dependency>
```

Getting Started
---------------
Get your Client ID and Client Secret [here](https://console.scopemedia.com/#/)

To create a `ScopeAIClient` instance with an ID and secret do the following:

```java
ScopeAIClient client = new ScopeAIBuilder(CLIENT_ID, CLIENT_SECRET).build();
```

You can also enable the debug and set an debug level based on OkHttp3

```java
ScopeAIClient client = new ScopeAIBuilder(CLIENT_ID, CLIENT_SECRET)
                .setDebugMode(true)
                .setDebugLevel(HttpLoggingInterceptor.Level.BODY)
                .build();
```

Perform request
-------------------
Network operations using the API client only occur by calling `.performSync()` or `.performAsync(...)` on a
`ScopeAICallback<T>` object.

### Example for a prediction
#### Async
```java
PredictionRequest request = new PredictionRequest();
request.setMediaUrl(imageUrl);
request.setModelId("general-v3");

client.getPrediction(request).performAsync(new ScopeAICallback<PredictionResponse>() {
    @Override
    public void onScopeResponse(PredictionResponse response) {
        Tag[] tags = response.getTags();
        for (Tag tag : tags)
            System.out.println(tag.getTag() + ":" + tag.getScore());
    }

    @Override
    public void onScopeFailure(Throwable throwable) {

    }
});
```

#### Sync
```java
PredictionRequest request = new PredictionRequest();
request.setMediaUrl(imageUrl);
request.setModelId("general-v3");

try {
    PredictionResponse response = client.getPrediction(request).performSync();
    Tag[] tags = response.getTags();
    for (Tag tag : tags)
        System.out.println(tag.getTag() + ":" + tag.getScore());
} catch (IOException e) {
    e.printStackTrace();
}
```