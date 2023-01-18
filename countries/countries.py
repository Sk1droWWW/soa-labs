from flask import Flask
from flask import jsonify
import json
import random
import socket

app = Flask(__name__)

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