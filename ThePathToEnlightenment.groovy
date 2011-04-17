import koans.*;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure

public class ThePathToEnlightenment {

	private static TestSuite koans() {
		TestSuite suite = new TestSuite(this.class.name);
		[   //	TruthKoans.class
			AboutAsserts.class
			//			,	StringKoans.class
			//			,	DateKoans.class
			//			,	RangesKoans.class
			//			,	CollectionsKoans.class
			//			,	OperatorOverloadingKoans.class
		].each { koan -> suite.addTestSuite(koan) }
		return suite;
	}

	public static void main(String[] args) {
		new Guru().seekAdviceOn(koans())
	}
	
}
