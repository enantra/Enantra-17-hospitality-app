package org.enantra.enantra;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String enantraID;
    int eidINT;
    ProgressDialog pd;
    EnantraResponse r;
    Boolean success = false;
    LinearLayout sv;
    RelativeLayout get;
    RelativeLayout set;
    int width;
    EditText eid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eid = (EditText) findViewById(R.id.eid);
        Button check = (Button) findViewById(R.id.check);
        Button back = (Button) findViewById(R.id.back);
        sv = (LinearLayout) findViewById(R.id.display);
        pd = new ProgressDialog(MainActivity.this);

        //two relativelayouts to get and display
        get = (RelativeLayout) findViewById(R.id.getdata);
        set = (RelativeLayout) findViewById(R.id.displaydata);

        width = Resources.getSystem().getDisplayMetrics().widthPixels;

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd.show();
                getData();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sv.removeAllViews();
                set.setVisibility(View.GONE);
                get.setVisibility(View.VISIBLE);
            }
        });
    }

    void getData() {
        enantraID = eid.getText().toString();
        eidINT = Integer.parseInt(enantraID);
        //get request for the data
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<EnantraResponse> call = apiService.getData(eidINT);
        call.enqueue(new Callback<EnantraResponse>() {
            @Override
            public void onResponse(Call<EnantraResponse> call, Response<EnantraResponse> response) {
                EnantraResponse result = response.body();
                pd.dismiss();
                if (result.getStatus() == 0) {
                    success = false;
                    if (result.getError() != null || result.getError().length() <= 0) {
                        Snackbar.make(
                                findViewById(android.R.id.content),
                                "Error: " + result.getError(),
                                Snackbar.LENGTH_LONG
                        ).show();
                    }
                } else {
                    success = true;
                    r = result;
                    displayData();
                }

            }

            @Override
            public void onFailure(Call<EnantraResponse> call, Throwable t) {
                pd.dismiss();
                Log.d("EnantraTest", "On Failure :" + t.getMessage());
                Snackbar.make(
                        findViewById(android.R.id.content),
                        "Error: Please check your internet Connection",
                        Snackbar.LENGTH_LONG
                ).show();
            }
        });

    }

    void displayData() {

        get.setVisibility(View.GONE);
        set.setVisibility(View.VISIBLE);


        TextView details = new TextView(MainActivity.this);
        details.setText("Details");
        details.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        details.setWidth(width);
        sv.addView(details);

        TextView id = new TextView(MainActivity.this);
        id.setText(String.format(Locale.ENGLISH, "EnantraID: %d", r.getEnantraId()));
        id.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        sv.addView(id);

        TextView name = new TextView(MainActivity.this);
        name.setText(String.format(Locale.ENGLISH, "Name: %s", r.getDetails().getName()));
        name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        name.setWidth(width);
        sv.addView(name);

        TextView email = new TextView(MainActivity.this);
        email.setText(String.format(Locale.ENGLISH, "Email: %s", r.getDetails().getEmail()));
        email.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        email.setWidth(width);
        sv.addView(email);

//        TextView phone = new TextView(MainActivity.this);
//        phone.setText(String.format(Locale.ENGLISH, "Phone: %s", r.getDetails().getPhone()));
//        phone.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
//        phone.setWidth(width);
//        sv.addView(phone);

        TextView brandManager = new TextView(MainActivity.this);
        brandManager.setText(String.format("Brand Manager: %s", r.getBrand()));
        brandManager.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        brandManager.setWidth(width);
        sv.addView(brandManager);

        TextView miniEvents = new TextView(MainActivity.this);
        miniEvents.setText(String.format("Mini Events: %s", r.getMiniEvents()));
        miniEvents.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        miniEvents.setWidth(width);
        sv.addView(miniEvents);

        TextView sixdegree = new TextView(MainActivity.this);
        sixdegree.setText("SixDegree");
        sixdegree.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        sixdegree.setWidth(width);
        sv.addView(sixdegree);

        for (Ticket ticket : r.getTickets()) {
            TextView ticketView = new TextView(MainActivity.this);
            ticketView.setText(ticket.toString());
            ticketView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            ticketView.setWidth(width);
            sv.addView(ticketView);
        }

        TextView workshop = new TextView(MainActivity.this);
        workshop.setText("Workshops");
        workshop.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        workshop.setWidth(width);
        sv.addView(workshop);


        Workshops workshops = r.getWorkshops();

        TextView startup = new TextView(MainActivity.this);
        startup.setText(String.format(Locale.ENGLISH, "Startup: %s", workshops.getStartup()));
        startup.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        startup.setWidth(width);
        sv.addView(startup);

        TextView growth = new TextView(MainActivity.this);
        growth.setText(String.format(Locale.ENGLISH, "Growth Hacking: %s", workshops.getGrowth()));
        growth.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        growth.setWidth(width);
        sv.addView(growth);

        TextView kids = new TextView(MainActivity.this);
        kids.setText(String.format(Locale.ENGLISH, "Kids: %s", workshops.getKids()));
        kids.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        kids.setWidth(width);
        sv.addView(kids);

        TextView abled = new TextView(MainActivity.this);
        abled.setText(String.format(Locale.ENGLISH, "Differently abled: %s", workshops.getAbled()));
        abled.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        abled.setWidth(width);
        sv.addView(abled);

        TextView stocks = new TextView(MainActivity.this);
        stocks.setText(String.format(Locale.ENGLISH, "Stock Market: %s", workshops.getStocks()));
        stocks.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        stocks.setWidth(width);
        sv.addView(stocks);

    }
}
