
public class ContactDetails {
	
	private String name, lastName, address, phonenumber, email;
	
	public ContactDetails(String vorname, String nachname, String telefonnummer, String mail, String adresse ) {

		this.name = vorname;
		this.lastName = nachname;
		this.address = adresse;
		this.phonenumber = telefonnummer;
		this.email = mail;
	}
	
	public ContactDetails(String vorname, String nachname, String telefonnummer, String mail) {
		this(vorname, nachname, telefonnummer, mail, null);
	}
	
	public ContactDetails(String vorname, String nachname, String telefonnummer) {
		this(vorname, nachname, telefonnummer, null, null);
	}
	
	public ContactDetails(String vorname, String nachname) {
		this(vorname, nachname, null, null, null);
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getEmail() {
		return email;
	}
	
}
