This is an *unsuccessfull* attempt at reproducing a bug we 
experienced in Spring 3.2.0 that is not present in the 3.1.x versions.

The bug was submitted as [Spring Framework issue 31998](https://github.com/spring-projects/spring-framework/issues/31998)

The difference is probably related to JDBC in some way, as I 
reproduced the setup, but as plain POJOs with no bindings
to any other interfaces. 

In this project autowire is able to successfully wire up the 
correct dependencies, even if multiple candidate beans are available.
I tried
- having only one candidate bean, but of not the right name (works)
- having multiple candidates on the classpath (one from the test classes in a test-jar, one from the normal classes), but excluding the non-test bean (works)
- having multiple candidates on the classpath (one from the test classes in a test-jar, one from the normal classes), but _not_ excluding the non-test bean, but matching on the bean name (works)

Basically Spring Autowire seems to work as intended, so something else must be up :-/

The difference is that in our production setup, the beans that fails to map up are either `DataSource`'s or `JdbcTemplates`. So type/class seems to matter somehow. Note, that this has worked for 8 years through Spring 2.x and 3.1.

Where the bug happens in Spring: `DefaultListableBeanFactory#determineAutowireCandidate()`. When
DefaultListableBeanFactory#doResolveDependency() calls that method the code looks like this:
```java
// Step 4: determine single candidate
if (matchingBeans.size() > 1) {
    autowiredBeanName = determineAutowireCandidate(matchingBeans, descriptor);
    if (autowiredBeanName == null) {
```

In Spring 3.1.7 (and 3.1.2), `autowiredBeanName` returns one bean. In Spring 3.2.0 and 3.2.1, it returns `null`. It was
a this point I got dissy trying to debug this, diving further into a rabbit hole I had no idea where was going, so
that's when I gave up and just submitted the bug without knowing what goes wrong.
