from flask import Flask, jsonify, request
from main import predict, fitModels
from bowler import best_bowler
from batsman import best_batsman
from allrounder import best_allrounder

app = Flask(__name__)

# data['A']: teamid, data['B']: oppponentid,  data['C']: tosswon, data['D']: batfirst


@app.route('/', methods=['POST'])
def predict_winner():
    fitModels()
    data = request.get_json()
    winner = predict(data['A'], data['B'], data['C'], data['D'])
    bestbowler = best_bowler(data['A'], data['B'])
    bestbatsmen = best_batsman(data['A'], data['B'])
    allrounder = best_allrounder(data['A'], data['B'])
    return jsonify({
        "winner": winner,
        "best_bowler": bestbowler,
        "best_batsman": bestbatsmen,
        "all_rounder": allrounder
    })


app.run(host='0.0.0.0', port=5000)
