package com.example.eng3k;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private static ArrayList<Words> allWords;
    private static ArrayList<Words> rememberedWords;
    private Context context;
    String[] value;

    //protected final String apiurl ="http://50e09669da8f.ngrok.io/DB.php";

    //FirebaseDatabase database= FirebaseDatabase.getInstance();
    //DatabaseReference dbref= database.getReference("word");

    public Utils() {

        if(null==allWords){

            allWords=new ArrayList<>();

            initData();
        }
        if (null== rememberedWords){
            rememberedWords=new ArrayList<>();
        }
    }

    private void initData() {
        //Todo: add initial data
            InputStream inputStream;
            inputStream = WordListActivity.mContext.getResources().openRawResource(R.raw.data);
            BufferedReader reader= new BufferedReader(new InputStreamReader(inputStream));
            try{
                String read;
                while ((read =reader.readLine()) !=null){

                    value=read.split(",");
                    try{
                        allWords.add(new Words(0, value[1], "ভালো", "tommy is a good dog"));

                    }catch(Exception e){
                        Log.e("Unknown error", e.toString());
                    }
                }

            }catch (Exception e){

            }
        /*try{
            WorkbookSettings ws= new WorkbookSettings();
            ws.setGCDisabled(true);
            AssetManager am= context.getAssets();
            InputStream is = am.open("data.xls");
            Workbook wb= Workbook.getWorkbook(is);
            Sheet s=wb.getSheet(0);
            int row= s.getRows();
            int col = s.getColumns();
            for(int r=0;r<row;r++){
                for(int c=0; c<col;c++ ){
                    Cell x= s.getCell(c,r);
                    String value=x.getContents();
                    allWords.add(new Words(r, value, "ভালো", "tommy is a good dog"));
                }
            }

        }catch(Exception e){
            Toast.makeText(context,"not found", Toast.LENGTH_LONG).show();


        }*/


        /*// Read from the database
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    String value = dataSnapshot1.getValue(String.class);
                    allWords.add(new Words(1, value, "ভালো", "tommy is a good dog"));
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });*/


        /*allWords.add(new Words(1,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(2,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(3,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(4,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(5,"Good", "ভালো", "tommy is a good dog"));
        allWords.add(new Words(6,"Good", "ভালো", "tommy is a good dog"));
        */
        /*class dbManger extends AsyncTask<String,Void, String> {

            protected void onPostExecute(String data){
                try{
                    JSONArray ja= new JSONArray(data);
                    JSONObject jo= null;
                    for (int i=0; i<ja.length();i++){
                        jo=ja.getJSONObject(i);
                        String name= jo.getString("word");
                        allWords.add(new Words(1,name,"good",""));
                    }

                }catch(Exception ex){
                    Toast.makeText(context,"selected", Toast.LENGTH_SHORT).show();

                }

            }
            @Override
            protected String doInBackground(String... strings){
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer data = new StringBuffer();
                    String line;
                    while((line=br.readLine())!=null){
                        data.append(line+"\n");
                    }
                    br.close();
                    return data.toString();
                }catch (Exception ex){
                    return ex.getMessage();
                }
            }

        }

        dbManger obj= new dbManger();
        obj.execute(apiurl);*/



    }

    public static Utils getInstance() {
        if(null!=instance){
            return instance;
        }else {
            instance=new Utils();
            return instance;
        }

    }

    public static ArrayList<Words> getAllWords() {

        return allWords;
    }

    public static ArrayList<Words> getRememberedWords() {
        return rememberedWords;
    }
}
