package src.algo_240313.단어_뒤집기_17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] chars=br.readLine().toCharArray();
        StringBuilder sb=new StringBuilder("");
        Stack<Character> stack=new Stack<>();

        int i=0;
        while(i<chars.length){
            if(chars[i]=='<'){
                while(true){
                    sb.append(chars[i]);
                    if(chars[i]=='>') break;
                    i++;
                }
            }//if <>

            else {
                while(i<chars.length&&chars[i]!=' ' && (chars[i]!='<'||chars[i]!='>')){
                    stack.add(chars[i]);
                    i++;
                }
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                if (chars[i]==' '){
                    sb.append(' ');
                    i++;
                }
            }
        }//전체 while
        System.out.println(sb.toString());
    }
}
