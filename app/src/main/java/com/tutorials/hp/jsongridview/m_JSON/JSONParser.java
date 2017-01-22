package com.tutorials.hp.jsongridview.m_JSON;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Oclemy on 7/7/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * ----------ROLESE-----------
 * 1.RECEIVE JSON DATA
 * 2.PARSE IT
 * 3.BIND IT TO GRIDVIEW
 */
public class JSONParser extends AsyncTask<Void,Void,Boolean>{

    Context c;
    String jsonData;
    GridView gv;

    ProgressDialog pd;
    ArrayList<String> users=new ArrayList<>();

    public JSONParser(Context c, String jsonData, GridView gv) {
        this.c = c;
        this.jsonData = jsonData;
        this.gv = gv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parse JSON");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();

        if(isParsed)
        {
            //BIND
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(c,android.R.layout.simple_list_item_1,users);
            gv.setAdapter(adapter);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(c, users.get(i), Toast.LENGTH_SHORT).show();
                }
            });

        }else
        {
            Toast.makeText(c, "Unable To Parse,Check Your Log output", Toast.LENGTH_SHORT).show();
        }

    }

    //PARSE
    private Boolean parse()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            users.clear();

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                String name=jo.getString("name");

                users.add(name);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }


}

















