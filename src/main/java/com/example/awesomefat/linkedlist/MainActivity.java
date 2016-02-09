package com.example.awesomefat.linkedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    private Button addFrontButton;
    private Button addEndButton;
    private Button removeFrontButton;
    private Button removeEndButton;
    private EditText newValueEditText;
    private LinkedList ll;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        //give ourselves programmatic access to the buttons and edit text
        this.addFrontButton = (Button)this.findViewById(R.id.addFrontButton);
        this.addEndButton = (Button)this.findViewById(R.id.addEndButton);
        this.removeFrontButton = (Button)this.findViewById(R.id.removeFrontButton);
        this.removeEndButton = (Button)this.findViewById(R.id.removeEndButton);
        this.newValueEditText = (EditText)this.findViewById(R.id.newValueET);

        ListCore.inflater = this.getLayoutInflater();

        LinearLayout svLL = (LinearLayout)this.findViewById(R.id.scrollViewLL);
        ll = new LinkedList(svLL);
        ll.addFront("1");
        ll.addFront("2");
        ll.addFront("3");
        ll.addFront("4");
        ll.display();

        ll.addEnd("6");
        ll.addEnd("7");
        ll.addEnd("8");
        ll.display();


        /*
        View v;
        for(int i = 0; i < 10; i++)
        {
            v = this.getLayoutInflater().inflate(R.layout.node, null);
            TextView tf = (TextView) v.findViewById(R.id.theValueTF);
            tf.setText("" + i);
            svLL.addView(v);
        }
        */
    }

    public void aButtonClicked(View sender)
    {
        if(sender == this.addFrontButton)
        {
            ll.addFront("" + this.newValueEditText.getText());
        }
        else if(sender == this.addEndButton)
        {
            ll.addEnd("" + this.newValueEditText.getText());
        }
        else if(sender == this.removeFrontButton)
        {
            ll.removeFront();
        }
        else if(sender == this.removeEndButton)
        {
            ll.removeEnd();
        }
        ll.display();

    }

}
