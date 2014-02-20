Querydsl Hibernate Example with UserType
========================================

Querydsl Hibernate Example with UserType is a Maven Multi-module Demo Project using Querydsl to query Hibernate Entities with properties associated with Hibernate UserType, especially UserType property as query parameter.<br>

This demo project also shows one latest Querydsl feature controlling how Hibernate UserType property would be used in Querydsl Query Type generation; you can find more info about this new feature from google group querydsl topic at: https://groups.google.com/forum/#!topic/querydsl/uK6r7QJ8GDI.<br> 

This demo project has three sub-projects:<br>

1. querydsl-hbm-plugin: a maven plugin project creating querydsl-hbm-plugin which would use HibernateDomainExporter to generate Querydsl Query Type<br>
   
2. hibernate-entities: a simple java project creating hibernate entity "Subscriber" with properties associated with Hibernate UserType, the entity is mapped to "subscriber" table in postgres db "querydslexample" through mapping file "Subscriber.hbm.xml"<br>

3. querydsl-codegen: simple java project which would use querydsl-hbm-plugin to generate Query Type "QSubscriber" and test Querydsl using Hibernate UserType property as query parameter<br>

To run querydsl-hbm-usertype-example project:<br>

1. Create a local Postgresql DB "querydslexample" under "postgres" user running on localhost port 5432 <br>
2. Execute "postgres_subscriber_table.sql" through either psql or pgAdmin to create "subscriber" table <br>
3. Run "mvn clean install" to build the whole projects, you can verify the generated "QSubscriber" Query Type matching the Annotation defined in "Subscriber" and UserType property "facebookId" can be used as query parameter and querydsl returns the correct result<br>


