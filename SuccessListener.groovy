import org.junit.runner.Description
import org.junit.runner.notification.Failure
import org.junit.runner.notification.RunListener;


class SuccessListener extends RunListener {
	
	private successful = []
	
	int getCount() {
		successful.size()
	}
	
	@Override void testStarted(Description description) throws Exception {
		successful << description
	}
	
	@Override void testAssumptionFailure(Failure f) {
		successful.remove f.description
	}

	@Override void testFailure(Failure f) throws Exception {
		successful.remove f.description
	}
}
