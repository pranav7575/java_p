//.  Write a Java program to find the length of the longest substring without repeating characters in a given string. The program should have the following features:
//.  1. The program should take a string as input from the user.
//.  2. The program should find the length of the longest substring without repeating characters in the given string.
//.  3. The program should print the length of the longest substring without repeating characters as output.
//.  Example
//.  Input abcabcbb
//.  Output 3


import java.util.*; 
class R_Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input");
        String s = sc.next();
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[256];
            for(int j = i; j < n; j++){
                if(visited[s.charAt(j)] == true){
                    break;
                }
                else{
                    res = Math.max(res, j - i + 1);
                    visited[s.charAt(j)] = true;
                }
            }
        }
        System.out.println("Output");
        System.out.println(res);
    }
}
