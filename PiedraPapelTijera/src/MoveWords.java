import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;
    
    /**
     * A�adimos las nuevas opciones al array de posiciones
     * ES MUY IMPORTANTE, el orden ya que dedidir� que opci�n gana seg�n la posici�n que ocupa
     * En la opci�n sencilla cada opci�n gana a la siguiente.
     * En la ampliada cada opci�n gana a la siguiente y la que ocupe 3 posiciones m�s
     * Esto lo contemplaremos modificando el m�todo checkWinner
     */

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA","LAGARTIJA","SPOCK"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int first_i, second_i;

	    first_i = getIndex(first);
	    second_i = getIndex(second);

	    if (first_i == second_i) return EMPATE;
	    
	    /**
	     * A�adimos la condici�n con un or, de estar 3 posiciones despu�s.
	     */
	    
	    
	    return (( (first_i +1) % validMoves.length ) == second_i  ||  ((first_i +3) % validMoves.length)  == second_i )? GANA: PIERDE;
	}
	
} 
