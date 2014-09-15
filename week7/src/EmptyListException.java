
/**
 * Runtime exception thrown when one tries to perform an access or
 * removal operation on an empty list.
 */

public class EmptyListException extends RuntimeException {
  public EmptyListException(String err) {
    super(err);
  }
}
