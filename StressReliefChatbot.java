import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class StressReliefChatbot {
    private static String toLowerCase(String str) {
        return str.toLowerCase();
    }
    private static String getMotivationalQuote() {
        List<String> quotes = new ArrayList<>();
        quotes.add("Believe you can and you're halfway there.");
        quotes.add("The only way to do great work is to love what you do.");
        quotes.add("You are never too old to set another goal or to dream a new dream.");
        quotes.add("The best way to predict the future is to create it.");

        Random rand = new Random();
        int index = rand.nextInt(quotes.size());
        return quotes.get(index);
    }
    private static String getStressReliefSuggestion(String mood) {
        if (mood.contains("stress") || mood.contains("anxiety")) {
            return "Try a deep breathing exercise: Inhale slowly for 4 seconds, hold for 4 seconds, exhale for 4 seconds, and repeat.";
        } else if (mood.contains("angry")) {
            return "Consider a short walk or some physical exercise to help release pent-up energy.";
        } else if (mood.contains("sad")) {
            return "Listen to your favorite uplifting music or try journaling your feelings.";
        } else {
            return "It's important to take regular breaks and engage in activities that you enjoy.";
        }
    }
    private static String getMentalHealthResources() {
        return "If you need more support, consider reaching out to a mental health professional or visiting resources like the National Mental Health Association or Mental Health America.";
    }
    private static String getResponse(String message) {
        String lowerMessage = toLowerCase(message);
        if (lowerMessage.contains("mood") || lowerMessage.contains("stress")) {
            return getStressReliefSuggestion(lowerMessage);
        } else if (lowerMessage.contains("quote")) {
            return getMotivationalQuote();
        } else if (lowerMessage.contains("resources")) {
            return getMentalHealthResources();
        } else {
            return "I'm here to help. You can ask me about stress relief exercises, motivational quotes, or mental health resources.";
        }
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String userInput;
            System.out.println("Stress Relief AI Chatbot - Type 'exit' to quit.");
            while (true) {
                System.out.print("You: ");
                userInput = scanner.nextLine();
                if (toLowerCase(userInput).equals("hi")) {
                    System.out.println("hello how can i help you! ");
                }
                
                if (toLowerCase(userInput).equals("exit")) {
                    System.out.println("Chatbot: Goodbye! Take care of yourself!");
                    break;
                }
                
                String response = getResponse(userInput);
                System.out.println("Chatbot: " + response);
            }
        }
    }
}