import math
import time
import requests
import json

theta = 0.1
while True:
    temp = math.sin(theta)
    # response = requests.post("https://www.postb.in/1734954949607-5445870619732", json={"temperature": temp}, headers={"sensor-name": "test-sensor-1"})
    response = requests.post("http://localhost:8080/data-bridge", json={"temperature": temp}, headers={"sensor-name": "test-sensor-1"})
    print(response.status_code)
    time.sleep(0.1)
    theta += 0.1
