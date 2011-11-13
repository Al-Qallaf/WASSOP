package wasso.dundee.ac.uk;




import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShareSystemActivity extends Activity implements OnClickListener {

	Button BsqlUpdate, BsqlView, BsqlModify, BsqlGetInfo, BsqlDelete;
	EditText EditsqlName, EditsqlUnit, EditsqlPrice, EditsqlRow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shares);
		BsqlUpdate = (Button) findViewById(R.id.buttonUpdate);
		EditsqlName = (EditText) findViewById(R.id.EditName);
		EditsqlUnit = (EditText) findViewById(R.id.EditUnit);
		EditsqlPrice = (EditText) findViewById(R.id.EditPrice);
		BsqlView = (Button) findViewById(R.id.buttonopenView);
		BsqlView.setOnClickListener(this);
		BsqlUpdate.setOnClickListener(this);
		EditsqlRow = (EditText) findViewById(R.id.EditrowInfo);
		BsqlModify = (Button) findViewById(R.id.buttonmodify);
		BsqlGetInfo = (Button) findViewById(R.id.buttongetInfo);
		BsqlDelete = (Button) findViewById(R.id.buttondelete);
		BsqlDelete.setOnClickListener(this);
		BsqlModify.setOnClickListener(this);
		BsqlGetInfo.setOnClickListener(this);

	}

	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.buttonUpdate:

			boolean Worked = true;
			try {
				String name = EditsqlName.getText().toString();
				String unit = EditsqlUnit.getText().toString();
				String week_price = EditsqlPrice.getText().toString();
				//if (week_price == "null")
				//	week_price="NoDataAvai";
				//if (Double.parseDouble(week_price) >= (1000000)) // if it is char are you sure it can be parsing?  
				//	week_price="Error:highValue";
				//if (Double.parseDouble(week_price) <= (-1))   
				//	week_price="Error:LowValue";
				sqldb entry = new sqldb(ShareSystemActivity.this);
				entry.open();
				entry.createEntry(name, unit, week_price);
				entry.close();

			} catch (Exception e) {
				Worked = false;
				String whatistheerror = e.toString();
				Dialog TheD = new Dialog(this);
				TheD.setTitle("NoOoOo");
				TextView tv = new TextView(this);
				tv.setText(whatistheerror);
				TheD.setContentView(tv);
				TheD.show();
			} finally {
				if (Worked) {
					Dialog TheGoodD = new Dialog(this);
					TheGoodD.setTitle("Perfect");
					TextView tv = new TextView(this);
					tv.setText("Success");
					TheGoodD.setContentView(tv);
					TheGoodD.show();
				}
			}
			break;
			
		case R.id.buttonopenView:
			Intent i = new Intent("wasso.dundee.ac.uk.viewtotal");
			startActivity(i);
			break;
		case R.id.buttongetInfo:
			try {
				String s = EditsqlRow.getText().toString();
				long l = Long.parseLong(s);
				sqldb hon = new sqldb(this);
				hon.open();
				String returnedName = hon.getNameFromDB(l);
				String returnedUnit = hon.getUnitFromDB(l);
				String returnedPrice = hon.getPriceFromDB(l);
				hon.close();

				EditsqlName.setText(returnedName);
				EditsqlUnit.setText(returnedUnit);
				EditsqlPrice.setText(returnedPrice);
			} catch (Exception e) {

				String WhatIsTheerror = e.toString();
				Dialog TheD = new Dialog(this);
				TheD.setTitle("Errrrr");
				TextView tv = new TextView(this);
				tv.setText(WhatIsTheerror);
				TheD.setContentView(tv);
				TheD.show();
			}
			break;

		case R.id.buttonmodify:
			try {
				String mName = EditsqlName.getText().toString();
				String mUnit = EditsqlUnit.getText().toString();
				String rPrice = EditsqlPrice.getText().toString();
				String sRow = EditsqlRow.getText().toString();
				long lRow = Long.parseLong(sRow);
				boolean isitnum=false;
				
				if(rPrice.isEmpty())
				{
					rPrice=("0000");
				}
				else
				{
				
					for (int i1 = 1; i1 < rPrice.length(); i1++) 
					{
			        //If we find a non-digit character we return false.
						if (!Character.isDigit(rPrice.charAt(i1)))
							isitnum = true;
					}
					if (isitnum == false)
						{
							Dialog TheDd = new Dialog(this);
							TheDd.setTitle("Dash");
							TheDd.show();
							if (Double.parseDouble(rPrice) >= 1000000)
							{
								
								rPrice="000";
								Dialog TheD = new Dialog(this);
								TheD.setTitle(rPrice);
								TheD.show();
							}
							else
							if (Double.parseDouble(rPrice) <= (-1))
							{
								rPrice="00";
								Dialog TheD = new Dialog(this);
								TheD.setTitle(rPrice);
								TheD.show();
							}

						}
				}
				sqldb ex = new sqldb(this);
				ex.open();
				ex.updateEntryInDB(lRow, mName, mUnit, rPrice);
				ex.close();
			} catch (Exception e) {
				String TheBaderror = e.toString();
				Dialog TheD = new Dialog(this);
				TheD.setTitle(e.getLocalizedMessage());
				TextView tv = new TextView(this);
				tv.setText(TheBaderror);
				TheD.setContentView(tv);
				TheD.show();
			}
			break;
		case R.id.buttondelete:
			try {
				String sRow1 = EditsqlRow.getText().toString();
				long lRow1 = Long.parseLong(sRow1);
				sqldb ex1 = new sqldb(this);
				ex1.open();
				ex1.deleteEntryInDB(lRow1);
				ex1.close();
			} catch (Exception e) {
				
				String TheBaderror = e.toString();
				Dialog TheD = new Dialog(this);
				TheD.setTitle("Errrrrr");
				TextView tv = new TextView(this);
				tv.setText(TheBaderror);
				TheD.setContentView(tv);
				TheD.show();
			}
			break;

		}
	}
}
