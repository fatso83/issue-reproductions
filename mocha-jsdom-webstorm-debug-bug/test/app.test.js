var assert = require('assert'),
	runningNode = typeof exports !== 'undefined' && this.exports !== exports;

describe('App', function () {
	var app;

	if (runningNode) {
		before(function setupNode (done) {
			var jsdom = require('jsdom');
			jsdom.env({
				file    : 'app.html',
				scripts : ['app.js'],
				done    : function (error, window) {
					global.window = window;
					done(error);
				}
			});
		});
	}

	describe('#changeBody()', function () {
		it('should change the body', function () {
			app = Object.create(window.App);
			assert.notEqual('Changed', window.document.body.innerHTML);
			app.changeBody("Changed");
			assert.equal('Changed', window.document.body.innerHTML);
		})
	})
});
