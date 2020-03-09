package com.example.nazim;

public class Questions {
    public static String mQuestions[] = new String[] {
      "What is 5+5?",
      "What is 10*2?",
      "What is 7*8?",
      "What is 3*13?"
    };

    private String mChoices[][] = {
            {"1", "25", "10"},
            {"20","12","200"},
            {"15","56","65"},
            {"40","16","39"}

    };
    private String mCorrectAnswers[] = {"10","20", "56", "39"};

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }
    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
