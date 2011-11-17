package wasso.dundee.ac.uk;

import junit.framework.TestCase;

public class viewtotalTest extends TestCase {

	

	public void testOnCreateBundle() {
		
	}

	public void testCalcTotalWorth() {
		viewtotal gettotal = new viewtotal();
		String if00 = gettotal.calcTotalWorth("5", "00");
		String if000 = gettotal.calcTotalWorth("5", "000");
		String if0000 = gettotal.calcTotalWorth("5", "0000");
		String ifvalid = gettotal.calcTotalWorth("5", "100");
		assertTrue((if00.equals("00")) && (if000.equals("000")) && (if0000.equals("0000")) && (ifvalid.equals("500.0"))) ;
	}

}
