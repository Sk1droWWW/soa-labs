import json
import random
import socket
import time

from flask import Flask
from flask import jsonify
from flask_http_middleware import MiddlewareManager, BaseHTTPMiddleware

app = Flask(__name__)

BUCKET_SIZE = 2


class LimiterMiddleware(BaseHTTPMiddleware):
    def __init__(self):
        super().__init__()
        self.connections = 0
        self.users_work_timestemps = []

    def dispatch(self, request, call_next):
        for timestamp in self.users_work_timestemps:
            current_time = time.time()

            if (current_time - timestamp) > 15:
                self.users_work_timestemps.remove(timestamp)
                self.connections -= 1   

        if self.connections < BUCKET_SIZE:
            self.connections += 1
            self.users_work_timestemps.append(time.time())
            return call_next(request)
        else:
            return jsonify({'country_host': socket.gethostname(),
                            "country message":"Bucket is full"
                            
            })

app.wsgi_app = MiddlewareManager(app)
app.wsgi_app.add_middleware(LimiterMiddleware)


@app.route('/country')
def news():
    file = open("countries.json")
    data = json.load(file)
    countries = data["countries"]
    random_country = random.choice(countries)
    
    return jsonify(
        {
            'country': random_country['country'], 
            'provided_tanks': random_country['provided_tanks'],
            'country_host': socket.gethostname()
        }
    )

if __name__ == '__main__':
     app.run(debug=True)