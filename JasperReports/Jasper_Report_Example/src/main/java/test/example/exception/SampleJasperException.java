package test.example.exception;

public class SampleJasperException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SampleJasperException() {
		super();
	}

	public SampleJasperException(String message) {
		super(message);
	}

	public SampleJasperException(Throwable throwable) {
		super(throwable);
	}

	public SampleJasperException(String message, Throwable throwable) {
		super(throwable);
	}
}
