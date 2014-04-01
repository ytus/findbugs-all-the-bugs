package cz.rozumim.findbugsallbugs.testcases;

import java.util.ArrayList;
import java.util.List;

import cz.rozumim.findbugsallbugs.FindbugsTestCase;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;
import edu.umd.cs.findbugs.detect.CloneIdiom;


public class CN_IDIOM_NO_SUPER_CALL_TestCase implements FindbugsTestCase {
	
	class CN_IDIOM_NO_SUPER_CALL implements Cloneable {

		@Override
		protected Object clone() throws CloneNotSupportedException {
			// PROBLEM: missing clone() method
			return null;
		}
	}

	class CN_IDIOM_NO_SUPER_CALL_OK implements Cloneable {

		@Override
		protected Object clone() throws CloneNotSupportedException {
			super.clone();
			return null;
		}
	}

	class CN_IDIOM_NO_SUPER_CALL_OK_2 implements Cloneable {

		@Override
		protected Object clone() throws CloneNotSupportedException {
			clone();
			return null;
		}
	}

	class CN_IDIOM_NO_SUPER_CALL_OK_3 { // implements Cloneable {

		@Override
		protected Object clone() throws CloneNotSupportedException {
			// doesn't implement Cloneable -> no problem found with Findbugs
			return null;
		}
	}

	public String getBugType() {
		return "CN_IDIOM_NO_SUPER_CALL";
	}

	public List<Class> getClassesWithBug() {

		List<Class> classes = new ArrayList<Class>();

		classes.add(CN_IDIOM_NO_SUPER_CALL.class);

		return classes;
	}

	public List<Class> getClassesWithoutBug() {

		List<Class> classes = new ArrayList<Class>();

		classes.add(CN_IDIOM_NO_SUPER_CALL_OK.class);
		classes.add(CN_IDIOM_NO_SUPER_CALL_OK_2.class);

		return classes;
	}

	public Detector getDetector(BugReporter bugReporter) {
		return new CloneIdiom(bugReporter);
	}
}
