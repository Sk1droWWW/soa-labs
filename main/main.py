from flask import Flask
import socket
import requests

app = Flask(__name__)

@app.route('/')
def index():
    return f"Web App with Python Flask by Mykhailo Tokar, container id: {socket.gethostname()}"


@app.route('/info', methods = ['GET'])
def weather():
    company_response = requests.get("http://company")
    country_response = requests.get("http://country")
 
    company_info = company_response['company'] + ": " + company_response['provided_aid'] + "\n"
    country_info = country_response['country'] + ": " + country_response['provided_tanks'] + "\n"
   
    company_host = "\ncompany_host: " + company_response['company_host']
    country_host = "\ncountry_host: " + country_response['country_host']
    
    return company_info + country_info + company_host + country_host


if __name__ == '__main__':
    app.run(debug=True)
