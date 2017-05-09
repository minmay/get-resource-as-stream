# get-resource-as-stream appliation

This application was written to isolate a getResourceAsStream call from a jruby on rails application that loads a jar, and then a class, which 
attempts to load an internal resource from a jar file.

**It works just fine in isolation!!!**

Unfortunately, in my more complex rails application it fails. I need to discover why.

## To Run 

1. ```./gradlew build```
2. ```gem install rails -v 4.2.5```
3. ```cd rails-app-with-jar-with-get-resource-as-stream```
4. ```bundle install```
5. ```rake test:resource_with_stream```

## Developer Notes

The java application jar has a single class **mvillalobos.jruby.bugs.get.resource.as.stream.io.DataConfiguration**
which loads a YAML file with a getStreamAsResource call.

Gradle will build the application and copy its dependencies and application jar into the **rails-app-with-jar-with-get-resource-as-stream/lib/java/dependencies** directory.

**rails-app-with-jar-with-get-resource-as-stream/config/application.rb** was modified to load the jar files (so it is mandatory to run ./gradlew build first).

**rails-app-with-jar-with-get-resource-as-stream/lib/tasks/resource_with_stream.rake** will require the proper java class that gets a resource as stream.

 