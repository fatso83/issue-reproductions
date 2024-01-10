# Minimal reproduction of Spring Framework 6.1 / Spring Boot 3.2 issue
> Parameter injection was not working after Spring 6.1 (https://github.com/spring-projects/spring-framework/issues/31998)

## To show the issue
```
(cd common-library && mvn clean install) && mvn clean test
```

## To fix the issue
Toggle the line with `<parameters>true</parameters>` in the pom.xml of the common library
and re-run the above command.

The [fix/explanation was supplied by the Spring Team's Juergen Hoeller](https://github.com/spring-projects/spring-framework/issues/31998#issuecomment-1884479117)
and is mentioned in [the wiki for upgrading to Spring 6.1](https://github.com/spring-projects/spring-framework/wiki/Upgrading-to-Spring-Framework-6.x#parameter-name-retention).
