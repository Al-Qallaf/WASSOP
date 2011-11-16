package wasso.dundee.ac.uk;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class sqldb {
	
	public static final String ROWID = "theid";
	public static final String CO_NAME = "com_name";
	public static final String SH_UNIT = "share_units";
	public static final String FRIDAY_PRICE = "weekly_price";
	public static final String LA_PRICE = "last_price";
	private static final String MYDB_NAME = "thisallsharesdb";
	private static final String MYDB_TABLE = "thisallsharestable";
	private static final int MYDB_VERSION = 1;
	private DbHelper TheHelper;
	private final Context TheContext;
	private SQLiteDatabase TheDB;
	
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, MYDB_NAME, null, MYDB_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE " + MYDB_TABLE + " (" +
					ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					CO_NAME + " TEXT NOT NULL, " +
					SH_UNIT + " TEXT NOT NULL, " +
					FRIDAY_PRICE + " TEXT NOT NULL, " +
					LA_PRICE + " TEXT NOT NULL);"					
			);	
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + MYDB_TABLE);
			onCreate(db);
		}		
	}
	
	public sqldb(Context c){
		TheContext = c;
	}

	public sqldb open() throws SQLException{
		TheHelper = new DbHelper(TheContext);
		TheDB = TheHelper.getWritableDatabase();
		return this;
	}
	 public void close(){
		 TheHelper.close();
	 }

	public long createEntry(String name, String units, String week_price, String last_price) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(CO_NAME, name);
		cv.put(SH_UNIT, units);
		cv.put(FRIDAY_PRICE, week_price);
		cv.put(LA_PRICE, last_price);
		return TheDB.insert(MYDB_TABLE, null, cv);
	}

	public String[][] getDataFromDB() throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ ROWID, CO_NAME, SH_UNIT, FRIDAY_PRICE};
		Cursor c = TheDB.query(MYDB_TABLE, columns, null, null, null, null, null);
		
		String[][] arrr =  new String[6][4];
		c.moveToFirst();
		for (int i=0; i<6; i++) {
				  arrr[i] [0]= c.getString(0);
				  arrr[i] [1]= c.getString(1);
				  arrr[i] [2]= c.getString(2);
				  arrr[i] [3]= c.getString(3);
				  c.moveToNext();
		}	
		return arrr;
	}
	public String getNameFromDB(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ ROWID, CO_NAME, SH_UNIT};
		Cursor c = TheDB.query(MYDB_TABLE, columns, ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String name = c.getString(1);
			return name;
		}
		return null;
	}

	public String getUnitFromDB(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ ROWID, CO_NAME, SH_UNIT};
		Cursor c = TheDB.query(MYDB_TABLE, columns, ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String theUnit = c.getString(2);
			return theUnit;
		}
		return null;
	}

	public String getPriceFromDB(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ ROWID, CO_NAME, SH_UNIT, FRIDAY_PRICE};
		Cursor c = TheDB.query(MYDB_TABLE, columns, ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String price = c.getString(3);
			return price;
		}
		return null;
	}
	
	public String getLPriceFromDB(long l) throws SQLException{
		// TODO Auto-generated method stub
		String[] columns = new String[]{ ROWID, CO_NAME, SH_UNIT, FRIDAY_PRICE, LA_PRICE};
		Cursor c = TheDB.query(MYDB_TABLE, columns, ROWID + "=" + l, null, null, null, null);
		if (c != null){
			c.moveToFirst();
			String Lprice = c.getString(4);
			return Lprice;
		}
		return null;
	}
	
	public void updateEntryInDB(long lRow, String coName, String sUnit, String fPrice, String lPrice) throws SQLException{
		// TODO Auto-generated method stub
		ContentValues cvUpdate = new ContentValues();
		cvUpdate.put(CO_NAME, coName);
		cvUpdate.put(SH_UNIT, sUnit);
		cvUpdate.put(FRIDAY_PRICE, fPrice);
		cvUpdate.put(LA_PRICE, lPrice);
		TheDB.update(MYDB_TABLE, cvUpdate, ROWID + "=" + lRow, null);	
	}

	public void deleteEntryInDB(long lRow1) throws SQLException{
		// TODO Auto-generated method stub
		TheDB.delete(MYDB_TABLE, ROWID + "=" + lRow1, null);
	}
	
	public void updatewithfeed()throws SQLException
	{
	
		//long lRow;
		ShareFeed currentprice = new ShareFeed();
		ContentValues cvUpdate = new ContentValues();
		for (int i=0;i<7;i++)
		{
			if (i == 1)
			{
				cvUpdate.put(FRIDAY_PRICE, checkValidety(currentprice.getPrice("BLVN").toString()));
				TheDB.update(MYDB_TABLE, cvUpdate, ROWID + "=" + i, null);
			}
			if (i == 2)
			{
				cvUpdate.put(FRIDAY_PRICE, checkValidety(currentprice.getPrice("BP").toString()));
				TheDB.update(MYDB_TABLE, cvUpdate, ROWID + "=" + i, null);
			}
			
			if (i == 3)
			{
				cvUpdate.put(FRIDAY_PRICE, checkValidety(currentprice.getPrice("EXPN").toString()));
				TheDB.update(MYDB_TABLE, cvUpdate, ROWID + "=" + i, null);
			}
			
			if (i == 4)
			{
				cvUpdate.put(FRIDAY_PRICE, checkValidety(currentprice.getPrice("HSBA").toString()));
				TheDB.update(MYDB_TABLE, cvUpdate, ROWID + "=" + i, null);
			}
			if (i == 5)
			{
				cvUpdate.put(FRIDAY_PRICE, checkValidety(currentprice.getPrice("MKS").toString()));
				TheDB.update(MYDB_TABLE, cvUpdate, ROWID + "=" + i, null);
			}
			
			if (i == 6)
			{
				cvUpdate.put(FRIDAY_PRICE, checkValidety(currentprice.getPrice("SN").toString()));
				TheDB.update(MYDB_TABLE, cvUpdate, ROWID + "=" + i, null);
			}
		}
		
		
		//try
		//{
		//String[] myabbriviation = {"BP","HSBA","EXPN","MKS","SN"}; 
		//long lRow;
		//Test currentprice = new Test();
		//ContentValues cvUpdate = new ContentValues();
		//for (int i=0;i<5;i++)
		//{
		//	cvUpdate.put(FRIDAY_PRICE, currentprice.getPrice(myabbriviation[i]));
		//	TheDB.update(MYDB_TABLE, cvUpdate, ROWID + "=" + i, null);	
		//}
		//}
		//catch (Exception e)
		//{
		//    Dialog TheD = new Dialog(TheContext);
         //   TextView tv = new TextView(TheContext);
        //    tv.setText(e.getMessage());
            //tv.setText("Here");
        //    TheD.setContentView(tv);
        //    TheD.show();
		//}
		
	}

	public String checkValidety(String feedValue) 
	{
		//String corespondant=feedValue; 
		boolean isittext=false;
		if(feedValue.isEmpty())
		{
			feedValue=("0000");
		}
		else
		{
		
			for (int i1 = 1; i1 < feedValue.length() && isittext==false ; i1++) 
			{
				if (!Character.isDigit(feedValue.charAt(i1)))
					isittext = true;
			}
			if (isittext == false)
				{
					if (Double.parseDouble(feedValue) >= 1000000)
					{
						
						feedValue="000";
					}
					else
					if (Double.parseDouble(feedValue) <= (-1))
					{
						feedValue="00";
					}

				}
			else
				{
					feedValue="0000";
				}
			
		}
		return feedValue;
	}
}
