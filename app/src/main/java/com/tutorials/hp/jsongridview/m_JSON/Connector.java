package com.tutorials.hp.jsongridview.m_JSON;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Oclemy on 7/7/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * ----------------------ROLES----------------
 * 1.Establish connection
 * 2. Connection props
 */
public class Connector {


    public static Object connect(String jsonURL)
    {
        try
        {
            URL url=new URL(jsonURL);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();

            //CON PROPS
            con.setRequestMethod("GET");
            con.setConnectTimeout(15000);
            con.setReadTimeout(15000);
            con.setDoInput(true);

            return con;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error "+e.getMessage();

        } catch (IOException e) {
            e.printStackTrace();
            return "Error "+e.getMessage();

        }
    }


}
