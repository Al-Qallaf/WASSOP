package wasso.dundee.ac.uk;


import android.app.Activity;
import android.app.Dialog;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;

public class viewsalerts extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) throws SQLException{
		// TODO Auto-generated method stub
		try {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharealerts);
	
		sqldb info = new sqldb(this);
		info.open();
		String[][] data = new String[5][4];
		data=info.getDataFromDB();
		info.close();
		TextView row1 = (TextView) findViewById(R.id.row11);
		//row1.setText(data[2][3]);
		TextView row2 = (TextView) findViewById(R.id.row21);
		TextView row3 = (TextView) findViewById(R.id.row31);
		TextView row4 = (TextView) findViewById(R.id.row41);
		TextView row5 = (TextView) findViewById(R.id.row51);
		TextView row6 = (TextView) findViewById(R.id.row61);
		int fnumber=500;
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
