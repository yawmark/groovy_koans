import junit.framework.TestResult
import junit.framework.TestSuite
import koans.Koans
import org.junit.Test
import org.junit.runner.JUnitCore
import org.junit.runner.notification.Failure

class Guru {

	void seekAdviceOn(TestSuite koans) {
		introduce()
		def analysis = assess(koans)
		acknowledgeMostRecent(analysis.success)
		if (analysis.failure) {
			report(analysis.failure)
			encourage()
		} else {
			reportSuccess()
		}
		saySomethingPithy()
		describeProgress(analysis)
	}
	
	private acknowledgeMostRecent(success) {
		if (success.mostRecent) {
			println "\t${success.mostRecent} has expanded your awareness."
		}
	}

	private GuruAnalysis assess(koans) {
		def success = new Success()
		def junit = new JUnitCore()
		junit.addListener(success)
		def result = junit.run(koans)
		new GuruAnalysis(success:success, failure:result.failures[0], koansCount:koans.countTestCases())
	}

	private introduce() {
		println "Learn well from the Groovy Koans.\n"
		println "The Master says:"
	}

	private describeProgress(analysis) {
		printf("Your path thus far... %s/%s%n", analysis.success.count, analysis.koansCount)
	}

	private saySomethingPithy() {
		println "\nMountains are merely mountains."
	}

	private encourage() {
		println "Hang on man, you can do it!"
	}

	private reportSuccess() {
		println "\tCongratulations! You have attained enlightenment!"
	}

	private report(Failure f) {
		println """\
\tYou have not yet reached enlightenment.

The answers you seek:
${f.message.trim()}

Please meditate on the following code:
\t${f.trace.split(/\n/).find { it =~ f.description.methodName }?.split(' ')[1]}
"""
	}
}

class GuruAnalysis {
	Success success
	Failure failure
	int koansCount
}