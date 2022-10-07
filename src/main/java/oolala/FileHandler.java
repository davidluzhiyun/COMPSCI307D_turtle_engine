package oolala;

/*

The biggest thing to know about parsing is that you can input an entire document as a string, then use the String.split("\\s+") method
to break it up by removing all whitespaces(spaces, tabs, newlines).

Also, you can split most of the commands into 3 categories (Command itself[penup, pendown], command + number[fd, bk],
 and command plus an infinite amount of commands[tell])
Once you do that, you can probably have the parsing follow a strict pattern for doing commands.






 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileHandler   {

static String[] allCommands = {"fd","bk","lt","rt","pendown","penup","showt","hidet","home","stamp"};
static String[] numCommands = {"fd","bk","lt","ft"};
static String[] nonNumCommands ={"pendown","penup","showt","hidet","home","stamp"};



public static void saveFile(List<String> history){

 try {
   FileWriter fileWriter = new FileWriter("output.txt");
   BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
   for(String x:history){
     bufferedWriter.write(x);
     bufferedWriter.write("\n");
   }
   bufferedWriter.close();
 }
 catch (IOException e){
    System.out.println("Buffered reader failed and "+e.getMessage());
 }
}


public static List<String> loadFileRedux(){
  List<String> commands = new ArrayList<String>();

  try {
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter fileExtension = new FileChooser.ExtensionFilter(
        "select your text file (*.txt)", "*.txt");
    fileChooser.getExtensionFilters().add(fileExtension);
    File txtFile = fileChooser.showOpenDialog(new Stage());
    FileReader fileReader = new FileReader(txtFile);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String str;
    while ((str = bufferedReader.readLine()) != null){
      commands.add(str);
    }

  }
  catch (Exception e){
    System.out.println(e.getMessage());
  }

return commands;

}




}



