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

public class FileHandler   {

ArrayList<String> validCommands = new ArrayList<String>();



private void populateValidCommands(){

}

  public static boolean verifyFile() throws IOException {
    String file = Files.readString(Path.of("src/main/resources/test.txt"));
    String[] newFile = file.split("\\s+");
    for (int i = 0; i < newFile.length; i++) {
      String current = newFile[i];
      try {
        int number = Integer.parseInt(current);
        String previous = newFile[i - 1];

      } catch (NumberFormatException e) {

      }

    }
    return true;
  }


/*
public static String[] readFile() throws IOException{
  String file = Files.readString(Path.of("src/main/resources/test.txt"));
  String[] newFile = file.split("\\s+");

  for(int i=0;i<newFile.length;i++){
    String current = newFile[i];
    try{
      int number = Integer.parseInt(current);
      String previous = newFile[i-1];

    }
    catch(NumberFormatException e){

    }






  }

return newFile;
}

*/
}
