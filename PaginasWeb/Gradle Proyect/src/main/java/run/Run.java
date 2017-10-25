package run;

import models.logic.Manager;

public class Run {

	public static void main(String[] args) {
		Manager mng= new Manager();
//		mng.addTestUsers();
		System.out.println(mng.toString());
		//mng.printTable();
	}
}