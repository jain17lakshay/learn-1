package com.example.hp.wfirst;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity22 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
    }
 int i=0,j,f;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       int l=0;
        EditText name=(EditText) findViewById(R.id.ty);
       String b=name.getText().toString();
         l=(i*(5+j+f));
        String t= "thank you\n"+ b +"\n"+"your total is "+l ;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "mail for" +b);
        intent.putExtra(Intent.EXTRA_TEXT,t);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
       // displayMessage(t );



    }
    public void add(View view) {
        i++;
        display(i);

    }
    public void sub(View view) {
        i--;
        if(i<0)
            i++;
        display(i);

    }
  public void tick(View view)
  {
      boolean c=((CheckBox) view).isChecked();
      switch (view.getId())
      {
          case R.id.cream:
              if(c)
              {
                  j=50;
              }
               else j=0;
              break;
          case R.id.choco:
              if(c)
                  f=60;
              else
                  f=0;
      }

  }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.q);
        quantityTextView.setText(""+number);

    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.er);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.er);
        priceTextView.setText(message);
    }

}