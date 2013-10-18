import webapp2


class MainPage(webapp2.RequestHandler):

    def options(self):
        self.response.headers["Access-Control-Allow-Methods"] = "GET, POST, OPTIONS";
        if 'Origin' in self.request.headers:
            self.response.headers["Access-Control-Allow-Origin"] = self.request.headers['Origin'];
        self.response.headers["Access-Control-Allow-Headers"] = "Content-Type, Accept, Authorization, Cache-Control";

    def get(self):
        import json,time
        self.response.headers['Content-Type'] = 'application/json'
        self.response.headers["Access-Control-Allow-Methods"] = "GET, POST, OPTIONS";
        #self.response.headers["Access-Control-Allow-Origin"] = "*";
        self.response.headers["Access-Control-Allow-Headers"] = "Content-Type, Accept, Authorization, Cache-Control";

        #if self.response.headers.has_key("Cache-Control"):
        #    del self.response.headers["Cache-Control"]
        self.response.headers["Cache-Control"] = 'max-age=10'

        if 'Origin' in self.request.headers:
            self.response.headers["Access-Control-Allow-Origin"] = self.request.headers['Origin'];
        if 'Cache-Control' in self.request.headers:
            self.response.headers["Cache-Control"] = self.request.headers['Cache-Control'];

        output_obj = {}
        output_obj['time'] = time.ctime()
        headers = self.request.headers
        #output_obj['Authorization header'] = headers.keys() #['Authorization']
        if "Authorization" in headers.keys():  #['Authorization']
            output_obj['Authorization'] = headers['Authorization']

        self.response.write(json.dumps(output_obj))

app = webapp2.WSGIApplication([
    ('/', MainPage),
], debug=True)
