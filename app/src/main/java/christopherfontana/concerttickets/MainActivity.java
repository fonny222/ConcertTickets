package christopherfontana.concerttickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicket = 79.99;
    int numberOfTickets;
    double totalCost;
    String groupChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this takes the info typed into the txtTickets field stores them in varible tickets
        final EditText tickets = (EditText)findViewById(R.id.txtTickets);

        // this assigns selection made from the spinner control and assigns it to varible named group
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);

        // initialize the button control
        Button cost = (Button)findViewById(R.id.btnCost);

        // code button listener that awaits user interaction
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v) {

                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = costPerTicket*numberOfTickets;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Cost for "+groupChoice+" is " + currency.format(totalCost));
            }
        });

    }
}
