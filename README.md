# Getting Started

### Prerequisites
* Docker Desktop
* Java SDK 17

### Docker Container Commands

To create a new docker container run

`docker-compose -p "rabbitmq-poc" up`

To restart an existing container

`docker-compose -p "rabbitmq-poc" start`

To stop a container

`docker-compose -p "rabbitmq-poc" stop`

To destroy an existing container

`docker-compose -p "rabbitmq-poc" down`

### Management Console

* URL: [http://localhost:15672/](http://localhost:15672/)
* Username: guest
* Password: guest

### API Endpoints

POST endpoint will publish a message to the queue
[http://localhost:9999/produce]()

Messafe format is
```json
{
  "messageId": 2,
  "message": "Hello World"
}
```

### Testing

* After receiving a message the listener will sleep for 5 seconds.
* If the messageId is greater than the listener with throw an Exception with a message 'abc'.
* If the messageId is equal to 3 then the listener will sleep for another 60 seconds and then successfully consume the message.
* Else the message will be successfully consumed by the listener.