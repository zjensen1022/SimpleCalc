package com.zacscode.simplecalc;

/**
 * Created by zjens on 10/23/2017.
 */

public class Parenthesis extends AlgebraObject {

    public Parenthesis(String equation, int side, int start){
        startPosition = start;
        sideOfEquation = side;
        parenthesisExponent = 1;

        for(int i = start, count=0; i < equation.length(); i++){
            char c = equation.charAt(i);
            if(c == '(')
                count++;
            else if(c == ')'){
                if(count == 0){
                    endPoition = i;
                    break;
                }else{
                    count--;
                }
            }
        }

        try{
            if(equation.charAt(endPoition+1) == '^'){
                String temp = "";
                char c;

                for(int i = 0; i < equation.length();i++){
                    c = equation.charAt(i);

                    if(Character.isDigit(c) || c == '.')
                        temp += c;
                    else
                        break;

                }

                if(temp != ""){
                    parenthesisExponent = Double.parseDouble(temp);
                }
            }
        }catch(StringIndexOutOfBoundsException stringIndexOutOfBoundsException){}
    }
}
