import socket

import requests
from flask import Flask

app = Flask(__name__)


@app.route('/')
def index():
    return f"Web App with Python Flask by Mykhailo Tokar, container id: {socket.gethostname()}"


@app.route('/info', methods=['GET'])
def weather():
    company_response = requests.get("http://balancer:8000/company").json()
    country_response = requests.get("http://balancer:8000/country").json()

    company_info = company_response['company'] + \
        ": " + company_response['provided_aid'] + "\n"
    if country_response.get('country') is not None:
        country_info = country_response.get('country') + \
            ": " + country_response.get('provided_tanks') + "\n"
    else:
        country_info = country_response.get('country message')
    
    company_host = "\ncompany_host: " + company_response['company_host']
    country_host = "\ncountry_host: " + country_response['country_host']
    main_host = "\nmain_host: " + socket.gethostname()

    return company_info + country_info + company_host + country_host + main_host

if __name__ == '__main__':
    app.run(debug=True)
