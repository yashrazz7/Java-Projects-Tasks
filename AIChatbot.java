import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AIChatbot {
   
    private static final Map<String, String> responses = new HashMap<>();

    static {
      
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


    private static String preprocessInput(String input) {
        if (input == null) return "";

        return input.toLowerCase()
                    .replaceAll("[?.!,:]", "")
                    .trim();
    }

    private static String getChatbotResponse(String input) {
        if (input.isEmpty()) {
            return "I didn't catch that. Could you say it again?";
        }

   
        if (responses.containsKey(input)) {
            return responses.get(input);
        }


        String[] words = input.split("\\s+");
        for (String word : words) {
            if (responses.containsKey(word)) {
                return "You mentioned '" + word + "'. " + responses.get(word);
            }
        }


        return "I'm still learning! I don't quite understand that question yet. Could you rephrase it?";
    }
}
