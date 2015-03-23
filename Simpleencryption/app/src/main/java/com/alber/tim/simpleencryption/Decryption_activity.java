package com.alber.tim.simpleencryption;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Decryption_activity extends ActionBarActivity {
    String text;
    Integer key;
    String decrpted;

    public void decryp (View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editkey = (EditText) findViewById(R.id.editText2);
        TextView textview = (TextView) findViewById(R.id.textView2);
        try{
            text = editText.getText().toString();
            key = Integer.parseInt(editkey.getText().toString());
            decrpted = decrypter(text, key);
            textview.setText(decrpted);
        }
        catch (Exception e){
            Context context = getApplicationContext();
            CharSequence text = "Insert your key please!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
        }
    }

    private static String decrypter(String text,Integer key){
        int len = text.length();
        char[] t = new char[len];
        for (int n = 0; n < len; n++) {
            t[n] = (char)(text.charAt(n) - key);
        }
        return new String(t);
    }

    public void copy(View view){
        ClipboardManager clipboard = (ClipboardManager)
        getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Decoded Text",decrpted);
        clipboard.setPrimaryClip(clip);

        Context context = getApplicationContext();
        CharSequence text = "Decrypted text copied to clipboard!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,text,duration);
        toast.show();
    }

    public void paste(View view){
        String pasteData;
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
        pasteData = item.getText().toString();
        if (pasteData != null) {
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(pasteData);

            Context context = getApplicationContext();
            CharSequence text = "Successfully pasted!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Nothing to paste!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,text,duration);
            toast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption_activity);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
