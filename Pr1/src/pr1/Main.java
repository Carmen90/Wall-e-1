package pr1;

import java.util.ArrayList;

public class Main {
	private static RobotEngine robot;
	private static Street [] streets;
	private String description;
	private static Place [] place;
	private static Instruction instruction;
	private static Interpreter instruccion;
	private static Direction direction;
	private static Interpreter interprete;
	private static int pos;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		place = createPlaces();
		streets = createStreets(place);
		System.out.println ("Mapa cargado");
		System.out.println ( place[0].toString());
		RobotEngine r = new RobotEngine (place[0], Direction.NORTH, streets);
		r.startEngine();
		Interpreter inter= new Interpreter ();
		System.out.println(inter.interpreterHelp());
		
		

	}

	 	/**
	 * Create the places and configure the initial current place.
	
 * @return The place where the player starts the game
	 
*/
	private static Place[] createPlaces(){
		Place [] _places = new Place[10];
		String LINE_SEPARATOR = System.getProperty("line.separator");
		
		// 0: Puerta del Sol
		_places[0] = new Place("PUERTA DEL SOL" , false, 
			"You are at the PUERTA DEL SOL, the center of Madrid. " +  LINE_SEPARATOR +
			"Ufff, there are a lot of streets, but all of them are full of garbage." + LINE_SEPARATOR +
			"You should walk around this place to look for some interesting" + LINE_SEPARATOR +
			"objects to pick up." + LINE_SEPARATOR +
			"Note that there is a big clock. Remember, leave the square before " + LINE_SEPARATOR +
			"night. It can be dangerous");
		// 1: Plaza Mayor
		_places[1] = new Place("PLAZA MAYOR", false,
			"Mmmh... it smells squid fried in butter. You should try to eat something");

		// 2: Plaza Espa�a
		_places[2] = new Place("PLAZA ESPA�A" , false,
			"What a big square! You have a big park where you can sleep under a tree." + LINE_SEPARATOR +
			"But you have a problem, you have to come back to PLAZA MAYOR. " + LINE_SEPARATOR +
			"There is no other exit");

		// 3: Plaza de Callao 
		_places[3] = new Place("CALLAO", false, 
			"In this small square you can find some some fuel. " + LINE_SEPARATOR +
		"Go to fnac and take the fuel for the heating");
		
		// 4: Plaza de Col�n(END)
		_places[4] = new Place("COLON", true, 
					"Sometime ago, Spanish people concentrates here to watch football " + LINE_SEPARATOR +
			"in a big screen." +  LINE_SEPARATOR +
			"Wall-e, did you know that in Spain there were very good football teams?." +  LINE_SEPARATOR +
			"Look for cans! People throw cans after watching football!");
		
		// 5: Cibeles
		_places[5] = new Place("CIBELES", false, 
			"Arggg, the fountain is ugly! The water is very dirty. " + LINE_SEPARATOR + 
			"You should leave before the lions attack you");
		
		// 6: Neptuno
		_places[6] = new Place("NEPTUNO", false,
			"Watch Wall-e! Another fountain! Perhaps this one has water for drinking" + LINE_SEPARATOR + 
			"If you are cold, use that red and white scarf");
		
		// 7: Atocha 
		_places[7] = new Place("ATOCHA", false, "You have a lot of old trains here, but they do not work" +  LINE_SEPARATOR + 
			"All trains were destroyed during the crisis of 2013" + LINE_SEPARATOR + 
			"Take all the iron you find");
		
		// 8: Puerta de Alcala
		_places[8] = new Place("PUERTA DE ALCALA", true,
			"Ok, finally you have found your spaceship....");
		
		// 9: Plaza de Jacinto Benavente
		_places[9] = new Place("JACINTO BENAVENTE",false,
			"If you are cold you can start a fire with the wheels of those old buses");

		  return _places;
	}

	
	public static Street[] createStreets(Place[] _places){
		 ArrayList<Street>streets = new ArrayList<Street>();
		
		streets.add(new Street(_places[0],Direction.NORTH,_places[3]));
		streets.add(new Street(_places[0],Direction.SOUTH, _places[9]));
		streets.add(new Street(_places[0],Direction.EAST, _places[5]));
		streets.add(new Street(_places[0],Direction.WEST, _places[1]));

		streets.add(new Street(_places[1],Direction.NORTH, _places[2]));
		
		streets.add(new Street(_places[3],Direction.WEST, _places[2]));
		
		streets.add(new Street(_places[5],Direction.NORTH, _places[4]));
		streets.add(new Street(_places[5],Direction.EAST, _places[8]));
		streets.add(new Street(_places[5],Direction.SOUTH, _places[6]));
		
		streets.add(new Street(_places[6],Direction.SOUTH, _places[7]));
		streets.add(new Street(_places[9],Direction.EAST, _places[6]));
		
		Street [] s = new Street[0];
		s = streets.toArray(s);
		return s;
	}
	
}