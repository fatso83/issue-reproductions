# Web Storm breaking jsdom

When setup up a mocha test in WebStorm the tests run fine in Node.

But if you try to run the tests under the debugger the initialization of
jsdom will fail with an array of errors :

```
	[ {
		data : null,
		message : ReferenceError: process is not defined,
		...
	}]
```

In other words, the test runner interferes with jsdom, giving another result
than when running in 'normal' mode.

To verify the bug:
1. clone the repo
2. open the directory in webstorm
3. configure a Mocha test run; default values and test directory pointing to the 'test' folder
4. Run the tests
5. Run the tests using the Debug Run and see it fail in the beforeAll() part
