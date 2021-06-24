package Problem3;

//define custom exception
public class OrderException extends Exception{
        public OrderException(String message) {
            super("Ordering Problem: " + message);
        }
}
