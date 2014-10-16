describe('Weird IE9 Sinon bug', function () {

	this.timeout(100);

	it('test with sinon.test() that causes subsequent hanging test', sinon.test(function () {
		var o = {
			method : function () {
                //return; // won't hang
				return Promise.all([]); // will cause hang with sinon.test
			}
		};

		o.method();
	}));

	it('should check for a cached version if cache is enabled', function (done) {
		var o = { bar : function () {}};
		var stub = sinon.stub(o, 'bar', function () {
			return new Promise(function (resolve, reject) {
				console.log('Resolving promise');
				resolve('Resolved value');
			})
		});

		stub('test')
			.then(function() { console.log(arguments)})
			.then(done)
	});
});
