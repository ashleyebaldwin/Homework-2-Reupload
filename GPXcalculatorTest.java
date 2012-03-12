package edu.upenn.cis350.gpx;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class GPXcalculatorTest extends GPXcalculator{
	
	@SuppressWarnings("deprecation")
	@Test
	public void testNull() {
		assertEquals(calculateDistanceTraveled(null), -1);
	}
	
	public void testBlank(){
		GPXtrk t1 = new GPXtrk("null", null);
		assertEquals(calculateDistanceTraveled(t1), -1);
	}
	
	public void testGPXtrknoObj(){
	    ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		GPXtrkseg trksegs = new GPXtrkseg(null);
		trksegslist.add(trksegs);
		GPXtrk t2 = new GPXtrk("nullTrkseg", trksegslist);
		assertEquals(calculateDistanceTraveled(t2), 0);
	}
	
	public void testNoPtObj(){
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t3 = new GPXtrk("noPtObj", trksegslist);
		assertEquals(calculateDistanceTraveled(t3), 0);
	}
	
	public void testOnePtObj(){
		GPXtrkpt oneTrkPt = new GPXtrkpt(1, 1 , null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(oneTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t4 = new GPXtrk("onept", trksegslist);
		assertEquals(calculateDistanceTraveled(t4), 0);
	}
	
	public void testTwoPtObj(){
		GPXtrkpt oneTrkPt = new GPXtrkpt(1, 1 , null);
		GPXtrkpt twoTrkPt = new GPXtrkpt(1,2,null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(oneTrkPt);
		trkpts.add(twoTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t4a = new GPXtrk("onept", trksegslist);
		assertTrue(calculateDistanceTraveled(t4a) != 0);
	}
	
	public void testnullPtObj(){
		GPXtrkpt nullTrkPt = null;
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(nullTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t5 = new GPXtrk("nullPtObj", trksegslist);
		assertEquals(calculateDistanceTraveled(t5), 0);
	}
	
	public void testoverNinetyPtObj(){
		GPXtrkpt overNinetyTrkPt = new GPXtrkpt(91, 1 , null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(overNinetyTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t6 = new GPXtrk("posover", trksegslist);
		assertEquals(calculateDistanceTraveled(t6), 0);
	}
	
	public void testEdgeNinetyPtObj(){
		GPXtrkpt edgeNinetyTrkPt = new GPXtrkpt(90, 1 , null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(edgeNinetyTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t6a = new GPXtrk("posedge", trksegslist);
		assertTrue(calculateDistanceTraveled(t6a) !=0);
	}
	
	public void testEdgeNegNinetyPtObj(){
		GPXtrkpt edgeNegNinetyTrkPt = new GPXtrkpt(-90, 1 , null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(edgeNegNinetyTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t6a = new GPXtrk("negedge", trksegslist);
		assertTrue(calculateDistanceTraveled(t6a) !=0);
	}
	
	public void testoverNinetynegPtObj(){
		GPXtrkpt negTrkPt = new GPXtrkpt(-91, 1 , null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(negTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t7 = new GPXtrk("negover", trksegslist);
		assertEquals(calculateDistanceTraveled(t7), 0);
	}
	
	public void testlongTrkPt(){
		GPXtrkpt longTrkPt = new GPXtrkpt(1, 181, null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(longTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t8 = new GPXtrk("posover", trksegslist);
		assertEquals(calculateDistanceTraveled(t8), 0);
	}

	public void testEdgelongTrkPt(){
		GPXtrkpt edgeLongTrkPt = new GPXtrkpt(1, 180, null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(edgeLongTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t8a = new GPXtrk("posedgelong", trksegslist);
		assertTrue(calculateDistanceTraveled(t8a)!= 0);
	}
	
	public void testNegLongTrkPt(){
		GPXtrkpt negLongTrkPt = new GPXtrkpt(1, -181 , null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(negLongTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t9 = new GPXtrk("negover", trksegslist);
		assertEquals(calculateDistanceTraveled(t9), 0);
	}
	
	public void testNegEdgeLongTrkPt(){
		GPXtrkpt negLongTrkPt = new GPXtrkpt(1, -180 , null);
		ArrayList<GPXtrkseg> trksegslist = new ArrayList<GPXtrkseg>();
		ArrayList<GPXtrkpt> trkpts = new ArrayList<GPXtrkpt>();
		trkpts.add(negLongTrkPt);
		GPXtrkseg trksegs = new GPXtrkseg(trkpts);
		trksegslist.add(trksegs);
		GPXtrk t9a = new GPXtrk("negedgelong", trksegslist);
		assertTrue(calculateDistanceTraveled(t9a)!= 0);
	}
	
	

	
}
