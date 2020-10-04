

import java.util.*;

public class AddressBook {
 
    public static void main(String args[]) {
        
     Scanner sc = new Scanner (System.in);
     int hashKey = 1;
     HashMap<Integer,Map<String,String>> hashMapAddressBooks = new HashMap<Integer,Map<String,String>>();
     Map<String,String> activeHashMap = new HashMap<String,String>();
     Map<String,String> userAddressMap = new HashMap<String,String>();
     activeHashMap = userAddressMap;
     String regexForFirstName = "^[A-Za-z]{2,}$";
     String regexForLastName = "^[A-Za-z]{2,}$";
     String regexForAddress = "^[#.0-9a-zA-Z,-]+$";
     String regexForCity = "^[A-Za-z]{2,}$";
     String regexForState = "^[A-Za-z]{2,}$";
     String regexForZipCode = "^[0-9]{6}";
     String regexForPhoneNumber =  "^[+]?([0-9]{2,3})?[0-9]{10}$";
     
     while(true){
         System.out.println("Enter the case number you want to perform \n 1.To add a new user Record to the address Book \n 2.To search For a particular record \n 3.To delete a user \n 4.To update a user detail \n 5.To create a new HashMap \n 6.To sort the records According to the Zipcode \n 7.To sort the records according to the surname of the user \n 8.To view active addressbook ur working with \n 9.To view all you address books \n 10. To select one of your address books you wish to work with");
         int caseNum = sc.nextInt();
         switch(caseNum){
         //adding a new user to the address book
         case 1:
            System.out.println("Enter you first Name");
            String firstname = sc.next();
               if( !firstname.matches(regexForFirstName) ){
                   System.out.println("Please Enter proper first name");
                   firstname = sc.next();
               }
           
            System.out.println("Enter your last Name");	
            String lastname = sc.next();
               if( !lastname.matches(regexForLastName) ){
                   System.out.println("Please Enter proper last name");
                   lastname = sc.next();
               }
           
            System.out.println("Enter the Address");
            String address = sc.next();
               if( !address.matches(regexForAddress) ){
                   System.out.println("Please Enter proper city address");
                   address=sc.next();
               } 
          
            System.out.println("Enter the City Name");
            String city = sc.next();
              if( !city.matches(regexForCity) ){
                   System.out.println("Please Enter proper city name");
                   city = sc.next();
               }
           
            System.out.println("Enter the State Name");
            String stateName = sc.next();
               if( !stateName.matches(regexForState) ){
                   System.out.println("Please Enter proper state name");
                   stateName = sc.next();
               }
               
            System.out.println("Enter the Zipcode");
            String zipcode = sc.next();
                if( !zipcode.matches(regexForZipCode) ){
                   System.out.println("Please Enter valid zipcode");
                   zipcode = sc.next();
               }
               
            System.out.println("Enter the Phone Number");
            String phoneNum = sc.next();
                if( !phoneNum.matches(regexForPhoneNumber) ){
                   System.out.println("Please Enter valid Phone Number");
                   phoneNum = sc.next();
               }
               
            String name = firstname+" "+lastname;
            String userDetails = firstname+" "+lastname+", "+address+", "+city+", "+stateName+", "+zipcode+", "+phoneNum;
            activeHashMap.put(name,userDetails);
            
            System.out.println("Record Added Successfully To The Address Book");
            
            System.out.println("Records currently present inside Address Book are : ");
            for(Map.Entry<String,String> mappedUsersDetails :activeHashMap.entrySet() ){
                System.out.println(mappedUsersDetails.getKey()+"=>"+mappedUsersDetails.getValue());
            }
             
         break;
         
        case 2:
        	//searching of the user
           System.out.println("Enter the name/phone/zipcode/city/state of the user you want to search");
           boolean flagUserExists=false;
           String searchUser = sc.next();
           for(Map.Entry<String,String> mappedUsersDetails :userAddressMap.entrySet() ){
               if(mappedUsersDetails.getValue().contains(searchUser)) {
            	   flagUserExists=true;
            	   System.out.println("User details for Searched User is : \n "+mappedUsersDetails.getValue());
               }
           }
           if(!flagUserExists) {
        	   System.out.println("User details for "+searchUser+" doesn't exist !");
           }
         break;
         
        case 3:
        	//deletion of the user
        	System.out.println("Enter the name/phone/zipcode/city/state of the user you want to delete");
        	String deleteUser = sc.next();
        	for(Map.Entry<String,String> mappedUsersDetails :userAddressMap.entrySet() ){
                if(mappedUsersDetails.getValue().contains(deleteUser)) {
             	   flagUserExists=true;
             	  String deleteUserKey = mappedUsersDetails.getKey();
             	  userAddressMap.remove(deleteUserKey);
             	  break;
                }
            }
        	System.out.println("Record deleted Successfully ");
        	System.out.println("New Address Book after the deletion looks like : " );
        	for(Map.Entry<String,String> mappedUsersDetails :userAddressMap.entrySet() ){
                System.out.println(mappedUsersDetails.getKey()+"=>"+mappedUsersDetails.getValue());
            }
         break;
         
        case 4:
        	//edit a user
        	System.out.println("Enter the user name of the user you want to edit");
        	boolean flagUserExisitng = false;
        	String editUser = sc.next();
        	String editUserKey = "";
        	for(Map.Entry<String,String> mappedUsersDetails :userAddressMap.entrySet() ){
                if(mappedUsersDetails.getValue().contains(editUser)) {
                	flagUserExisitng=true;
             	   editUserKey = mappedUsersDetails.getKey();
             	  break;
                }
            }
        	if(flagUserExisitng) {
        		System.out.println("Enter you first Name for updation");
                String firstnameForUpdate = sc.next();
                   if( !firstnameForUpdate.matches(regexForFirstName) ){
                       System.out.println("Please Enter proper first name");
                       firstnameForUpdate = sc.next();
                   }
               
                System.out.println("Enter your last Name for updation ");	
                String lastnameForUpdate = sc.next();
                   if( !lastnameForUpdate.matches(regexForLastName) ){
                       System.out.println("Please Enter proper last name");
                       lastnameForUpdate = sc.next();
                   }
               
                System.out.println("Enter the Address for updation ");
                String addressForUpdate = sc.next();
                   if( !addressForUpdate.matches(regexForAddress) ){
                       System.out.println("Please Enter proper city address");
                       addressForUpdate = sc.next();
                   } 
              
                System.out.println("Enter the City Name for updation");
                String cityForUpdate = sc.next();
                  if( !cityForUpdate.matches(regexForCity) ){
                       System.out.println("Please Enter proper city name");
                       cityForUpdate = sc.next();
                   }
               
                System.out.println("Enter the State Name for updation");
                String stateNameForUpdate = sc.next();
                   if( !stateNameForUpdate.matches(regexForState) ){
                       System.out.println("Please Enter proper state name");
                       stateNameForUpdate = sc.next();
                   }
                   
                System.out.println("Enter the Zipcode for updation");
                String zipcodeForUpdate = sc.next();
                    if( !zipcodeForUpdate.matches(regexForZipCode) ){
                       System.out.println("Please Enter valid zipcode");
                       zipcodeForUpdate = sc.next();
                   }
                   
                System.out.println("Enter the Phone Number for updation");
                String phoneNumForUpdate = sc.next();
                    if( !phoneNumForUpdate.matches(regexForPhoneNumber) ){
                       System.out.println("Please Enter valid Phone Number"); 
                       phoneNumForUpdate = sc.next();
                       
                   }
                   
                   String updatedValueString = firstnameForUpdate+" "+lastnameForUpdate+", "+addressForUpdate+", "+cityForUpdate+", "+stateNameForUpdate+", "+zipcodeForUpdate+", "+phoneNumForUpdate;
                   if(editUserKey != "" || editUserKey != null) {
                	   userAddressMap.replace(editUserKey, updatedValueString); 
                	   System.out.println("Record Updated Successfully!");
                	   System.out.println("Address Book after updation is : ");
                   		for(Map.Entry<String,String> mappedUsersDetails :activeHashMap.entrySet() ){
                           System.out.println(mappedUsersDetails.getKey()+"=>"+mappedUsersDetails.getValue());
                       }
                   }
        	}else {
        		System.out.println("No such user was found for performing updation");
        	}
         break;
         
        case 5:
        	//creation of new HashMap
        	hashMapAddressBooks.put(hashKey, activeHashMap);
        	Map<String,String> newUserDetailsMap = new HashMap<String,String>();
        	activeHashMap = newUserDetailsMap;
        	hashKey = hashKey+1;
        	
        	hashMapAddressBooks.put(hashKey, activeHashMap);
        	
         break;
         
        case 6:
        	System.out.println("Sort the address Book user contents by the zipcode");
        	Map<String,String> sortMapForZipcode = new HashMap<String,String>();
        	if(userAddressMap==null || userAddressMap.isEmpty() == true) {
        		System.out.println("Please Enter the user details prior to sort");
        	}
        	for(Map.Entry<String,String> mappedUsersDetails :userAddressMap.entrySet() ){
                String[] splitForZip = mappedUsersDetails.getValue().toString().split(",");
                String zip = splitForZip[4];
                System.out.println(zip);
                sortMapForZipcode.put(zip,mappedUsersDetails.getValue());
            }
        	
        	TreeMap<String, String> sorted = new TreeMap<>(); 
            sorted.putAll(sortMapForZipcode); 
            System.out.println("Sorted values according to zipcodes are as follows :");
            for (Map.Entry<String, String> entry : sorted.entrySet())  
                System.out.println(" Value = " + entry.getValue());
        	break;
        	
        case 7:
        	System.out.println("Sort the address book user contents by the Surname");
        	Map<String,String> sortMapForSurname = new HashMap<String,String>();
        	for(Map.Entry<String,String> mappedUsersDetails :userAddressMap.entrySet() ){
                String[] splitForSurname = mappedUsersDetails.getValue().toString().split(" ");
                String surname = splitForSurname[1];
                System.out.println(surname);
                sortMapForSurname.put(surname,mappedUsersDetails.getValue());
            }
        	
        	TreeMap<String, String> sortedSurnames = new TreeMap<>(); 
        	  
        	sortedSurnames.putAll(sortMapForSurname); 
        	System.out.println("Sorted values according to surnames are as follows :");
            for (Map.Entry<String, String> entry : sortedSurnames.entrySet())  
                System.out.println("Value = " + entry.getValue());
        	break;
        	
        case 8:
        	System.out.println("View Current Active Address Book");
        	for(Map.Entry<String,String> mappedUsersDetails :activeHashMap.entrySet() ){
                System.out.println(mappedUsersDetails.getKey()+"=>"+mappedUsersDetails.getValue());
            }
        	break;
        	
        case 9:
        	System.out.println("Get all your address Books ");
        	
        	for(HashMap.Entry<Integer,Map<String,String>> mappedUsersDetailsInAddressBook :hashMapAddressBooks.entrySet() ){
                System.out.println(mappedUsersDetailsInAddressBook.getKey()+"=>"+mappedUsersDetailsInAddressBook.getValue());
            }
        	break;
        case 10:
        	System.out.println("Enter the Key of the Address Book you want to work with");
        	int addressBookKey = sc.nextInt();
        	Map<String,String> desiredWorkingHashMap = hashMapAddressBooks.get(addressBookKey);
        	activeHashMap = desiredWorkingHashMap;
        	break;
        }
     }
     
         
    }
}