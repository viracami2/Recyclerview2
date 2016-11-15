package com.virra.recyclerview2;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Contacto extends AppCompatActivity {

    @Bind(R.id.txtnombre)
    EditText txtnombre;
    @Bind(R.id.txtcorreo)
    EditText txtcorreo;
    @Bind(R.id.txtmensaje)
    EditText txtmensaje;
    Session session;
    String co;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @OnClick(R.id.btnenviar)
    public void onClick() {
        String nom= txtnombre.getText().toString();
        String men= txtmensaje.getText().toString();
        String correo= txtcorreo.getText().toString();
        Log.e(getLocalClassName(),"Nombre es "+nom +"\ncorreo es "+men+"\n mensaje "+txtmensaje.getText());

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
             co="viracami3@gmail.com";
             pass="123456789victor";
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

            try {

                session=Session.getDefaultInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(co,pass);
                    }
                });



        if (session!=null){
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(co));//emisor
            message.setSubject(nom);
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(correo));
            message.setContent(men,"text/html;charset=utf-8");

            Transport.send(message);
        }

            }catch (Exception e){
                e.printStackTrace();
              //  Log.e(getLocalClassName(),e+"");

            }
    }
}
