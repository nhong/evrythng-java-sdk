# EVRYTHNG Java SDK

A set of wrappers and tools to facilitate working with the EVRYTHNG APIs.

## EVRYTHNG API Java / Android Wrapper & Tools

This the repository of Java tools for the EVRYTHNG API, it includes two modules:

* The Java wrapper for the [EVRYTHNG API](https://api.evrythng.com). It lets you use all the features provided by our API with pure Java constructs. 
You need an API token for authentication which you can get on [https://dev.evrythng.com/]. Note that the wrapper also works on Android / Dalvik.

* The resource models used to map the server responses to POJOs (the wrapper uses these!).

### Getting Started

#### Setup
The easiest way is to get the latest `.jar` with packaged dependencies from [here](https://s3.amazonaws.com/evrythng-public/evrythng-java-wrapper-1.8.0-jar-with-dependencies.jar) and adding it to your Java project.

The project is also available in our maven repository:

    <dependency>
     <groupId>com.evrythng</groupId>
     <artifactId>evrythng-java-wrapper</artifactId>
     <version>1.8.0</version>
    </dependency>

the repository:

    <repository>
      <id>evrythng-public-releases</id>
      <name>EVRYTHNG Public Releases</name>
      <url>https://internal.evrythng.net/nexus/content/repositories/evrythng-public-releases</url>
    </repository>

#### Hello world!

Then you should look at the [examples](https://github.com/evrythng/evrythng-java-wrapper/tree/master/src/main/java/com/evrythng/java/wrapper/examples) or, if you are impatient, get started with the snippet below:

    import com.evrythng.java.wrapper.ApiConfiguration;
    import com.evrythng.java.wrapper.ApiManager;
    import com.evrythng.java.wrapper.exception.EvrythngClientException;
    import com.evrythng.java.wrapper.exception.EvrythngException;
    import com.evrythng.java.wrapper.service.ThngService;
    import com.evrythng.thng.resource.model.store.Thng;
    import java.util.ArrayList;
    import java.util.List;

    public class EVRYTHNGWrapperTests {

    public static void main(String[] args) throws EvrythngClientException, EvrythngException {
        ApiManager api = new ApiManager("YOUR_EVRYTHNG_API_KEY");
        ThngService thngService = api.thngService();

        // Create a thng
        Thng myThng = new Thng();
        myThng.setName("My hiking watch");
        myThng.setDescription("This is the watch I use for hiking.");
        myThng.addCustomFields("color", "blue");
        // do create!
        myThng = thngService.thngCreator(myThng).execute();
    
        // Add a temporal property
        List<Property> props = new ArrayList<Property>();
        props.add(new Property("temperature", "22"));
        props.add(new Property("altitude", "4500"));
        // do add!
        props = thngService.propertiesCreator(myThng.getId(), props).execute();
    
        // And get the thng + properties back
        myThng = thngService.thngReader(myThng.getId()).execute();
        System.out.println(myThng.getProperties());
      }
    }

See [examples](https://github.com/evrythng/evrythng-java-sdk/tree/master/evrythng-java-wrapper/src/main/java/com/evrythng/java/wrapper/examples) for a complete overview of the functionality.

### Working with the wrapper for Android projects

You can also use the wrapper for your Android applications as it compiles on the Dalvik virtual machine! To get started get the latest `.jar` with packaged dependencies from [here](https://s3.amazonaws.com/evrythng-public/evrythng-java-wrapper-1.8.0-jar-with-dependencies.jar) and adding it to your Android project's libraries. Make sure that the wrapper library is exported to your final Android application.

To get you started with Android and EVRYTHNG have a look at the [FreezeMe](https://github.com/webofthings/FreezeMe) sample app. It is a freezer management application using QR codes, NFC tags and the EVRYTHNG API.

### Extending the wrapper

#### Cloning the repository

  git clone git@github.com:evrythng/evrythng-java-sdk.git

#### Compiling the wrapper and resource models

    mvn clean install

You should now find a `.jar` file in the `target/` directory.

To build the `.jar` with all dependencies run:

    cd evrythng-java-wrapper/
    mvn assembly:single

#### Using the wrapper in your project

To use the wrapper, just add the generated `.jar` file located in the `target/` directory to your Java project.


## License

 Copyright EVRYTHNG Ltd London / Zurich

   The EVRYTHNG API wrapper is licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

