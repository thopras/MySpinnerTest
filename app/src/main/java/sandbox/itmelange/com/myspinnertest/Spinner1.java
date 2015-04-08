package sandbox.itmelange.com.myspinnertest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class Spinner1 extends ActionBarActivity {

    String[] DayOfWeek = {"Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday", "Select One..." };

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner1);

        Spinner mySpinner = (Spinner)findViewById(R.id.spinner1);
        this.adapter = new ArrayAdapter<String>(this,
                R.layout.row, R.id.weekofday, DayOfWeek);
        mySpinner.setAdapter(adapter);
        mySpinner.setSelection(DayOfWeek.length-1);

        Spinner mySpinner2 = (Spinner)findViewById(R.id.spinner2);
        mySpinner2.setAdapter(adapter);
        mySpinner2.setSelection(-1);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setPrompt("Select your favorite Planet!");
        spinner3.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapter,
                        R.layout.contact_spinner_row_nothing_selected,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        this));

    }

    public void onButtonClick(View w) {

        new AlertDialog.Builder(this)
                .setTitle("the prompt")
                .setAdapter(adapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // TODO: ev. Prüfung, ob which gültiger Index ist
                        Button button = (Button)findViewById(R.id.button);
                        button.setText(DayOfWeek[which]);

                        dialog.dismiss();
                    }
                }).create().show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spinner1, menu);
        return true;
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


//    /**
//     * Spinner item selected
//     *
//     * @param parent
//     * @param view
//     * @param pos
//     * @param id
//     */
//    public void onItemSelected(AdapterView<?> parent, View view,
//                               int pos, long id) {
//        // An item was selected. You can retrieve the selected item using
//        // parent.getItemAtPosition(pos)
//    }
//
//    /**
//     * Spinner nothing selected
//     * @param parent
//     */
//    public void onNothingSelected(AdapterView<?> parent) {
//        // Another interface callback
//    }
}
