package intents.example.net.intents;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Botones y listeners
        Button botonWeb = (Button) findViewById(R.id.botonweb);
        botonWeb.setOnClickListener(this);

        Button botonLlamada = (Button) findViewById(R.id.botonllamada);
        botonLlamada.setOnClickListener(this);

        Button botonMaps = (Button) findViewById(R.id.botongoogle);
        botonMaps.setOnClickListener(this);

        Button botonFoto = (Button) findViewById(R.id.botonfoto);
        botonFoto.setOnClickListener(this);

        Button botonCorreo = (Button) findViewById(R.id.botoncorreo);
        botonCorreo.setOnClickListener(this);

        Button botonBusqueda = (Button) findViewById(R.id.botonbusqueda);
        botonBusqueda.setOnClickListener(this);

        Button botonDialer = (Button) findViewById(R.id.botondialer);
        botonDialer.setOnClickListener(this);

        Button botonStreet = (Button) findViewById(R.id.botonstreetview);
        botonStreet.setOnClickListener(this);

        Button botonCompartir =(Button)findViewById(R.id.botoncompartir);
        botonCompartir.setOnClickListener(this);
    }

    public void pgWeb(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://campus.somtic.net/"));
        startActivity(intent);
    }
    public void llamadaTelefono(View view) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.checkSelfPermission(
                    Manifest.permission.CALL_PHONE) ==
                    PackageManager.PERMISSION_GRANTED) {
                Intent intent =
                        new Intent(Intent.ACTION_CALL,Uri.parse(
                                "tel:966870700"));
                startActivity(intent);
            }
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL,
                    Uri.parse("tel:966870700"));
            startActivity(intent);
        }
    }
    public void googleMaps(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("geo:38.553468,-0.121579"));
        startActivity(intent);
    }
    public void hacerFoto(View view) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }
    public void mandarCorreo(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "asunto");
        intent.putExtra(Intent.EXTRA_TEXT, "texto del correo");
        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[] {"smira@iesperemaria.com" });
        startActivity(intent);
    }
    //Practica 3.27
    public void busquedaWeb(View view){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY , "IES Peremaria");
        startActivity(intent);
    }

    public void dialerTelefono(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:966870700"));
        startActivity(intent);
    }

    public void StreetView(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("google.streetview:cbll=38.553468,-0.121579"));
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void CompartirCon(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Compartido desde IES Pere Maria Orts");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,"Compartir con ..."));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.botonweb:
                pgWeb(view);
                break;
            case R.id.botonllamada:
                llamadaTelefono(view);
                break;
            case R.id.botongoogle:
                googleMaps(view);
                break;
            case R.id.botonfoto:
                hacerFoto(view);
                break;
            case R.id.botoncorreo:
                mandarCorreo(view);
                break;
            case R.id.botonbusqueda:
                busquedaWeb(view);
                break;
            case R.id.botondialer:
                dialerTelefono(view);
                break;
            case R.id.botonstreetview:
                StreetView(view);
                break;
            case R.id.botoncompartir:
                CompartirCon(view);
                break;
        }
    }
}
