from flask import Flask, jsonify, request
#from main import predict, fitModels
from bowler import best_bowler
from batsman import best_batsman
from allrounder import best_allrounder


def predict(aa, bb, cc, dd):
    import pandas as pd
    import numpy as np
    import sklearn
    from sklearn import preprocessing, model_selection, svm, neighbors
    from sklearn.linear_model import LinearRegression
    from sklearn.ensemble import RandomForestClassifier
    from sklearn.naive_bayes import GaussianNB
    import data as d

    teamsDF = pd.read_csv('../data/Team.csv')
    matchesTeamsDF = pd.read_csv("../data/gen/match_team.csv")
    data = matchesTeamsDF.drop(['Match_Id'], 1)
    data = data.drop(['Unnamed: 0'], 1)
    X = data.drop(['Match_Won'], 1)
    Y = data['Match_Won']
    # print(X)
    # print(Y)
    X = preprocessing.scale(X)
    X_train, X_test, y_train, y_test = model_selection.train_test_split(X, Y, test_size=0.25)

    print(aa, bb, cc, dd)
    # print("Enter Team A Id")
    '''teamId = aa
    while(len(teamsDF[teamsDF["Team_Id"] == int(teamId)]) == 0):
        print("Please Enter valid Team Id")
        teamId = aa
    #print("Enter Team B Id")
    opponentId = bb
    while(len(teamsDF[teamsDF["Team_Id"] == int(opponentId)]) == 0):
        print("Please Enter valid Team Id")
        opponentId = bb
    #print("Which team won the toss?Enter Id")
    tossWon = cc
    while((tossWon != teamId) & (tossWon != opponentId)):
        print("Please Enter valid Team Id. %s or %s" % (teamId, opponentId))
        tossWon = cc
    #print("Which team bat first?Enter Id")
    batFirst = dd
    while((batFirst != teamId) & (batFirst != opponentId)):
        print("Please Enter valid Team Id. %s or %s" % (teamId, opponentId))
        batFirst = dd'''
    px = d.generatePredictData(int(aa), int(bb), int(cc), int(dd))
    print(px)
    px = px.drop(['Match_Id'], 1)
    px = px.drop(['Match_Won'], 1)
    print(px)
    px = preprocessing.scale(px)
    print(px)

    '''svc_svm = svm.SVC()
    svc_svm.fit(X_train,y_train)
    pred=svc_svm.predict(px)
    print(pred)'''

    lin_svm = svm.LinearSVC()
    lin_svm.fit(X_train, y_train)
    pred = lin_svm.predict(px)
    print(pred)
    # return A, B
    x=pred
    if (x == 1):
        print("A")
        return "A"
    else:
        print("B")
        return "B"


'''def fitModels():
    print("Linear SVM")
    lin_svm = svm.LinearSVC()
    lin_svm.fit(X_train, y_train)
    accu = lin_svm.score(X_test, y_test)
    print(accu)

    print("SVC SVM")
    svc_svm = svm.SVC()
    svc_svm.fit(X_train, y_train)
    accu = svc_svm.score(X_test, y_test)
    print(accu)

    print("Naive Bayes")
    gnb = GaussianNB()
    gnb.fit(X_train, y_train)
    accu = gnb.score(X_test, y_test)
    print(accu)

    print("Random Forest")
    rf = RandomForestClassifier()
    rf.fit(X_train, y_train)
    accu = rf.score(X_test, y_test)
    print(accu)'''


app = Flask(__name__)

# data['A']: teamid, data['B']: oppponentid,  data['C']: tosswon, data['D']: batfirst


@app.route('/', methods=['POST'])
def predict_winner():
    #fitModels()
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


