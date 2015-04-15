import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class AddressBook implements AddressBookInterface{
	
	private Map<String, ContactDetails> contactsMap = new TreeMap<String, ContactDetails>(); 

	@Override
	public ContactDetails getDetails(String key) {
		return contactsMap.get(key);
	}

	@Override
	public boolean keyInUse(String key) {
		return contactsMap.containsKey(key);
	}

	@Override
	public void addDetails(ContactDetails details) throws DuplicateKeyException{
		
		String key = details.getKey();
		
		if(contactsMap.containsKey(key))
			throw new DuplicateKeyException();
		
		contactsMap.put(key, details);
	}

	@Override
	public void changeDetails(String oldKey, ContactDetails details) {
		if(contactsMap.containsKey(oldKey)){
			contactsMap.remove(oldKey);
			this.addDetails(details);
		}
	}

//	@Override
//	public ContactDetails[] search(String keyPrefix) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int getNumberOfEntries() {
		return contactsMap.size();
	}

	@Override
	public void removeDetails(String key) {
		contactsMap.clear();
	}

}
