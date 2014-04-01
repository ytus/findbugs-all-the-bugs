package cz.rozumim.findbugsallbugs.testcases;

import java.util.ArrayList;
import java.util.List;


import cz.rozumim.findbugsallbugs.FindbugsTestCase;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;
import edu.umd.cs.findbugs.detect.FindHEmismatch;


public class HE_EQUALS_USE_HASHCODE_TestCase implements FindbugsTestCase {

	class HE_EQUALS_USE_HASHCODE {

		int someFiled = 0;
		
		//	PROBLEM: missing hashCode() method
		//	@Override
		//	public int hashCode() {
		//		final int prime = 31;
		//		int result = 1;
		//		result = prime * result + someFiled;
		//		return result;
		//	}
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HE_EQUALS_USE_HASHCODE other = (HE_EQUALS_USE_HASHCODE) obj;
			if (someFiled != other.someFiled)
				return false;
			return true;
		}
	}

	public String getBugType() {
		 return "HE_EQUALS_USE_HASHCODE";
	}

	public Detector getDetector(BugReporter bugReporter) {
		return new FindHEmismatch(bugReporter);
	}

	@Override
	public List<Class> getClassesWithBug() {
		
		List<Class> classes = new ArrayList<Class>();

		classes.add(HE_EQUALS_USE_HASHCODE.class);

		return classes;
	}

	@Override
	public List<Class> getClassesWithoutBug() {
		
		List<Class> classes = new ArrayList<Class>();

		// classes.add();

		return classes;
	}
}
