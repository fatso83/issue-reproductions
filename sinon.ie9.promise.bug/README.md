This tests aims to demonstrate that the sandbox created 
by `sinon.test` is leaking. Specifically, it does not clean 
up the fake timers in one way of the other.

To show the bug start up a Karma server running on port 9876
by issuing the following commands
 
    npm install # installs all dependencies

    # start up the test server
    ./node_modules/karma/bin/karma start karma.minimal.conf.js"

Then point your IE9 installation at localhost:9876 and see that 
the tests complete successfully in your terminal.

Then uncomment the line that says `useFakeTimers: false`, and
check the test run. It should now display one failed test.
