# spring-boot-redis

Redis Stack on Docker:
https://redis.io/docs/stack/get-started/install/docker/

It is started with different ports, you may need to change the application.yml file.

```docker run -p 10001:6379 -p 13333:8001 redis/redis-stack:latest```

Redis insight runs on: [localhost:13333](http://localhost:13333)

Redis server runs on: [localhost:10001](http://localhost:10001)

application.yml:
```yml
spring:
  application:
    name: Redis-Demo
  data:
    redis:
      host: localhost
      port: 10001
  datasource:
    url: jdbc:h2:mem:testdb
  jpa:
    hibernate:
      ddl-auto: update
  h2:
    console:
      enabled: true
```
