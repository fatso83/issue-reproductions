# Strange bug in Web Storm + JsDOM

When settup up a mocha test in WebStorm the tests run fine in Node.

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