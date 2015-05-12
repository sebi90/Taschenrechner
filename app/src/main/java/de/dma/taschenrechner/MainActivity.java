package de.dma.taschenrechner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends Activity {

    TextView textView;
    String text;
    String result;
    Character lastItem;
    Button button, clearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView1);
        clearButton = (Button) findViewById(R.id.buttonClear);
        clearButton.setOnLongClickListener(new View.OnLongClickListener()
        {

            @Override
            public boolean onLongClick(View v) {
                textView.setText("");
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void buttonOnClick(View view)
    {
        switch (view.getId()){
            case R.id.buttonClear:
                text = (String) textView.getText();
                if(text.length() != 0)
                {
                    result = text.substring(0 , text.length() -1);
                    textView.setText(result);
                }
                break;

            case R.id.buttonEval:
                Expression e = new ExpressionBuilder(textView.getText().toString()).build();
                double result = e.evaluate();
                textView.setText(result + "");
                break;

            case R.id.buttonPlusMinus:
                text = (String) textView.getText();
                if(text.length() != 0)
                {
                    if(!text.substring(0,1).equals("-")) {
                        textView.setText("-" + "" + text);
                    }
                    else
                    {
                        textView.setText(text.substring(1,textView.length()));
                    }
                }
                break;

            case R.id.buttonComma:
                text = (String) textView.getText();
                if (text.length() != 0 && check(text.substring(text.length() - 1, text.length()))) {
                    Toast.makeText(getApplicationContext(), "ungültige Eingabe", Toast.LENGTH_SHORT).show();
                } else {
                    textView.setText(text + ".");
                }
                break;

            case R.id.buttonPlus:
                text = (String) textView.getText();
                if (text.length() != 0 && check(text.substring(text.length() - 1, text.length()))) {
                    Toast.makeText(getApplicationContext(), "ungültige Eingabe", Toast.LENGTH_SHORT).show();
                } else {
                    textView.setText(text + "+");
                }
                break;

            case R.id.buttonMinus:
                text = (String) textView.getText();
                if (text.length() != 0 && check(text.substring(text.length() - 1, text.length()))) {
                    Toast.makeText(getApplicationContext(), "ungültige Eingabe", Toast.LENGTH_SHORT).show();
                } else {
                    textView.setText(text + "-");
                }
                break;

            case R.id.buttonMultiply:
                text = (String) textView.getText();
                if (text.length() != 0 && check(text.substring(text.length() - 1, text.length()))) {
                    Toast.makeText(getApplicationContext(), "ungültige Eingabe", Toast.LENGTH_SHORT).show();
                } else {
                    textView.setText(text + "*");
                }
                break;

            case R.id.buttonDivide:
                text = (String) textView.getText();
                if (text.length() != 0 && check(text.substring(text.length() - 1, text.length()))) {
                    Toast.makeText(getApplicationContext(), "ungültige Eingabe", Toast.LENGTH_SHORT).show();
                } else {
                    textView.setText(text + "/");
                }
                break;

            default:
                button = (Button) view;
                text = (String) textView.getText();
                textView.setText(textView.getText() + "" + button.getText());
                //Toast.makeText(getApplicationContext(), , Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public boolean check(String input)
    {
        if(input.equals("/") || input.equals("*")|| input.equals("-")|| input.equals("+")|| input.equals("."))
        {
            return true;
        }
        else
        {
            return false;
        }

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
