package org.base;

import org.testng.annotations.Test;

public class Groupings {
	
	@Test(groups = "Sanity")
	private void tco1() {
		System.out.println(Thread.currentThread().getId() + "\tTest 1 :	Sanity");
	}
	
	@Test(groups = "Smoke")
	private void tco2() {
		System.out.println(Thread.currentThread().getId() + "\tTest 2 :	Smoke");
	}
	
	@Test(groups = "Regg")
	private void tco3() {
		System.out.println(Thread.currentThread().getId() + "\tTest 3 :	Regg");
	}
	
	@Test(groups = "Sanity")
	private void tco4() {
		System.out.println(Thread.currentThread().getId() + "\tTest 4 :	Sanity");
	}
	
	@Test(groups = "Sanity")
	private void tco5() {
		System.out.println(Thread.currentThread().getId() + "\tTest 5 :	Sanity");
	}
	
	@Test(groups = "Regg")
	private void tco6() {
		System.out.println(Thread.currentThread().getId() + "\tTest 6 :	Regg");
	}
	
	@Test(groups = "Smoke")
	private void tco7() {
		System.out.println(Thread.currentThread().getId() + "\tTest 7 :	Smoke");
	}
	
}
