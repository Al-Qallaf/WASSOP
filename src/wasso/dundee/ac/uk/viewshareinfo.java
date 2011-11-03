package wasso.dundee.ac.uk;


import android.app.Activity;
import android.app.Dialog;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;

public class viewshareinfo extends Activity{

	//Integer test = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) throws SQLException{
		// TODO Auto-generated method stub
		try {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shareinfo);
	
		sqldb info = new sqldb(this);
		info.open();
		String[][] data = new String[5][4];
		data=info.getDataFromDB();
		info.close();
		//tv.setText(data[0][0] + " " + data[0][1] + " " + data[0][2]);
		TextView row1 = (TextView) findViewById(R.id.row11);
		row1.setText(data[0][1]);
		TextView row11 = (TextView) findViewById(R.id.row12);
		row11.setText(data[0][3]);
		//row11.setText("null");
		TextView row111 = (TextView) findViewById(R.id.row13);
		row111.setText(data[0][2]);
		TextView row1111 = (TextView) findViewById(R.id.row14);
		Integer fnumber = (Integer.parseInt(data[0][2]) * Integer.parseInt(data[0][3]));
		row1111.setText(fnumber.toString());
		
		TextView row2 = (TextView) findViewById(R.id.row21);
		row2.setText(data[1][1]);
		TextView row22 = (TextView) findViewById(R.id.row22);
		row22.setText(data[1][3]); //Price
		//row22.setText("null");
		TextView row222 = (TextView) findViewById(R.id.row23);
		row222.setText(data[1][2]);
		
		TextView row3 = (TextView) findViewById(R.id.row31);
		row3.setText(data[2][1]);
		TextView row33 = (TextView) findViewById(R.id.row32);
		row33.setText(data[2][3]);
		//row33.setText("null");
		TextView row333 = (TextView) findViewById(R.id.row33);
		row333.setText(data[2][2]);
		
		TextView row4 = (TextView) findViewById(R.id.row41);
		row4.setText(data[3][1]);
		TextView row44 = (TextView) findViewById(R.id.row42);
		row44.setText(data[3][3]);
		//row44.setText("null");
		TextView row444 = (TextView) findViewById(R.id.row43);
		row444.setText(data[3][2]);
		
		TextView row5 = (TextView) findViewById(R.id.row51);
		row5.setText(data[4][1]);
		TextView row55 = (TextView) findViewById(R.id.row52);
		row55.setText(data[4][3]);
		//row55.setText("null");
		TextView row555 = (TextView) findViewById(R.id.row53);
		row555.setText(data[4][2]);
		
		if (fnumber>500)
		{
			TableRow tr1 = (TableRow) findViewById(R.id.trow1);
			tr1.setBackgroundColor(Color.BLUE);
		}
		
		}
	
		catch (Exception e)
		{
			Dialog TheD = new Dialog(this);
			TextView tview = new TextView(this);
			tview.setText(e.getMessage());
			//tv.setText("Here");
			TheD.setContentView(tview);
			TheD.show();
		}
	}
	
}
