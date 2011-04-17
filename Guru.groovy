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
		if (analysis.failure) {
			report(analysis.failure)
			encourage()
		} else {
			reportSuccess()
		}
		saySomethingPithy()
		describeProgress(analysis)
	}

	private GuruAnalysis assess(koans) {
		def successes = new Successes()
		def junit = new JUnitCore()
		junit.addListener(successes)
		def result = junit.run(koans)
		new GuruAnalysis(successes:successes, failure:result.failures[0], koansCount:koans.countTestCases())
	}

	private introduce() {
		println "Learn well from the Groovy Koans.\n"
		println "The Master says:"
	}

	private describeProgress(analysis) {
		printf("Your path thus far... %s/%s%n", analysis.successes.count, analysis.koansCount)
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
\t${f.message.trim()}

Please meditate on the following code:
\t${f.trace.split(/\n/).find { it =~ f.description.methodName }?.split(' ')[1]}
"""
	}
}

class GuruAnalysis {
	Successes successes
	Failure failure
	int koansCount
}