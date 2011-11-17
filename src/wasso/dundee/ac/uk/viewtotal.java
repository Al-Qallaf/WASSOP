package wasso.dundee.ac.uk;


import android.app.Activity;
import android.app.Dialog;
import android.database.SQLException;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableRow;
import android.widget.TextView;

public class viewtotal extends Activity{

    //Integer test = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) throws SQLException{
        // TODO Auto-generated method stub
        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total);
    
     
        sqldb info = new sqldb(this);
        
        
        //info.open();
        //info.updatewithfeed();
        //info.close();
      
        info.open();
        String[][] data = new String[6][4];
        data=info.getDataFromDB();
        info.close();
        //tv.setText(data[0][0] + " " + data[0][1] + " " + data[0][2]);
        //==========================1=====================================
        //==========================1=====================================
        TextView row1 = (TextView) findViewById(R.id.row11);
        row1.setText(data[0][1]);
        TextView row11 = (TextView) findViewById(R.id.row12);
        String fnumber1 = calcTotalWorth(data[0][2], data[0][3]);
        row11.setText(fnumber1.toString());
        Float worth11 = Float.parseFloat(fnumber1); 
        //row11.setText(data[0][3]);
		if (data[0][3].equals("00") || data[0][3].equals("000") || data[0][3].equals("0000") ) 
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR1);
			tr1.setBackgroundColor(Color.RED);
			if (data[0][3].equals("00"))
			{
				row11.setText("LowValue");
			}
			if (data[0][3].equals("000"))
			{
				row11.setText("HighValue");
			}
			if (data[0][3].equals("0000"))
			{
				row11.setText("NoValue");
			}
		}
		if (data[0][3].equals("0"))
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR1);
			tr1.setBackgroundColor(Color.parseColor("#FFA500"));
		}
		
        //===========================2====================================
        //===========================2====================================        
        TextView row2 = (TextView) findViewById(R.id.row21);
        row2.setText(data[1][1]);
        TextView row22 = (TextView) findViewById(R.id.row22);
        String fnumber2 = calcTotalWorth(data[1][2], data[1][3]);
        row22.setText(fnumber2.toString());
        Float worth22 = Float.parseFloat(fnumber2);
        //row22.setText(data[1][3]);
        if (data[1][3].equals("00") || data[1][3].equals("000") || data[1][3].equals("0000") ) 
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR2);
			tr1.setBackgroundColor(Color.RED);
			if (data[1][3].equals("00"))
			{
				row22.setText("LowValue");
			}
			if (data[1][3].equals("000"))
			{
				row22.setText("HighValue");
			}
			if (data[1][3].equals("0000"))
			{
				row22.setText("NoValue");
			}

		}
		if (data[1][3].equals("0"))
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR2);
			tr1.setBackgroundColor(Color.parseColor("#FFA500"));
		}
		
        //============================3===================================
        //============================3===================================       
        TextView row3 = (TextView) findViewById(R.id.row31);
        row3.setText(data[2][1]);
        TextView row33 = (TextView) findViewById(R.id.row32);
        String fnumber3 = calcTotalWorth(data[2][2], data[2][3]);
        row33.setText(fnumber3.toString());
        Float worth33 = Float.parseFloat(fnumber3);
        //row33.setText(data[2][3]);
        if (data[2][3].equals("00") || data[2][3].equals("000") || data[2][3].equals("0000") ) 
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR3);
			tr1.setBackgroundColor(Color.RED);
			if (data[2][3].equals("00"))
			{
				row33.setText("LowValue");
			}
			if (data[2][3].equals("000"))
			{
				row33.setText("HighValue");
			}
			if (data[2][3].equals("0000"))
			{
				row33.setText("NoValue");
			}

		}
		if (data[2][3].equals("0"))
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR3);
			tr1.setBackgroundColor(Color.parseColor("#FFA500"));
		}
        //=============================4==================================
        //=============================4==================================        
        TextView row4 = (TextView) findViewById(R.id.row41);
        row4.setText(data[3][1]);
        TextView row44 = (TextView) findViewById(R.id.row42);
        String fnumber4 = calcTotalWorth(data[3][2], data[3][3]);
        row44.setText(fnumber4.toString());
        Float worth44 = Float.parseFloat(fnumber4);
        //row44.setText(data[3][3]);
        if (data[3][3].equals("00") || data[3][3].equals("000") || data[3][3].equals("0000") ) 
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR4);
			tr1.setBackgroundColor(Color.RED);
			if (data[3][3].equals("00"))
			{
				row44.setText("LowValue");
			}
			if (data[3][3].equals("000"))
			{
				row44.setText("HighValue");
			}
			if (data[3][3].equals("0000"))
			{
				row44.setText("NoValue");
			}

		}
		if (data[3][3].equals("0"))
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR4);
			tr1.setBackgroundColor(Color.parseColor("#FFA500"));
		}
        //==============================5=================================
        //==============================5=================================
        TextView row5 = (TextView) findViewById(R.id.row51);
        row5.setText(data[4][1]);
        TextView row55 = (TextView) findViewById(R.id.row52);
        String fnumber5 = calcTotalWorth(data[4][2], data[4][3]);
        row55.setText(fnumber5.toString());
        Float worth55 = Float.parseFloat(fnumber5);
        //row55.setText(data[4][3]);
        if (data[4][3].equals("00") || data[4][3].equals("000") || data[4][3].equals("0000") ) 
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR5);
			tr1.setBackgroundColor(Color.RED);
			if (data[4][3].equals("00"))
			{
				row55.setText("LowValue");
			}
			if (data[4][3].equals("000"))
			{
				row55.setText("HighValue");
			}
			if (data[4][3].equals("0000"))
			{
				row55.setText("NoValue");
			}

		}
		if (data[4][3].equals("0"))
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR5);
			tr1.setBackgroundColor(Color.parseColor("#FFA500"));
		}
        //==============================5=================================
        //==============================5=================================
        TextView row6 = (TextView) findViewById(R.id.row61);
        row6.setText(data[5][1]);
        TextView row66 = (TextView) findViewById(R.id.row62);
        String fnumber6 = calcTotalWorth(data[5][2], data[5][3]);
        row66.setText(fnumber6.toString());
        Float worth66 = Float.parseFloat(fnumber6);
        //row55.setText(data[4][3]);
        if (data[5][3].equals("00") || data[5][3].equals("000") || data[5][3].equals("0000") ) 
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR6);
			tr1.setBackgroundColor(Color.RED);
			if (data[5][3].equals("00"))
			{
				row66.setText("LowValue");
			}
			if (data[5][3].equals("000"))
			{
				row66.setText("HighValue");
			}
			if (data[5][3].equals("0000"))
			{
				row66.setText("NoValue");
			}

		}
		if (data[5][3].equals("0"))
		{
			TableRow tr1 = (TableRow) findViewById(R.id.TR6);
			tr1.setBackgroundColor(Color.parseColor("#FFA500"));
		}
        //===============================================================
        //===============================================================

      //=========================The total======================================
        Float totalWorthValue = (worth11+worth22+worth33+worth44+worth55+worth66);
        TextView totalRow = (TextView) findViewById(R.id.row72);
        totalRow.setText(totalWorthValue.toString());
        }
    
        catch (Exception e)
        {
            Dialog TheD = new Dialog(this);
            TextView tv = new TextView(this);
            tv.setText(e.getMessage());
            //tv.setText("Here");
            TheD.setContentView(tv);
            TheD.show();
        }
    }
    
    
    public String calcTotalWorth(String unit, String price) throws SQLException
    {       
    	if (price.equals("00") || price.equals("000") || price.equals("0000"))
    	{
    		return price;
    	}
    	else
    	{
    		Float res = (Float.parseFloat(unit) * Float.parseFloat(price));
    	    return res.toString();
    	}
    }
}