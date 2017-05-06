/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */
package com.example.jeevakarthik.justjava;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnKeyListener;
import android.os.Bundle;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.text.NumberFormat;

import static com.example.jeevakarthik.justjava.R.id.whipcream;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    //global variables
    int quantity=0;
    String msg="Thank You";
    String myName="";
    EditText text;
    CheckBox whipcream;
    CheckBox chocolatecream;
    int price=0;
    int basePrice=5;
    Context c;
    String[] str={"jeevakarthik1993@rediffmail.com"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       displayMsg(msg,quantity);
       display(quantity);




    }

    private void composeMail(String[] str,String s,String msg) {
        //implements intent to send mail
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailTo:"));
        intent.putExtra(Intent.EXTRA_EMAIL,str);
        intent.putExtra(Intent.EXTRA_SUBJECT,s);
        intent.putExtra(Intent.EXTRA_TEXT,msg);

        intent.setType("message/rfc822");
        startActivity( Intent.createChooser(intent,"Email"));



       }


    private void displayMsg(String msg,int quantity) {
        TextView q=(TextView) findViewById(R.id.order_summary_text_view);
        text=(EditText) findViewById(R.id.name_text_view);
        myName= text.getText().toString();

      whipcream=(CheckBox)findViewById(R.id.whipcream);
      chocolatecream=(CheckBox)findViewById(R.id.choclatecream);
       if(whipcream.isChecked()&& chocolatecream.isChecked())
       {

           price=(basePrice+1+2)*quantity;

       }

       else if(chocolatecream.isChecked()&&!(whipcream.isChecked()))
       {

           price=(basePrice+2)*quantity;
       }
       else if(!(chocolatecream.isChecked())&& (whipcream.isChecked()))
       {

           price=(basePrice+1)*quantity;
       }

       else
       {
           price=basePrice*quantity;
       }

     msg="name:"+myName+"\n"+"Quantity:"+quantity+"\n"+"price:"+price+"\n"+"thank you";
//       q.setText(""+msg);

        //sends email
        composeMail(str,"Thanks for the order",msg);


    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private int display(int s) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if(s>100){
            Toast.makeText(getApplicationContext(), "cannot order more than 100 cups",Toast.LENGTH_SHORT).show();

        }
        else if(s<1)
        {
            Toast.makeText(getApplicationContext(), "cannot order less than 1 cup",Toast.LENGTH_SHORT).show();
        }

            quantityTextView.setText("" + s);
            return s;

    }

    /**
     * This method displays the given price on the screen.
     */
   /* private void displayPriceandMsg(String msg,int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number)+" "+msg);
    }*/

//decrements the order by 1
    public void decrement(View view) {

        quantity=quantity-1;
            display(quantity);
        /*TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if(R.id.quantity_text_view<1){
            Toast.makeText(getApplicationContext(), "cannot order less than 1 cups",Toast.LENGTH_SHORT).show();
        }*/



    }
//increments by 1
    public void increment(View view) {

        quantity=quantity+1;
        display(quantity);

       /* TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if(R.id.quantity_text_view>100){
            Toast.makeText(getApplicationContext(), "cannot order more than 100 cups",Toast.LENGTH_SHORT).show();
        }*/

    }


}