## Querydsl Hibernate Example with UserType

Querydsl Hibernate Example with UserType is an example project that demonstrates using Querydsl to query Hibernate Entity which has UserType properties, it also demonstrates one latest Querydsl feature which would hide certain hibernate entity property associated with UserType from Querydsl codegen; you can find more info about this new feature from google group querydsl topic at: https://groups.google.com/forum/#!topic/querydsl/uK6r7QJ8GDI. 

Querydsl Hibernate Example with UserType is one Maven Multi-module Project with three sub-projects:

1. querydsl-hbm-plugin: it is maven plugin project to create maven plugin utilizing HibernateDomainExporter to generate Querydsl QEntity class(es)
   
2. hibernate-entities: simple java project creating hibernate entity "Subscriber" with properties associated with Hibernate UserType, the entity is  mapped to "subscriber" table in postgres db "querydslexample" through mapping file "Subscriber.hbm.xml"

3. querydsl-codegen: simple java project which would use querydsl-hbm-plugin to generate "QSubscriber" and test Querydsl with Hibernate UserType

