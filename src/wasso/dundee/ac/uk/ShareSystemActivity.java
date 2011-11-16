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
	EditText EditsqlName, EditsqlUnit, EditsqlPrice, EditsqllastPrice, EditsqlRow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shares);
		BsqlUpdate = (Button) findViewById(R.id.buttonUpdate);
		EditsqlName = (EditText) findViewById(R.id.EditName);
		EditsqlUnit = (EditText) findViewById(R.id.EditUnit);
		EditsqlPrice = (EditText) findViewById(R.id.EditPrice);
		EditsqllastPrice = (EditText) findViewById(R.id.EditlastPrice);
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
		switch (arg0.getId()) {
		case R.id.buttonUpdate:

			boolean Worked = true;
			try {
				String name = EditsqlName.getText().toString();
				String unit = EditsqlUnit.getText().toString();
				String week_price = EditsqlPrice.getText().toString();
				String last_price = EditsqllastPrice.getText().toString();
				sqldb entry = new sqldb(ShareSystemActivity.this);
				week_price= entry.checkValidety(week_price);
				entry.open();
				entry.createEntry(name, unit, week_price,last_price);
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
				String returnedLPrice = hon.getLPriceFromDB(l);
				hon.close();

				EditsqlName.setText(returnedName);
				EditsqlUnit.setText(returnedUnit);
				EditsqlPrice.setText(returnedPrice);
				EditsqllastPrice.setText(returnedLPrice);
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
				String lPrice = EditsqllastPrice.getText().toString();
				String sRow = EditsqlRow.getText().toString();
				long lRow = Long.parseLong(sRow);
				sqldb ex = new sqldb(this);
				rPrice=ex.checkValidety(rPrice);
				ex.open();
				ex.updateEntryInDB(lRow, mName, mUnit, rPrice, lPrice);
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
				TheD.setTitle("Error When Deleting");
				TextView tv = new TextView(this);
				tv.setText(TheBaderror);
				TheD.setContentView(tv);
				TheD.show();
			}
			break;

		}
	}
}
