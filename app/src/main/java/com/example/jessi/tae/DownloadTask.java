package com.example.jessi.tae;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask {

    private static final String TAG = "Proceso descarga";
    private Context context;

    private String downloadUrl = "", downloadFileName = "";
    private ProgressDialog progressDialog;

    public DownloadTask(Context context, String downloadUrl) {
        this.context = context;

        this.downloadUrl = downloadUrl;


        downloadFileName = downloadUrl.substring(downloadUrl.lastIndexOf('/'), downloadUrl.length());//Create file name by picking download file name from URL
        Log.e(TAG, downloadFileName);

        //Start Downloading Task
        new DownloadingTask().execute();
    }

    private class DownloadingTask extends AsyncTask<Void, Void, Void> {

        File apkStorage = null;
        File outputFile = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Descargando...");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void result) {
            try {
                if (outputFile != null) {
                    progressDialog.dismiss();
                    Toast.makeText(context, "Descarga realizada correctamente.", Toast.LENGTH_SHORT).show();
                } else {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }, 3000);

                    Log.e(TAG, "Descarga fallida.");

                }
            } catch (Exception e) {
                e.printStackTrace();

                //Change button text if exception occurs

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 3000);
                Log.e(TAG, "Descarga falida con error - " + e.getLocalizedMessage());

            }


            super.onPostExecute(result);
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                URL url = new URL(downloadUrl.trim());//Create Download URl
                HttpURLConnection c = (HttpURLConnection) url.openConnection();//Open Url Connection
                c.setRequestMethod("GET");//Set Request Method to "GET" since we are grtting data
                c.setDoOutput(true);
                c.connect();//connect the URL Connection

                //If Connection response is not OK then show Logs
                /*if (c.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    Log.e(TAG, "Server returned HTTP " + c.getResponseCode()
                            + " " + c.getResponseMessage());

                }*/


                //Get File if SD card is present
                if (new CheckForSDCard().isSDCardPresent()) {

                    apkStorage = new File(
                            Environment.getExternalStorageDirectory() + "/"
                                    + "TAE");
                } else
                    Toast.makeText(context, "Oops!! No hay SD Card.", Toast.LENGTH_SHORT).show();

                //If File is not present create directory
                if (!apkStorage.exists()) {
                    apkStorage.mkdir();
                    Log.e(TAG, "Directorio creado.");
                }

                outputFile = new File(apkStorage, downloadFileName);//Create Output file in Main File

                //Create New File if not present
                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                    Log.e(TAG, "Archivo creado.");
                }

                FileOutputStream fos = new FileOutputStream(outputFile);//Get OutputStream for NewFile Location

                InputStream is = c.getInputStream();//Get InputStream for connection

                byte[] buffer = new byte[1024];//Set buffer type
                int len1 = 0;//init length
                while ((len1 = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len1);//Write new file
                }
/*
                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                String url2 = Environment.getExternalStorageDirectory() + "content://media/internal/TAE/Reglamento2017.pdf";
                File file = new File(url2); //new File("YOUR_SONG_URI"); // set your audio path
                intent.setDataAndType(Uri.fromFile(file), "pdf/*");

                PendingIntent pIntent = PendingIntent.getActivity(reglamentoActivity.this, 0, intent, 0);

                Notification noti = new Notification.Builder(reglamentoActivity.this) //NotificationCompat.Builder(this)
                        .setContentTitle("Descarga completada")
                        .setContentText("Reglamento 2017")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentIntent(pIntent).build();

                noti.flags |= Notification.FLAG_AUTO_CANCEL;

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, noti);
*/
                //Close all connection after doing task
                fos.close();
                is.close();

            } catch (Exception e) {

                //Read exception if something went wrong
                e.printStackTrace();
                outputFile = null;
                Log.e(TAG, "Descarga con error: " + e.getMessage());
            }

            return null;
        }
    }
}