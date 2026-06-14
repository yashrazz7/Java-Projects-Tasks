import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AIChatbot {
    // Knowledge base for rule-based matching
    private static final Map<String, String> responses = new HashMap<>();

    static {
        // Training the bot with FAQ data
        responses.put("hello", "Hello! I am your AI assistant. How can I help you today?");
        responses.put("hi", "Hi there! What can I do for you?");
        responses.put("how are you", "I'm functioning at peak performance, thank you! How are you?");
        responses.put("what is your name", "I am a Java-based AI Chatbot designed to help answer your questions.");
        responses.put("help", "Sure! You can ask me about programming, my identity, or just say hello.");
        responses.put("java", "Java is a powerful, high-level, object-oriented programming language writing once and running anywhere!");
        responses.put("bye", "Goodbye! Have a fantastic day ahead.");
        responses.put("thank you", "You're very welcome! Let me know if you need anything else.");
        responses.put("thanks", "Anytime! Happy to help.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=================================================");
        System.out.println("     AI CHATBOT INITIALIZED (Type 'bye' to exit) ");
        System.out.println("=================================================");
        System.out.println("Chatbot: Hello! I'm ready. Let's talk.");

        while (true) {
            System.out.print("\nYou: ");
            String userInput = scanner.nextLine();
            
            // Clean and process input (Basic NLP pipeline steps: Lowercasing & Punctuation removal)
            String processedInput = preprocessInput(userInput);

            if (processedInput.equals("bye")) {
                System.out.println("Chatbot: " + responses.get("bye"));
                break;
            }

            String response = getChatbotResponse(processedInput);
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }

    /**
     * Simple NLP Preprocessing technique
     */
    private static String preprocessInput(String input) {
        if (input == null) return "";
        // Convert to lowercase and remove common punctuation markers
        return input.toLowerCase()
                    .replaceAll("[?.!,:]", "")
                    .trim();
    }

    /**
     * Rule-based Machine Learning/Matching Intent Logic
     */
    private static String getChatbotResponse(String input) {
        if (input.isEmpty()) {
            return "I didn't catch that. Could you say it again?";
        }

        // Direct FAQ Match
        if (responses.containsKey(input)) {
            return responses.get(input);
        }

        // Tokenization/Keyword Matching Scan (Advanced fallback rule logic)
        String[] words = input.split("\\s+");
        for (String word : words) {
            if (responses.containsKey(word)) {
                return "You mentioned '" + word + "'. " + responses.get(word);
            }
        }

        // Default response when NLP engine can't resolve intent
        return "I'm still learning! I don't quite understand that question yet. Could you rephrase it?";
    }
}
