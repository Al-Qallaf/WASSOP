package wasso.dundee.ac.uk;


import android.app.Activity;
import android.app.Dialog;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;

public class viewsalerts extends Activity{
	
	int count; 
	@Override
	protected void onCreate(Bundle savedInstanceState) throws SQLException{
		try {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharealerts);
	
		sqldb info = new sqldb(this);
		info.open();
		String[][] data = new String[5][5];
		data=info.getDataFromDB();
		info.close();
		TableRow trow1 = (TableRow) findViewById(R.id.trow1);
		TableRow trow2 = (TableRow) findViewById(R.id.trow2);
		TableRow trow3 = (TableRow) findViewById(R.id.trow3);
		TableRow trow4 = (TableRow) findViewById(R.id.trow4);
		TableRow trow5 = (TableRow) findViewById(R.id.trow5);
		TableRow trow6 = (TableRow) findViewById(R.id.trow6);
		TableRow[] Tablerows = new TableRow[]{ trow1, trow2, trow3, trow4, trow5, trow6};
		
		TextView row1 = (TextView) findViewById(R.id.row11);
		TextView row2 = (TextView) findViewById(R.id.row21);
		TextView row3 = (TextView) findViewById(R.id.row31);
		TextView row4 = (TextView) findViewById(R.id.row41);
		TextView row5 = (TextView) findViewById(R.id.row51);
		TextView row6 = (TextView) findViewById(R.id.row61);
		count=0;
		TextView[] rows = new TextView[]{ row1, row2, row3, row4, row5, row6};
		
		
		for(int i=0; i<6; i++)
		{
			String notice = null;
			
			float percentage = ((Float.parseFloat(data[i][3]) - Float.parseFloat(data[i][4]))/Float.parseFloat(data[i][4]))*100;
			if(percentage >= 10)
				{
					notice = "Rocket";
				}
			else 
				if (percentage <= -20)
					{
						notice = "Plummet";
					}
			
			
			if (((notice=="Rocket")||(notice=="Plummet")) && (count == 0))
				{
					row1.setText(data[i][1]+" :   "+ notice);
					count++;
					continue;
				}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==1))
				{
					row2.setText(data[i][1]+" :   "+ notice);
					count++;
					continue;
				}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==2))
				{
					row3.setText(data[i][1]+" :   "+ notice);
					count++;
					continue;
				}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==3))
				{
					row4.setText(data[i][1]+" :   "+ notice);
					count++;
					continue;
				}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==4))
				{
					row5.setText(data[i][1]+" :   "+ notice);
					count++;
					continue;
				}
			if (((notice=="Rocket")||(notice=="Plummet"))&&(count==5))
				{
					row6.setText(data[i][1]+" :   "+ notice);
					count++;
					continue;
				}
		}
		
		for (int i=0;i<count;i++)
		{
			if (rows[i].getText().toString().contains("Rocket"))
				Tablerows[i].setBackgroundColor(Color.GREEN);
			else
				Tablerows[i].setBackgroundColor(Color.RED);
		}
		
		}
		
		catch (Exception e)
		{
			Dialog TheD = new Dialog(this);
			TextView tview = new TextView(this);
			tview.setText(e.getMessage());
			TheD.setContentView(tview);
			TheD.show();
		}
	}
	

	
}
