import requests
from datetime import datetime


start_time = datetime.now()
# for i in range(1000):
# data = {'sensorNames[]': ['test-sensor-1', 'world']}
# response = requests.get('http://localhost:8080/onboard-bridge', params=data)
response = requests.get('http://localhost:8080/onboard-bridge?sensorName=test-sensor-1')

print(response.status_code)
print(response.content)
delta = datetime.now() - start_time
print(delta.total_seconds())