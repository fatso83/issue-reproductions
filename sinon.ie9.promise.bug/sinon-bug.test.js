describe('Weird IE9 Sinon bug', function () {

	this.timeout(100);

    // if unspecified it will cause the fake timers to affect the next test
    sinon.config = {
            useFakeTimers: false,
    };

	it('test with sinon.test() that causes subsequent hanging test', sinon.test(function () {
		var o = {
			method : function () {
				return Promise.all([]); // will cause hang with sinon.test
			}
		};

		o.method();
	}));

	it('should check for a cached version if cache is enabled', function (done) {
		var o = { bar : function () {}};
		var stub = sinon.stub(o, 'bar', function () {
			return new Promise(function (resolve, reject) {
				resolve('Resolved value');
			})
		});

		stub('test').then(function() { done(); });
	});
});
