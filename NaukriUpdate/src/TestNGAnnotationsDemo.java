	
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	
	import org.testng.annotations.Test;

	public class TestNGAnnotationsDemo {
		//all annotations
		
		@BeforeSuite
		public void beforeSuiteDemo()
		{
			System.out.println("BeforeSuite");
		}
		
		@BeforeClass
		public void beforeClassDemo()
		{
			System.out.println("BeforeClass");
		}
		@BeforeTest
		public void beforeTestDemo()
		{
			System.out.println("Beforetest");
		}
		
		@BeforeMethod
		public void beforeMethodDemo()
		{
			System.out.println("Beforemethod");
		}
		
		@Test
		public void testDemo()
		{
			System.out.println("test");
		}
		@Test
		public void testDemo1()
		{
			System.out.println("test1");
		}
		@AfterMethod
		public void afterMetrhodDemo()
		{
			System.out.println("Aftermethod");
		}
		@AfterTest
		public void afterTestDemo()
		{
			System.out.println("AfterTest");
		}
		@AfterClass
		public void afterClassDemo()
		{
			System.out.println("AfterClass");
		}
		@AfterSuite
		public void afterSuiteDemo()
		{
			System.out.println("AfterSuite");
		}
	}

	

