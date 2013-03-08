package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.text.DecimalFormat;

public class TipCalculatorActivity extends Activity {
	
	private EditText editText;
	private CheckBox checkBox;
	private TextView textView;
	public final double tipPercentage = 12.0;
	public final int numOfDigits = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.edtBillAmount);
		checkBox = (CheckBox) findViewById(R.id.chkRound);
		textView = (TextView) findViewById(R.id.txtTipResult);
	}
	
	public void calculateTip(View view) {
		String text = editText.getText().toString();
		double billAmount = Double.parseDouble(text);
		double tip = billAmount * tipPercentage / 100.0;
		boolean round = checkBox.isChecked();
		if(round) {
			int roundedTip = (int) Math.round(tip);
			textView.setText("Tip: $" + Integer.toString(roundedTip));
		}
		else {
    		DecimalFormat twoDForm = new DecimalFormat("#.##");
    		twoDForm.setMinimumFractionDigits(numOfDigits);
    		textView.setText("Tip: $" + twoDForm.format(tip));
		}
	}

}
