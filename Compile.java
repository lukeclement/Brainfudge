import java.util.*;
import java.io.*;

public class Compile{
  public static void main(String[] args){
    int[] base=new int[1000000];
    int pointer=0;
    String fileName="test.txt";
    String line=null;
    List<Character> commands=new ArrayList<>();
    try{
      FileReader fr=new FileReader(fileName);
      BufferedReader br=new BufferedReader(fr);
      while((line=br.readLine())!=null){
        if(!line.substring(0,1).equals("#")){
          for(int i=0;i<line.length();i++){
            commands.add(line.charAt(i));
          }
        }
      }
      br.close();
    }catch(Exception e){}
    List<Integer> charPos=new ArrayList<>();
    Scanner scan=new Scanner(System.in);
    for(int i=0;i<commands.size();i++){
      switch(commands.get(i)){
        case '>': pointer++; break;
        case '<': pointer--; break;
        case '+': base[pointer]++; break;
        case '-': base[pointer]--; break;
        case '[': charPos.add(i); break;
        case ']': if(base[pointer]!=0){
          i=charPos.get(charPos.size()-1);
        }else{charPos.remove(charPos.size()-1);}break;
        case '.': System.out.print((char)base[pointer]);break;
        case ',': base[pointer]=(int)(scan.nextLine().charAt(0));
      }
    }
  }
}
