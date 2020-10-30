import pandas as pd

def best_batsman(aa,bb):
    df1=pd.read_csv('../data/gen/player_score.csv')
    df2=pd.read_csv('../data/gen/player_match_score.csv')
    #display(df1)
    '''for df1['Player_Id']==df2['Player_Id']:
    df1['Is_Batsman']=df2['Is_Batsman']
    display(df1)  '''
    df3=df1.merge(df2,on='Player_Id',how='outer')
    #display(df3)
    #print("Enter Team A Id")
    #teamId = input()
    teamId=aa
    #print("Enter Team B Id")
    #opponentId = input()
    opponentId=bb
    array=[teamId,opponentId]
    df4=df3.loc[df3['Team_Id'].isin(array)]
    df5=df4.drop(['Match_Id','Score','Unnamed: 0_y','Unnamed: 0_x'],axis=1)
    df6=df5.drop_duplicates()
    df7=df6.sort_values(by=['Is_Batsman','Avg_Score'],ascending=False)
    #df8=df7.sort_values(by=['Avg_Score'],ascending=False)
    #display(df7)
    x=df7.iloc[0]
    #print(x['Player_Name'])
    return x['Player_Name']