package peaksoft.exception;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException() {
        super();
    }

    public TeacherNotFoundException(String message) {
        super(message);
    }
}
