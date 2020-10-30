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


# a: teamId, b: opponentId, c:tosswon, d:batfirst


def predict(aa, bb, cc, dd):
   
    print(aa, bb, cc, dd)
    #print("Enter Team A Id")
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
   # print(px)
    px = px.drop(['Match_Id'], 1)
    px = px.drop(['Match_Won'], 1)
    # print(px)
    px = preprocessing.scale(px)
    # print(px)
    lin_svm = svm.LinearSVC()
    lin_svm.fit(X_train, y_train)
    pred = lin_svm.predict(px)
    # return A, B
    if(pred[0] == 1):
        #print("A")
        return "A wins"
    else:
        #print("B")
        return "B wins"


def fitModels():

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
    print(accu)


#predict(aa,bb,cc,dd)