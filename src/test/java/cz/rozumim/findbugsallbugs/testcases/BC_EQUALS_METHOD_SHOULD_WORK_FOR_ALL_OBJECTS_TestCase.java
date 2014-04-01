package cz.rozumim.findbugsallbugs.testcases;

import java.util.ArrayList;
import java.util.List;

import cz.rozumim.findbugsallbugs.FindbugsTestCase;
import edu.umd.cs.findbugs.BugReporter;
import edu.umd.cs.findbugs.Detector;
import edu.umd.cs.findbugs.detect.DumbMethods;


public class BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS_TestCase implements FindbugsTestCase {

	class BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS {
	
		int someFiled = 0;

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
	
	//		PROBLEM: equals() shouldn't cast without checking type first 
	//		if (getClass() != obj.getClass())
	//			return false;
			
			BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS other = (BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS) obj;
			if (someFiled != other.someFiled)
				return false;
			return true;
		}
	}

	public String getBugType() {
		 return "BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS";
	}

	@Override
	public List<Class> getClassesWithBug() {
		
		List<Class> classes = new ArrayList<Class>();

		classes.add(BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS.class);

		return classes;
	}

	@Override
	public List<Class> getClassesWithoutBug() {
		
		List<Class> classes = new ArrayList<Class>();

		// classes.add();

		return classes;
	}
	
	public Detector getDetector(BugReporter bugReporter) {
		return new DumbMethods(bugReporter);
	}	
}
