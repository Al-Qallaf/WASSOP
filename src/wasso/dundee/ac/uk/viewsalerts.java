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
		String[][] data = new String[5][5];
		data=info.getDataFromDB();
		info.close();
		
		TextView row1 = (TextView) findViewById(R.id.row11);
		TextView row2 = (TextView) findViewById(R.id.row21);
		TextView row3 = (TextView) findViewById(R.id.row31);
		TextView row4 = (TextView) findViewById(R.id.row41);
		TextView row5 = (TextView) findViewById(R.id.row51);
		TextView row6 = (TextView) findViewById(R.id.row61);
		int count=0;
		
		for(int i=0; i<6; i++)
		{
			String notice = null;
			
			float percentage = ((Float.parseFloat(data[i][3]) - Float.parseFloat(data[i][4]))/Float.parseFloat(data[i][4]))*100;
			if(percentage >= 10)
			{
				notice = "Rocket";
			}
			else if (percentage <= -20)
			{
				notice = "Plummet";
			}
			
			
			if (((notice=="Rocket")||(notice=="Plummet")) && (count == 0))
			{
				TableRow tr1 = (TableRow) findViewById(R.id.trow1);
				if(notice == "Rocket")
				{
					tr1.setBackgroundColor(Color.GREEN);
				}
				else
				{
					tr1.setBackgroundColor(Color.RED);
				}
				row1.setText(notice);
				count++;
				continue;
			}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==1))
			{
				TableRow tr2 = (TableRow) findViewById(R.id.trow2);
				if(notice == "Rocket")
				{
					tr2.setBackgroundColor(Color.GREEN);
				}
				else
				{
					tr2.setBackgroundColor(Color.RED);
				}				row2.setText(notice);
				count++;
				continue;
			}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==2))
			{
				TableRow tr3 = (TableRow) findViewById(R.id.trow3);
				if(notice == "Rocket")
				{
					tr3.setBackgroundColor(Color.GREEN);
				}
				else
				{
					tr3.setBackgroundColor(Color.RED);
				}
				row3.setText(notice);
				count++;
				continue;
			}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==3))
			{
				TableRow tr4 = (TableRow) findViewById(R.id.trow4);
				if(notice == "Rocket")
				{
					tr4.setBackgroundColor(Color.GREEN);
				}
				else
				{
					tr4.setBackgroundColor(Color.RED);
				}
				row4.setText(notice);
				count++;
				continue;
			}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==4))
			{
				TableRow tr5 = (TableRow) findViewById(R.id.trow5);
				if(notice == "Rocket")
				{
					tr5.setBackgroundColor(Color.GREEN);
				}
				else
				{
					tr5.setBackgroundColor(Color.RED);
				}
				row5.setText(notice);
				count++;
				continue;
			}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==5))
			{
				TableRow tr6 = (TableRow) findViewById(R.id.trow6);
				if(notice=="Rocket")
				{
					tr6.setBackgroundColor(Color.GREEN);
				}
				else
				{
					tr6.setBackgroundColor(Color.RED);
				}
				row6.setText(notice);
				count++;
				continue;
			}
		}
		
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
