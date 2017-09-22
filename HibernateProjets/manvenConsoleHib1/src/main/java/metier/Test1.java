package metier;

import java.util.Scanner;

import model.Civilite;
import model.Langage;
import model.Personne;
import model.Semaine;

public class Test1 {

	public static void main(String[] args) {
		
		//test1();
		test2();
		

	}

	
	static void test3() {
		
		Personne x= new Personne("toto","Titi",Civilite.mr);
		System.out.println(x.toString());
		
	}
	
	static void test2() {
		System.out.println("Choisir depuis la liste des langages");
		for(Langage l: Langage.values())
			System.out.println(l);
		Scanner sc= new Scanner(System.in);
		
		String choix = sc.nextLine();
		Langage x=Langage.valueOf(choix);
		System.out.println("bon choix!!   " +x.name());
	}
	
	static void test1() {
		System.out.println("je suis hibernate");
		System.out.println(Semaine.Lundi);
		System.out.println(Langage.java);
		System.out.println(Civilite.mr);
		System.out.println(Civilite.mlle.toString());
		
		Civilite c=Civilite.mlle;
		System.out.println(c.name());
	}
	
	
	
}
