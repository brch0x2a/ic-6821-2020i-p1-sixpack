/**
 * This class correspond a RequestProcessorImpl's interface.
 * It's just used as a contract for RequestProcessorImpl class.
 */
public interface RequestProcessor {
    void process(Request request, Response response);
}