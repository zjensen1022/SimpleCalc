package com.zacscode.simplecalc;

/**
 * Created by zjens on 10/23/2017.
 */

public class Term extends AlgebraObject {

    public Term(String term, int side){
        sideOfEquation = side;

        char c;
        boolean nextCharIsExponent = false;
        boolean lastCharWasNumber = false;
        boolean lastCharWasAlpha = false;
        boolean lastCharWasVariable = false;
        String temp = "";

        for(int i = 0; i < term.length(); i++){
            c = term.charAt(i);

            if(Character.isDigit(c) || c == '.'){
                temp += c;

                if(nextCharIsExponent && i == term.length()-1){

                    if(lastCharWasVariable){

                    }else{

                    }
                }

            }else if(Character.isAlphabetic(c)){

            }else if(isOperator(c)){

            }else if(c == '^'){

            }

        }
    }

    private static void reset(boolean... tof){
        for(boolean b: tof)
            b = false;
    }

    private static double AssignExponent(String equation, int charToBeAssigned, boolean VariableExp){
        String temp ="";
        if(equation.charAt(charToBeAssigned)+1 == '^'){
            for(int i = charToBeAssigned+2; i < equation.length(); i++){

            }
            if(temp == ""){
                return 1;
            }

        }
        else{

        }
        return 0;
    }

}
