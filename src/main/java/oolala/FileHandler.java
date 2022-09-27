package oolala;

/*

The biggest thing to know about parsing is that you can input an entire document as a string, then use the String.split("\\s+") method
to break it up by removing all whitespaces(spaces, tabs, newlines).

Also, you can split most of the commands into 3 categories (Command itself[penup, pendown], command + number[fd, bk],
 and command plus an infinite amount of commands[tell])
Once you do that, you can probably have the parsing follow a strict pattern for doing commands.






 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler   {

static String[] allCommands = {"fd","bk","lt","rt","pendown","penup","showt","hidet","home","stamp"};
static String[] numCommands = {"fd","bk","lt","ft"};
static String[] nonNumCommands ={"pendown","penup","showt","hidet","home","stamp"};







  public static void readFile() throws IOException {
ArrayList<String> nonNumCommands2 = (ArrayList<String>) Arrays.asList(nonNumCommands);
ArrayList<String> numCommands2 = (ArrayList<String>) Arrays.asList(numCommands);
    String file = Files.readString(Path.of("src/main/resources/test.txt"));
    String[] newFile = file.split("\\s+");
    for (int i = 0; i < newFile.length-1; i++) {
      String current = newFile[i];
      if(numCommands2.contains(current)){
        try{
              int test = Integer.parseInt(newFile[i+1]);
              numCommandsSwitch(current,test);
        }
        catch(NumberFormatException e){
            //Error Handling for BadFIle goes here
        }
      }
      else if (nonNumCommands2.contains(current)){
        nonNumCommandsSwitch(current);
      }

      else{
        //Error Handling for Bad File goes Here
      }


    }


  }

public static void numCommandsSwitch(String x, int y){
    switch(x){



    }
}

public static void nonNumCommandsSwitch(String x){
  switch(x){

  }



}

public static void newReadFile(){
    CommandRunner commandRunner = new CommandRunner();
  BufferedReader reader;
  try {
    reader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
    String line = reader.readLine();
    while (line != null) {
    commandRunner.loadCommand(line);
    commandRunner.run(line);
      line = reader.readLine();
    }
    reader.close();
  } catch (IOException e) {
    e.printStackTrace();
  }
}
}



