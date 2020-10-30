from flask import Flask, jsonify, request
from bowler import best_bowler

app = Flask(__name__)

# data['A']: teamid, data['B']: oppponentid, data['D']: batfirst


@app.route('/', methods=['POST'])
def findbestbowler():
    #fitModels()
    data = request.get_json()
    bestbowler= best_bowler(data['A'], data['B'])
    return jsonify({
        "bestbowler": bestbowler
    })


app.run(host='0.0.0.0', port=5000)
