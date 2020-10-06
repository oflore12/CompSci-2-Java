
public class InvalidNotationFormatException extends Exception {
	public InvalidNotationFormatException() {
		super("Invalid notation format");
	}
	public InvalidNotationFormatException(String message){
		super(message);
	}
}
