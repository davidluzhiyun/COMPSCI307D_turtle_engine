package oolala;

/*

The biggest thing to know about parsing is that you can input an entire document as a string, then use the String.split("\\s+") method
to break it up by removing all whitespaces(spaces, tabs, newlines).

Also, you can split most of the commands into 3 categories (Command itself[penup, pendown], command + number[fd, bk],
 and command plus an infinite amount of commands[tell])
Once you do that, you can probably have the parsing follow a strict pattern for doing commands.






 */


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler   {

static String[] allCommands = {"fd","bk","lt","rt","pendown","penup","showt","hidet","home","stamp"};
static String[] numCommands = {"fd","bk","lt","ft"};
static String[] nonNumCommands ={"pendown","penup","showt","hidet","home","stamp"};







  public static boolean verifyFile() throws IOException {

ArrayList<String> allCommands2 = (ArrayList<String>) Arrays.asList(allCommands);
ArrayList<String> numCommands2 = (ArrayList<String>) Arrays.asList(numCommands);

    String file = Files.readString(Path.of("src/main/resources/test.txt"));
    String[] newFile = file.split("\\s+");
    for (int i = 0; i < newFile.length; i++) {
      String current = newFile[i];
      if(!allCommands2.contains(current)){
        try{
          Integer test = Integer.parseInt(current);
           if(numCommands2.contains(newFile[i-1])){
              //switch for all num commands
          }
        }
        catch (NumberFormatException e){
          return false;
        }

      }
      else{


        //switch for all normal commands



      }

    }


    return true;
  }



public static String[] readFile() throws IOException{

  String file = Files.readString(Path.of("src/main/resources/test.txt"));
  String[] newFile = file.split("\\s+");
  verifyFile();


return newFile;
}


}
