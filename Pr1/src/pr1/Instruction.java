package pr1;

public class Instruction {
	private Action action;
	private Rotation rotation;
	
	public Instruction(){
		this.action = Action.UNKNOWN;
	}
	
	public Instruction ( Action action){
		this.action = action;
		this.rotation = Rotation.UNKNOWN;
	}
	
	public Instruction ( Action action, Rotation rotation){
		this.action = action;
		this.rotation = rotation;
	}
	
	public boolean isValid (){
		//false if the action is UNKNOWN, or the action is TURN and 
		//the rotation is UNKNOWN. Return true otherwise
		boolean valido = true;
		
		if ( this.action == Action.UNKNOWN || (this.action == Action.TURN && this.rotation == Rotation.UNKNOWN)){
			valido = false;
		}
		
		return valido;
	}
	
	public Action getAction() {
		return action;
	}
	public Rotation getRotation() {
		return rotation;
	}
	

}
