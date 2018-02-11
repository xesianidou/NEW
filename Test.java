
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);

		/*Δημιουργία αντικειμένου τύπου city και ανάθεσή του στην αναφορά (μεταβλητή) rome.
		Το αντικείμενο θα προστεθεί στον πίνακα των cities.
		*/

		City rome = new City ("Rome","Italy",5);

		/*Δημιουργία αντικειμένου τύπου hotel και ανάθεσή του στην αναφορά (μεταβλητή) hotel1.
		Το αντικείμενο θα προστεθεί στον πίνακα των hotels.
		*/

		Hotel hotel1 = new Hotel ("Roma bella", rome ,50,3,false);

	    //Δημιουργία αντικειμένων τύπου city και hotel τα οποία θα προστεθούν αυτομάτως στους πίνακες


		City berlin = new City ("Berlin","Germany",4);
		new Hotel ("Mercure Hotel",berlin,55.5,3,true);
		new Hotel("Berlin ,Berlin",berlin,50.0,4,true);

		City paris= new City ("Paris","France",3);
		new Hotel ("Hotel Montmartre mon Amour",paris,95.50,3,true);

		City barcelona= new City ("Barcelona","Spain",3);
		new Hotel ("Barca",barcelona,32.30,2,false);

		City newYork = new City("New York","U.S.A.",12);
		new Hotel ("Holday inn",newYork,67.50,3,true);

		City london=new City("London","Great Britain",6);
		new Hotel ("Milestone",london,350,4,true);


		City tokyo =new City("Tokyo","Japan",10);
		new Hotel ("Niwa Tokyo",tokyo,110.30,4,true);



		// έχουμε δημιουργήσει πίνακες με αντικείμενα πόλεις και ξενοδοχεία.


		while (true){
			System.out.println("\n------ Welcome to our DMST Marvelous Travel Agency ------");
			System.out.println("1. Display all destinations");
			System.out.println("2. Search available hotels  by City's name");
			System.out.println("3. Create new City");
			System.out.println("4. Diplay hotels the most expensive hotels");
			System.out.println("5. Change price of hotels");
			int choice = scanner.nextInt();

			if (choice == 1){
				System.out.println(" Our Destinations are: ");
				for (int i=0; i<City.cities.length; i++){//Εκτύπωση όλων των αντικειμένων του πίνακα (δεν είναι γεμάτος ο πίνακας)
					if (City.cities[i]!= null)//αν υπάρχει αντικείμενο στη θέση
						System.out.println(City.cities[i].toString());
				}
			}
			else if (choice == 2 ){
					System.out.println("Please write the city : ");
					String choice2=scanner.next();
					int hotelcounter=0;
						for(int y=0; y<Hotel.hotels.length; y++){
							 if(Hotel.hotels[y]!= null){
								if (choice2.equals(Hotel.hotels[y].getCity().getName())){
									hotelcounter++;
											}
										}
								}
										System.out.println(hotelcounter+" hotels were found");
										   for(int y=0; y<Hotel.hotels.length; y++){
											  if(Hotel.hotels[y]!= null && choice2.equals(Hotel.hotels[y].getCity().getName())){
											     System.out.println(Hotel.hotels[y].toString());
												 }
											}
								    }

            else if (choice == 3 ){
			     if(City.counter <9){
				        System.out.println("Create new City: ");
				            for(int i=0; i<City.cities.length; i++){
					             if(City.cities[i]== null){//αν βρεθεί κενή θέση στον πίνακα
						              System.out.print("Name: ");//Ζητάμε όνομα πόλης
						              String name = scanner.next();
						              System.out.print("Country: ");//Ζητάμε όνομα χώρας
						              String country= scanner.next();
                                      System.out.print("Days of holiday: ");//Ζητάμε μέρες διακοπών
						              int days = scanner.nextInt();

						              City.cities[i]=new City (name,country,days);//δημιουργία και αποθήκευση αντικειμένου
						              System.out.println("city created! ");
						              break;
					              }
				  }
		  }
		       else System.out.println("No available space for new country ");
	    }

		    else if (choice == 4){
				double max=0;
				  for(int i=0; i<Hotel.hotels.length; i++){//για κάθε  hotel
					if(Hotel.hotels[i]!= null && Hotel.hotels[i].getAverageCost()> max){//αν υπάρχει αντικείμενο hotel στη συγκεκριμένη θέση του πίνακα,με αριθμό αστεριών μεγαλύτερο από την τιμη του max
						max=Hotel.hotels[i].getAverageCost();//η νέα τιμη του max ισούται με τον αριθμό των αστεριών του ξενοδοχείου
					}
			}
						for(int y=0; y<Hotel.hotels.length; y++){
							if(Hotel.hotels[y]!= null){
								if (max==Hotel.hotels[y].getAverageCost()){
						           System.out.println("hotel:"+Hotel.hotels[y].getName()+" in "+Hotel.hotels[y].getCity().getName()+",with "+Hotel.hotels[y].getStars()+"stars"+".Average cost per person per night "+Hotel.hotels[y].getAverageCost() +" and breakfast:"+Hotel.hotels[y].getBreakfast());
							}
						}
					}
				}

			else if (choice == 5){
			    System.out.print("Insert index: ");
				int index=scanner.nextInt();
				    if (Hotel.hotels[index]==null){
				       System.out.println( "No hotel is stored in this index!" );
			   }
				    else {
					   System.out.println("Your search for hotels stored in index  "+index+":"+Hotel.hotels[index].getName());
				       System.out.println("New price :");
				       double newPrice=scanner.nextDouble();
					   Hotel.hotels[index].setAverageCost(newPrice);
					   System.out.println( Hotel.hotels[index].toString());
					  }

		}
			else {
			System.out.println("wrong input");
			System.out.println("------------------\n");
		}
	  }
   }
}