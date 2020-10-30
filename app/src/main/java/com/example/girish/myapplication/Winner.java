package com.example.girish.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.girish.myapplication.model.BasicRequest;
import com.example.girish.myapplication.model.BasicResponse;
import com.example.girish.myapplication.model.NetworkCallback;
import com.example.girish.myapplication.network.DataRepository;

import java.util.ArrayList;

import retrofit2.Response;

public class
Winner extends AppCompatActivity {
    Spinner spinner1, spinner2, spinner3, spinner4;
    TextView textView;
    ArrayList<String> arrayList = new ArrayList<>();
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);
        //textView = findViewById(R.id.tvResulr);
        final String[] nothing = {"Select Team"};
        final String[] Teams = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] chennai = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] mumbai = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] sunriser = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] royal = {"Select Team", "1.Kolkata Knight Riders", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] punjab = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] delhi = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] rajasthan = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] gujarat = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants"};
        final String[] Deccan = {"Select Team", "1.Kolkata Knight Riders", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] kolkata = {"Select Team", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] kochi = {"Select Team", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "10.Pune Warriors", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};
        final String[] pune = {"Select Team", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "10.Pune Warriors", "11.Sunriser Hyderabad", "13.Gujarat Lions"};
        final String[] pune_war = {"Select Team", "2.Royal Challengers Bangalore", "3.Chennai Super Kings", "4.Kings X1 Punjab", "5.Rajasthan Royals", "6.Delhi Daredevils", "7.Mumbai Indians", "8.Deccan Charges", "9.Kochi Tuskers Kerala", "11.Sunriser Hyderabad", "12.Rising Pune Supergiants", "13.Gujarat Lions"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, Teams);
        spinner1.setAdapter(adapter);
        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, nothing);
        spinner2.setAdapter(adapter0);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 1:
                        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, kolkata);
                        spinner2.setAdapter(adapter1);
                        break;
                    case 2:
                        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, royal);
                        spinner2.setAdapter(adapter2);
                        break;
                    case 3:
                        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, chennai);
                        spinner2.setAdapter(adapter3);
                        break;
                    case 4:
                        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, punjab);
                        spinner2.setAdapter(adapter4);
                        break;
                    case 5:
                        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, rajasthan);
                        spinner2.setAdapter(adapter5);
                        break;
                    case 6:
                        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, delhi);
                        spinner2.setAdapter(adapter6);
                        break;
                    case 7:
                        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, mumbai);
                        spinner2.setAdapter(adapter7);
                        break;
                    case 8:
                        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, Deccan);
                        spinner2.setAdapter(adapter8);
                        break;
                    case 9:
                        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, kochi);
                        spinner2.setAdapter(adapter9);
                        break;
                    case 10:
                        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, pune_war);
                        spinner2.setAdapter(adapter10);
                        break;
                    case 11:
                        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, sunriser);
                        spinner2.setAdapter(adapter11);
                        break;
                    case 12:
                        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, pune);
                        spinner2.setAdapter(adapter12);
                        break;
                    case 13:
                        ArrayAdapter<String> adapter13 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, gujarat);
                        spinner2.setAdapter(adapter13);
                        break;
                }

                final String pos1 = spinner1.getItemAtPosition(i).toString();
                if (!arrayList.contains(pos1)) {

                    if (arrayList.size() < 2) {
                        arrayList.add(pos1);
                    } else {
                        arrayList.set(1, pos1);
                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                final String pos = spinner2.getItemAtPosition(i).toString();

                if (!arrayList.contains(pos)) {
                    if (arrayList.size() < 3) {
                        arrayList.add(pos);
                    } else {
                        arrayList.set(2, pos);
                    }

                }


                ArrayAdapter<String> adapter14 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, arrayList);
                spinner3.setAdapter(adapter14);

                ArrayAdapter<String> adapter15 = new ArrayAdapter<String>(Winner.this, android.R.layout.simple_spinner_dropdown_item, arrayList);
                spinner4.setAdapter(adapter15);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });


        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void submit(View view) {
        String teamA = spinner1.getSelectedItem().toString();
        teamA = teamA.substring(0, 1);
        String teamB = spinner2.getSelectedItem().toString();
        teamB = teamB.substring(0, 1);
        String teamToss = spinner3.getSelectedItem().toString();
        teamToss = teamToss.substring(0, 1);
        String teamBat = spinner4.getSelectedItem().toString();
        teamBat = teamBat.substring(0, 1);
        BasicRequest basicRequest = new BasicRequest();
        basicRequest.setTeamA(teamA);
        basicRequest.setTeamB(teamB);
        basicRequest.setTeamToss(teamToss);
        basicRequest.setTeamBatFirst(teamBat);
        getResult(basicRequest);
    }

    private void getResult(BasicRequest basicRequest) {
        DataRepository dataRepository = new DataRepository();
        dataRepository.setCustomBaseUrl("http://192.168.43.53:5000");
        dataRepository.getResult(basicRequest, new NetworkCallback<BasicResponse>() {
            @Override
            public void onSuccess(Response<BasicResponse> response) {
                setResults(response);
            }

            @Override
            public void onFailure(Throwable throwable, int failureCode) {
                textView.setText("Some Error occured");
            }
        });
    }

    private void setResults(Response<BasicResponse> response) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String resultObj = gson.toJson(response.body());
        if (response.body() != null) {
            //textView.setText(response.body().getWinner());
            String s= response.body().getWinner();
            String sa;
            String teamA = spinner1.getSelectedItem().toString();
            String teamB = spinner2.getSelectedItem().toString();
            StringBuffer a = new StringBuffer( "A");
            StringBuffer b = new StringBuffer( "B");
            //          String a="A";
//            String b="B";
            if(s.contentEquals(a))
            {
                sa=teamA.substring(2);
            }
            else if(s.contentEquals(b))
            {
                sa=teamB.substring(2);
            }
            else
            {
                sa="Error";
            }
            Toast toast = Toast.makeText(getApplicationContext(), sa, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
