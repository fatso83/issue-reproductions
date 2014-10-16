// Karma minimal configuration

module.exports = function (config) {
	config.set({

		// base path, that will be used to resolve files and exclude
		basePath   : '.',

		// frameworks to use
		frameworks : ['mocha', 'sinon', 'expect'],

		// list of files / patterns to load in the browser
		files      : [
            //'node_modules/es6-promise/dist/es6-promise.js',
            'es6-promises.js',
            'sinon-bug.test.js'
		],
		browsers         : []
	});
};
