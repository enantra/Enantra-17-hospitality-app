package org.enantra.enantra;

import android.app.ProgressDialog;
import android.content.Context;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String enantraID;
    int eidINT;
    ProgressDialog pd;
    res r;
    Boolean success=false;
    LinearLayout sv;
    RelativeLayout get;
    RelativeLayout set;
    int width;
    EditText eid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eid=(EditText)findViewById(R.id.eid);
        Button check=(Button) findViewById(R.id.check);
        Button back=(Button) findViewById(R.id.back);
        sv=(LinearLayout) findViewById(R.id.display);
        pd=new ProgressDialog(MainActivity.this);

        //two relativelayouts to get and display
        get=(RelativeLayout)findViewById(R.id.getdata);
        set=(RelativeLayout)findViewById(R.id.displaydata);


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

    void getData(){

        enantraID=eid.getText().toString();
        eidINT=Integer.parseInt(enantraID);
        //get request for the data
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<res> call = apiService.getData(eidINT);
        call.enqueue(new Callback<res>() {
            @Override
            public void onResponse(Call<res>call, Response<res> response) {
                res result = response.body();
                Log.i("Logincheck",result.toString());
                pd.dismiss();
                if(result.status.equals("0")){
                    success=false;
                    if(result.error!=null||result.error.length()<=0){
                        Snackbar.make(findViewById(android.R.id.content), "Error: "+result.error, Snackbar.LENGTH_LONG)
                                .show();
                    }
                }
                else{
                    success=true;
                    r=result;
                    displayData();
                }

            }
            @Override
            public void onFailure(Call<res>call, Throwable t) {

                pd.dismiss();
                Log.i("TEST","On Failure:"+t.getMessage());
                Snackbar.make(findViewById(android.R.id.content), "Error: "+"Please check your internet Connection", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

    }
    String eventsText(eve e){
        String s="";
        if(e.reg.equals("false")){
            s=s+"Not Registered";
        }
        else{
            s=s+"Registered &";
            if(e.paid.equals("false")){
                s=s+"Not paid";
            }
            else{
                s=s+"Paid & PayId:"+e.getPayId();
            }
        }
        return s;
    }
    String brandManagerText(eve e){
        String s="";
        if(e.reg.equals("false")){
            s=s+"Not Registered";
        }
        else {
            s = s + "Registered ";
        }
        return s;
    }
    //show data
    void displayData(){

        //change views
        get.setVisibility(View.GONE);
        set.setVisibility(View.VISIBLE);

        //DISPLAY ENANTRA ID
        TextView ed= new TextView(MainActivity.this);
        ed.setText("EnantraId: "+r.enantraId);
        ed.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        sv.addView(ed);

        //DISPLAY DETAILS
        TextView na=new TextView(MainActivity.this);
        na.setText("Name: "+r.getD().getName());
        na.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        na.setWidth(width);
        sv.addView(na);

        TextView ge=new TextView(MainActivity.this);
        ge.setText("Gender:"+r.getD().getGender());
        ge.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        ge.setWidth(width);
        sv.addView(ge);

        TextView ag=new TextView(MainActivity.this);
        ag.setText("Age: "+r.getD().getAge());
        ag.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        ag.setWidth(width);
        sv.addView(ag);

        TextView em=new TextView(MainActivity.this);
        em.setText("Email: "+r.getD().getEmail());
        em.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        em.setWidth(width);
        sv.addView(em);

        TextView ph=new TextView(MainActivity.this);
        ph.setText("Phone: "+r.getD().getPhone());
        ph.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        ph.setWidth(width);
        sv.addView(ph);

        TextView ref=new TextView(MainActivity.this);
        ref.setText("Referral Id: "+r.getD().getRef());
        ref.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        ref.setWidth(width);
        sv.addView(ref);

        //DISPLAY EVENTS
        TextView st=new TextView(MainActivity.this);
        st.setText("Street: "+eventsText(r.e.getStreet()));
        st.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        st.setWidth(width);
        sv.addView(st);

        TextView six=new TextView(MainActivity.this);
        six.setText("SixDegree: "+eventsText(r.e.getSixDegree()));
        six.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        six.setWidth(width);
        sv.addView(six);

        TextView ws=new TextView(MainActivity.this);
        ws.setText("Workshop: "+eventsText(r.e.getWorkshop()));
        ws.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        ws.setWidth(width);
        sv.addView(ws);

        TextView rw=new TextView(MainActivity.this);
        rw.setText("Runway: "+eventsText(r.e.getRunway()));
        rw.setWidth(width);
        rw.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        sv.addView(rw);

        TextView bm=new TextView(MainActivity.this);
        bm.setText("Brand Manager: "+brandManagerText(r.brand));
        bm.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        bm.setWidth(width);
        sv.addView(bm);
    }
}
