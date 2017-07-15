package com.example.alexalins.questao_03;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Alexa Lins on 13/07/2017.
 */
public class RecuperarDadosPeloCEP {

    protected JSONObject recuperarDados(String cep) {
        //passando url
        String searchUrl = ("https://viacep.com.br/ws/"+cep+"/json/");//passando cep na url
        URL url = null;
        try {
            url = new URL(searchUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;//criando conexao
        try {
            connection = (HttpURLConnection) url.openConnection();//conectando
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //setando dados da conexao
            connection.setReadTimeout(10000 /* milliseconds */ );
            connection.setConnectTimeout(15000 /* milliseconds */ );
            connection.setDoOutput(true);
            connection.connect();
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;//criando BR pra ler o json
        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder(); //configurando a string

        try {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = sb.toString();
        System.out.println("JSON: " + jsonString);

        JSONObject jsonObject = null;

        try {
            jsonObject = new JSONObject(jsonString);//criando um objeto recebendo o json como string
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;//retornando json
    }
}
