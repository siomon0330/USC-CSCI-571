/**
 * Created by weichuanli on 3/9/17.
 */
import java.io.IOException;

/**
 This class reports bad input data.
 */
public class BadDataException extends IOException
{
    public BadDataException() {}
    public BadDataException(String message)
    {
        super(message);
    }
}