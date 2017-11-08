package run;

import models.logic.Manager;

public class Run {

	public static void main(String[] args) {
<<<<<<< HEAD:PaginasWeb/GradleProyect/src/main/java/run/Run.java
		Manager mng= Manager.getInstance();
		mng.addTestUsers();
		mng.printTable();
=======
		Manager mng= new Manager();
//		mng.addTestUsers();
		System.out.println(mng.toString());
		//mng.printTable();
>>>>>>> d634848ed1abfa19e338d33b9ae85d4cd1f0829a:PaginasWeb/Gradle Proyect/src/main/java/run/Run.java
	}
}