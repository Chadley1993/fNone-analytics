from flask import Flask
from flask_cors import CORS
import math

app = Flask(__name__)

CORS(app)

i = 0
# Home route
@app.route('/')
def home():
    return "Welcome to the Flask Server!"

# Example API route
@app.route('/data', methods=['GET', 'POST'])
def data():
    if True:
        global i
        i += 0.1
        speed = int(math.sin(i % 3) * 200)
    else:
        speed = "---"
    return { "speedKPH": speed, "refreshReat": 30000 }

if __name__ == '__main__':
    app.run(debug=True)