package prob1;


//public class PersonWithJob extends Person {
public class PersonWithJob  {
	private Person person;
	private double salary;
	
	public double getSalary() {
		return salary;
	}
	PersonWithJob(String n, double s) {
		person = new Person(n);
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPersonWithJob) {
		if(aPersonWithJob == null) return false; 
		if(!(aPersonWithJob instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)aPersonWithJob;

		return person.equals(p.person) && salary == p.salary;
	}


	/**
	 * why they are different?
	 * PersonWithJob extends Person, Inheritance create an ambiguous equality definition where PersonWithJob it's the same as Person
	 *
	 *
	 * p1.equals(p2) -> false, it uses equals of PersonWithJob, because p1 is instance of PersonWithJob and p2 is a Person
	 * it returns false
	 *
	 * p2.equals(p1) -> true, it uses equals of Person, because p2 is a instance of Person and p1 is Person (PersonWithJob is subClass of Person)
	 * then return true
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		PersonWithJob pwj1 = new PersonWithJob("Joe", 30000);
		PersonWithJob pwj2 = new PersonWithJob("Joe", 40000);
		PersonWithJob ppwj3 = new PersonWithJob("Joe", 30000);
		Person p1 = new Person("Joe");
		Person p2 = new Person("Joe");
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("pwj1.equals(pwj2)? " + pwj1.equals(pwj2));//false
		System.out.println("ppwj3.equals(pwj1)? " + ppwj3.equals(pwj1));//true
		System.out.println("p1.equals(p2)? " + p1.equals(p2));//true
		/*System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));*/
	}


}
