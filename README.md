
# :eyes: Monitoring with RabbitMQ

### Prerequsites :heavy_exclamation_mark:

 1. `JDK 1.8` at least - for running app
 2. `Maven 3+` - for building package
 3. `RabbitMQ`  -  for setting message queue


### Configuration RabbitMQ :rabbit:

 1. Enabled rabbitMQ management by command `rabbitmq-plugins enable rabbitmq_management --online`
 2. Go to `http://localhost:15672` and login as `guest`. Add exchange `jsa.direct` with `type = direct`
 3. Add queue `jsa.queue` with binding parameters of created exchange `jsa.direct`

### Build and Deploy :hammer:

 1. Build both services by `mvn clean install`
 2. Go to `http://localhost:8085` and `connect` to websockets
