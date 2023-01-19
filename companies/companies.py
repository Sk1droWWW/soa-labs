import json
import random
import socket

from flask import Flask
from flask import jsonify

app = Flask(__name__)


@app.route('/company')
def news():
    file = open("companies.json")
    data = json.load(file)
    companies = data["companies"]
    random_company = random.choice(companies)
    
    return jsonify(
        {
            'company': random_company['company'], 
            'provided_aid': random_company['provided_aid'],
            'company_host': socket.gethostname()
        }
    )

if __name__ == '__main__':
     app.run(debug=True)