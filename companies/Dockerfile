FROM python:3.9-slim

WORKDIR /companies

COPY . .

RUN pip install -r requirements.txt

# Run the application:
CMD gunicorn --bind 0.0.0.0:8081 companies:app
