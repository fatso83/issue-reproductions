# Bumping Google Firebase from 9.3.0 to 9.4.0 gives java.lang.NoClassDefFoundError

## What
This is the absolute minimal example derived from an existing project that will display
the following issue when running `mvn test`:

```
16:28:51,622 [ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.007 s <<< FAILURE! -- in com.callback.CallbackDetailsTest
16:28:51,622 [ERROR] com.callback.CallbackDetailsTest -- Time elapsed: 0.002 s <<< ERROR!
java.lang.NoClassDefFoundError: shaded_package/org/hamcrest/SelfDescribing
	at java.base/java.lang.ClassLoader.defineClass1(Native Method)
	at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1027)
	at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:150)
<snipped...>
Caused by: java.lang.ClassNotFoundException: shaded_package.org.hamcrest.SelfDescribing
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:526)
	... 18 more
```

## Why
I am not sure. Would be great to understand what makes this error appear by simply bumping the version number.
Posted a question on [StackOverflow](https://stackoverflow.com/questions/79078776/why-does-upgrading-firebase-admin-from-9-3-to-9-4-cause-junit-to-fail-with-an-er).
