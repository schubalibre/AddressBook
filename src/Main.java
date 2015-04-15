
public class Main {
	
	private static AddressBook myBook = new AddressBook();

	public static void main(String[] args) {
		
		fillMyBook();
		System.out.println(myBook.getNumberOfEntries() + " Einträge");
		System.out.println("---------------------------------------------");
		getMyBookDetails();
		System.out.println("---------------------------------------------");
		changeMyBookDetails();
		System.out.println("---------------------------------------------");
		myBook.removeDetails("Roberto");
		System.out.println(myBook.getNumberOfEntries() + " Einträge");
		
	}

	private static void changeMyBookDetails() {
		
		ContactDetails a = myBook.getDetails("Robert");
		
		System.out.println(a.getName() +", "+ a.getLastName() +", "+ a.getPhonenumber() +", "+ a.getEmail());
		
		ContactDetails details = new ContactDetails("Roberto", "Dziubao", "123456789","12345@web.de","Sonntagstr. 27");
		
		myBook.changeDetails("Robert", details);
		
		a = myBook.getDetails("Roberto");
		
		System.out.println(a.getName() +", "+ a.getLastName() +", "+ a.getPhonenumber() +", "+ a.getEmail());
		
		a = myBook.getDetails("Dziubao");
		
		System.out.println(a.getName() +", "+ a.getLastName() +", "+ a.getPhonenumber() +", "+ a.getEmail());
		
		a = myBook.getDetails("Dziuba");
		
		if(a != null)
			System.out.println(a.getName() +", "+ a.getLastName() +", "+ a.getPhonenumber() +", "+ a.getEmail());
	}

	private static void getMyBookDetails() {
		
		ContactDetails a = myBook.getDetails("Robert");
		
		System.out.println(a.getName() +", "+ a.getLastName());
		
		ContactDetails b = myBook.getDetails("Dziuba");
		
		System.out.println(b.getName() +", "+ b.getLastName());
		
		ContactDetails c = myBook.getDetails("Deuter");
		
		System.out.println(c.getName() +", "+ c.getLastName() +", "+ c.getPhonenumber() +", "+ c.getEmail());
		
	}

	private static void fillMyBook() {
		
		ContactDetails a = new ContactDetails("Robert", "Dziuba");
		
		myBook.addDetails(a);
		
		ContactDetails b = new ContactDetails("Bert", "Berman", "123456789");
		
		myBook.addDetails(b);
		
		ContactDetails c = new ContactDetails("Claudia", "Clorens", "123456789","12345@web.de");
		
		myBook.addDetails(c);
		
		ContactDetails d = new ContactDetails("Detlef", "Deuter", "123456789","12345@web.de","Sonntagstr. 27");
		
		myBook.addDetails(d);
		
	}
	
	

}
