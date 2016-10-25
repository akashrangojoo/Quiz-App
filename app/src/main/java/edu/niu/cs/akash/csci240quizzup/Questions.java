package edu.niu.cs.akash.csci240quizzup;

/**
 * Created by Akash on 4/26/2016.
 */
public class Questions {

    public String questionArray[];
    public String answerArray[];
    public String options[][];


    public Questions(int weekID) {
        questionArray = new String[5];
        answerArray = new String[5];
        options= new String[5][4];
        // initializing question array and options array and answer array according to week.
        if(weekID==1) {
            questionArray[0] = "Most lines in a C++ program end with a";
            answerArray[0] = "; (semi-colon)";
            options[0][0] = "; (semi-colon)";
            options[0][1] = ": (colon )";
            options[0][2] = "} (closing brace)";
            options[0][3] = ") (closing parenthesis)";

            questionArray[1] = "main() marks the beginning of a C++ program. What C++ reserved word precedes it?";
            answerArray[1] = "int";
            options[1][0] = "using";
            options[1][1] = "#include";
            options[1][2] = "int";
            options[1][3] = "a }";

            questionArray[2] = "What is the correct way to declare an integer variable named \"score\"?";
            answerArray[2] = "int score;";
            options[2][0] = "int score";
            options[2][1] = "score: integer;";
            options[2][2] = "integer score;";
            options[2][3] = "int score;";

            questionArray[3] = "When you write an illegal C++ statement and try to compile and run the program, you will get a";
            answerArray[3] = "compile error";
            options[3][0] = "machine crash";
            options[3][1] = "run-time error";
            options[3][2] = "compile error";
            options[3][3] = "headache";

            questionArray[4] = "Which data type has the largest range?";
            answerArray[4] = "double";
            options[4][0] = "int";
            options[4][1] = "float";
            options[4][2] = "double";
            options[4][3] = "it depends on the input value";
        }

        if(weekID==2) {
            questionArray[0] = "What instruction will display data on the screen from a C++ program?";
            answerArray[0] = "cout";
            options[0][0] = "int";
            options[0][1] = "cin";
            options[0][2] = "Abracadabra";
            options[0][3] = "cout";

            questionArray[1] = "What is the value of the expression 25 % 3";
            answerArray[1] = "8";
            options[1][0] = "1";
            options[1][1] = "8.33";
            options[1][2] = "8";
            options[1][3] = "0";

            questionArray[2] = "Which of the following increments x by 1?";
            answerArray[2] = "x++";
            options[2][0] = "x=1";
            options[2][1] = "1++";
            options[2][2] = "x+1";
            options[2][3] = "x++";

            questionArray[3] = "It is legal and acceptable to have two local variables in two different functions with the same name and the same data type.";
            answerArray[3] = "true";
            options[3][0] = "true";
            options[3][1] = "false";
            options[3][2] = "only if they always have different values";
            options[3][3] = "only if they always have same values";

            questionArray[4] = "What will happen if a char is cout'd as an int?";
            answerArray[4] = "the ASCII value of the character will be displayed";
            options[4][0] = "the character will be displayed";
            options[4][1] = "the ASCII value of the character will be displayed";
            options[4][2] = "run-time error";
            options[4][3] = "it will not compile";
        }

    }
}
