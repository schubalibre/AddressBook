import java.util.Map;
import java.util.TreeMap;


public class AddressBook implements AddressBookInterface{
	
	/*
	 * Die Idee des AddressBook ist es Kontakte mit zwei Schlüsseln zu speichern.
	 * Damit wir dies bewerkstelligen können speichern wir die Kontaktdaten zwei mal in namesMap ab.
	 * Somit kann unter dem Namen und unter dem Nachnamen gesucht werden.
	 * 
	 * robert -> Robert, Dziuba, 123456789, .....
	 * dziuba -> Robert, Dziuba, 123456789, .....
	 * 
	 * Immer daran denken das man die ganze Maschine von außen nicht sieht ;)
	 * 
	 * */
	
	// zwei Maps für name und lastName
	private Map<String, ContactDetails> namesMap = new TreeMap<String, ContactDetails>();

	@Override
	public ContactDetails getDetails(String key) {
		// key wird hier aufbereitet trim toLowerCase
		key = key.trim().toLowerCase();
		// wenn ein Eintrag bei namesMap existiert wird dieser zurück gegeben, sonst null
		return namesMap.get(key);
	}

	@Override
	public boolean keyInUse(String key) {
		// key wird hier aufbereitet trim toLowerCase
		key = key.trim().toLowerCase();
		// es wird geschaut, ob namesMap den key besitzt (true oder false)
		return namesMap.containsKey(key);
	}

	@Override
	public void addDetails(ContactDetails details) throws DuplicateKeyException{
		// name/ lastName wird hier aufbereitet trim toLowerCase
		String name = details.getName().trim().toLowerCase();
		String lastName = details.getLastName().trim().toLowerCase();
		
		// Kontrolle ob der name oder lastName schon benutzt wird
		if(this.keyInUse(name) || this.keyInUse(lastName))
			throw new DuplicateKeyException();
		// alles klar wir kreieren die zwei Maps
		namesMap.put(name, details);
		namesMap.put(lastName, details);
	}

	@Override
	public void changeDetails(String oldKey, ContactDetails details) {
		// oldKey wird hier aufbereitet trim toLowerCase
		oldKey = oldKey.trim().toLowerCase();
		// wenn der Eintrag existiert.....
		if(this.keyInUse(oldKey)){
			// wir löschen als erstes die alten Einträge
			this.removeDetails(oldKey);
			
			// dann nutzten wir unsere Methode addDetails um den geänderten Eintrag neu einzutragen
			this.addDetails(details);
			
			/*
			 * WICHTIG! um unsere Daten konsistent zu halten verändern wir sie nicht sondern löschen
			 * die alten Einträge erst und kreieren dann den neuen Eintrag neu. 
			 * Damit bleiben beide Maps konsistent 
			 * 
			 * */
		}
	}

	// wird noch nicht genutzt
	@Override
	public ContactDetails[] search(String keyPrefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfEntries() {
		// gibt die größe der Liste zurück
		return namesMap.size();
	}

	@Override
	public void removeDetails(String key) {
		// wir löschen aus beiden Maps die Einträge
		
		if(this.keyInUse(key)){
			// wir holen uns die Details 
			ContactDetails oldDetails = this.getDetails(key);
			
			// und löschen mit name und lastName die Einträge aus Maps
			namesMap.remove(oldDetails.getName().trim().toLowerCase());
			namesMap.remove(oldDetails.getLastName().trim().toLowerCase());
		}
	}

}
