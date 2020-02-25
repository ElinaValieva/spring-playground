# :chart_with_downwards_trend: Custom Actuator metrics

### Prerequisites :heavy_exclamation_mark:

 1. `JDK 1.8` at least - for running the app
 2. `Maven 3+` - for building package

### Creation custom end-point for actuator :bulb:

 - Set `path` in `@Endpoint(id="path")` 
 - Create annotated method  with `@ReadOperation`

### Build and Deploy :hammer:

 1. Build command `mvn clean install`
 2. Go to `http://localhost:8080/actuator/path`