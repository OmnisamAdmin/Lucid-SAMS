package za.co.sfy.lucid.sams.domain.exception;


public class LucidSamsExecutionException extends Exception{

    private static final long serialVersionUID = 4568036386039187539L;

	public LucidSamsExecutionException(String message) {
        super(message);
    }

    public LucidSamsExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}