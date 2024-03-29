package tp.pr2;

public class CodeCard extends Item{
	private java.lang.String code;
	private int times;
	
	public CodeCard(java.lang.String id ,java.lang.String description, java.lang.String code){
		super(id,description );
		this.code =code;
		this.times=1;
	}
	
	public boolean canBeUsed(){
		return true;
	}
	

	//The method to use a code card. If the robot is in a place which contains a
    //street in the direction he is looking at, then the street is opened or closed 
    //if the street code and the card code match.

	public boolean use(RobotEngine r, Place p) {//MIRAR LUEGO
		boolean bool=false;
		Street calle = r.getHeadingStreet();
		if (calle == null){
			return bool;
		}
		//if(canBeUsed()){
			if ( this.code.equalsIgnoreCase(calle.getCodigo()) ){
				if ( !calle.isOpen()){
					calle.open(this);	
				}
				else{
					calle.close(this);
				}
				bool = true;
			}
	//}
		return bool;
	}
	
	public java.lang.String getCode(){
		return this.code ;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	
	public java.lang.String toString(){
		return this.id + ": "+ this.description;  //+ this.usar + this.times;
	}

}
