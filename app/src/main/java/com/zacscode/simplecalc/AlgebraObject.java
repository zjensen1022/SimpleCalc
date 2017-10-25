package com.zacscode.simplecalc;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zjens on 10/23/2017.
 */

abstract class AlgebraObject {
    double value;
    double valueExponent;
    private ArrayList<Character> ops; //operators
    public char[] operators;
    private Map<Character, AlgebraObject> vars; //variables
    public char[] variables;
    public AlgebraObject[] variableExponents;
    private ArrayList<Integer> par; //parenthesis
    public int parenthesis;
    public int sideOfEquation;
    public char sign;

    double parenthesisExponent;
    int startPosition;
    int endPoition;
    int id;

    protected static boolean isOperator(char c){
        return c == '+' || c == '-' || c =='*' || c=='/';
    }

}
