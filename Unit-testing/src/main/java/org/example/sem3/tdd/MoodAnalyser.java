package org.example.sem3.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("прекрасно") || message.contains("хорошо")) return "хорошо";
        if (message.contains("сложный") || message.contains("средне")) return "средне";
        if (message.contains("неважно") || message.contains("плохо")) return "плохо";
        return "не определено";
    }
}