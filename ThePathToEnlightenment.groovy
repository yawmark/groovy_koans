import koans.*;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure

public class ThePathToEnlightenment {

	private static Test suite() {
		TestSuite suite = new TestSuite(this.class.name);

		[   //	TruthKoans.class
			AboutAsserts.class
			,	StringKoans.class
			//			,	DateKoans.class
			//			,	RangesKoans.class
			//			,	CollectionsKoans.class
			//			,	OperatorOverloadingKoans.class
		].each { koan -> suite.addTestSuite(koan) }

		return suite;
	}

	public static void main(String[] args) {
		println "Learn well from the Groovy Koans.\n"

		def success = new SuccessListener()
		def junit = new JUnitCore()
		junit.addListener(success)


		def koans = suite()
		def result = junit.run(koans)

		println "The Master says:"
		if (result.failures) {
			report(result.failures[0])
		}
		println "\nMountains are merely mountains."

		def totalSteps = koans.countTestCases()
		printf("Your path thus far... %s/%s // TODO%n", success.count, totalSteps)

		println "${success.successful.methodName}"
	}
	
	static def report(Failure f) {
		println """\
\tYou have not yet reached enlightenment.

The answers you seek:
\t${f.message}

Please meditate on the following code:
\t${f.trace.split(/\n/).find { it =~ f.description.methodName }?.split(' ')[1]}
"""
	}
}
