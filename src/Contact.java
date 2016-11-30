import java.util.ArrayList;
import java.util.List;

public class Contact {
	
	
	private String name;
	private int phoneNumber;

	public Contact(int phoneNumber,String name){
		this.name  = name;
		this.phoneNumber = phoneNumber;
	}
	
	public static Contact setContact(int phoneNumber, String name){
		return new Contact(phoneNumber,name);
				
	}
	
		
	public static List<Contact> getContactsWith123()
	{   
		Contact newcontact1 = Contact.setContact(1134567890, "Huang");
		Contact newcontact2 = Contact.setContact(1436789133, "Honey");
		Contact newcontact3 = Contact.setContact(1231231230, "Yahoo");
		Contact newcontact4 = Contact.setContact(1141321111, "Hoooo");
		Contact newcontact5 = Contact.setContact(1151231111, "David");
		Contact newcontact6 = Contact.setContact(1211311111, "Jay");
		Contact newcontact7 = Contact.setContact(1131112211, "Jane");
		Contact newcontact8 = Contact.setContact(1111111123, "Jess");
		Contact newcontact9 = Contact.setContact(1123656123, "QiYi");
		
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		contacts.add(newcontact1);
		contacts.add(newcontact2);
		contacts.add(newcontact3);
		contacts.add(newcontact4);
		contacts.add(newcontact5);
		contacts.add(newcontact6);
		contacts.add(newcontact7);
		contacts.add(newcontact8);
		contacts.add(newcontact9);
		
		int size = contacts.size();
		for (int i = 0 ; i < size ; i ++ )
		{
			int foundPhoneNumber = contacts.get(i).phoneNumber;
			String foundName = contacts.get(i).name;
			String results = Integer.toString(foundPhoneNumber);
			
			if(results.contains("123")){
				contacts.remove(i);
				size--;
				i--;
				System.out.println("Phone Number: "+results+" Name: "+foundName);
			}
		}		
		
		return contacts;
	}
	
	
	public static void main(String[] args){

		getContactsWith123();
		
	}
}

