package run;

import models.logic.Manager;

public class Run {

	public static void main(String[] args) {
		Manager mng= Manager.getInstance();
		mng.addTestUsers();
		mng.printTable();
	}
}