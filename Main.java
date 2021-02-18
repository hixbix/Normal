import java.util.*;
class Main{
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args){
    boolean gamemanag = true;
    int backcheck = 0;
    while(gamemanag){
      if(backcheck==0)System.out.println("Welcome! you are playing Tic-Tac-Toe. You can choose the spot by choosing 1-9. Good luck :)");
      System.out.println();
      int x = startchoice();
      System.out.println();
      if(x==11){
        System.out.println("you are currently playing againts the computer. Have fun! :)");
        System.out.println("difficulty: easy");
      }
      else if(x==2) System.out.println("you are currently playing player againts player. Have fun! :)");
      else if (x==12){
        System.out.println("you are currently playing againts the computer. Have fun! :)");
        System.out.println("difficulty: normal");
      }
      else if(x==13){
        System.out.println("you are currently playing againts the computer. Have fun! :)");
        System.out.println("difficulty: hard");
      }
      System.out.println();
      int num;
      char[][]gameboard ={{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}}; 
      System.out.println("the board right now:");
      printboard(gameboard);
      while(true){
        if(x==13){
          num = BotmoveH(gameboard,'O');
          while(num==0) num = BotmoveH(gameboard,'O');
          insert(gameboard,num,"player2");
          System.out.println("__________________________________");
          System.out.println("bot's choise");
          System.out.println();
          printboard(gameboard);
          if(!check(gameboard,'O').equals("")){
            if(check(gameboard,'O').equals("win")) System.out.println("the bot wins! good luck next time :(");
            else if(check(gameboard,'O').equals("tie")) System.out.println("its a tie!");
            break;
          }
        }
        System.out.println("player 1 please enter the place you want to choose(1-9)");
        num = input.nextInt();
        while(istaken(gameboard,num)){
          System.out.println("the position you chose is taken or not possible, please choose different place");
          num = input.nextInt();
        }
        insert(gameboard,num,"player1");
        System.out.println("__________________________________");
        System.out.println();
        printboard(gameboard);
        if(!check(gameboard,'X').equals("")){
          if(check(gameboard,'X').equals("win")) System.out.println("player number 1 wins!");
          else if(check(gameboard,'X').equals("tie")) System.out.println("its a tie!");
          break;
        }
        else if(x==2){
          System.out.println("player 2 please enter the place you want to choose(1-9)");
          num = input.nextInt();
          while(istaken(gameboard,num)){
            System.out.println("the position you chose is taken or not possible, please choose different place");
            num = input.nextInt();
          }
          insert(gameboard,num,"player2");
          System.out.println("__________________________________");
          System.out.println();
          printboard(gameboard);
          if(!check(gameboard,'O').equals("")){
            if(check(gameboard,'O').equals("win")) System.out.println("player number 2 wins!");
            else if(check(gameboard,'O').equals("tie")) System.out.println("its a tie!");
            break;
          } 
        }
        else if(x==11){
          num = (int)(Math.random()*9)+1;
          while(istaken(gameboard,num)){
            num = (int)(Math.random()*9)+1;
          }
          insert(gameboard,num,"player2");
          System.out.println("__________________________________");
          System.out.println();
          printboard(gameboard);
          if(!check(gameboard,'O').equals("")){
            if(check(gameboard,'O').equals("win")) System.out.println("the bot wins! good luck next time :(");
            else if(check(gameboard,'O').equals("tie")) System.out.println("its a tie!");
            break;
          }
        }
        else if(x==12){
          num = Botmove(gameboard,'O');
          while(num==0) num = Botmove(gameboard,'O');
          insert(gameboard,num,"player2");
          System.out.println("__________________________________");
          System.out.println();
          printboard(gameboard);
          if(!check(gameboard,'O').equals("")){
            if(check(gameboard,'O').equals("win")) System.out.println("the bot wins! good luck next time :(");
            else if(check(gameboard,'O').equals("tie")) System.out.println("its a tie!");
            break;
          }
        }
      }
      System.out.println();
      System.out.print("do you want to play another game? (answer true or false): ");
      gamemanag = input.nextBoolean();
      System.out.println();
      if(!gamemanag)System.out.println("thank you for playing my game! good bye :)");
      else{
        System.out.println("welcome back! choose what you want:");
        backcheck = 1;
      }
      
    }

  }

  public static void printboard(char[][]gameboard){
    for(int i = 0; i< 3; i++){
      for(int j = 0; j<3; j++){
        if(j==0)System.out.print("|"+" ");
        System.out.print(gameboard[i][j] +" "+ "|" +" ");
      }
      System.out.println();
      if(i!=2)System.out.println("-------------");
    }
  }

  public static void insert(char[][]gameboard,int pos, String player){
    char symb = ' ';
    if(player.equals("player1")) symb = 'X';
    else if (player.equals("player2")) symb = 'O';
    switch(pos){
      case 1: 
        gameboard[0][0] = symb;
        break;
      case 2: 
        gameboard[0][1] = symb;
        break;
      case 3: 
        gameboard[0][2] = symb;
        break;
      case 4: 
        gameboard[1][0] = symb;
        break;
      case 5: 
        gameboard[1][1] = symb;
        break;
      case 6: 
        gameboard[1][2] = symb;
        break;
      case 7: 
        gameboard[2][0] = symb;
        break;
      case 8:
        gameboard[2][1] = symb;
        break;
      case 9:
        gameboard[2][2] = symb;
        break;
      default: 
        break;
    }
  }

  public static String check(char gameboard[][], char symb){
    if(gameboard[0][0]==symb&&gameboard[0][1]==symb&&gameboard[0][2]==symb) return "win";
    else if(gameboard[1][0]==symb&&gameboard[1][1]==symb&&gameboard[1][2]==symb) return "win";
    else if(gameboard[2][0]==symb&&gameboard[2][1]==symb&&gameboard[2][2]==symb) return "win";
    else if(gameboard[0][0]==symb&&gameboard[1][0]==symb&&gameboard[2][0]==symb) return "win";
    else if(gameboard[0][1]==symb&&gameboard[1][1]==symb&&gameboard[2][1]==symb) return "win";
    else if(gameboard[0][2]==symb&&gameboard[1][2]==symb&&gameboard[2][2]==symb) return "win";
    else if(gameboard[0][0]==symb&&gameboard[1][1]==symb&&gameboard[2][2]==symb) return "win";
    else if(gameboard[2][0]==symb&&gameboard[1][1]==symb&&gameboard[0][2]==symb) return "win";
    else{
      int counter = 0;
      for(int i=0;i<3; i++){
        for(int j=0;j<3;j++){
          if(gameboard[i][j] == ' ')counter++;
        }
      }
      if(counter == 0) return "tie";
      else return "";
    }
  }

  public static boolean istaken(char[][]gameboard, int pos){
    switch(pos){
      case 1: 
        return gameboard[0][0] != ' ';
      case 2: 
        return gameboard[0][1] != ' ';
      case 3: 
        return gameboard[0][2] != ' ';
      case 4: 
        return gameboard[1][0] != ' ';
      case 5: 
        return gameboard[1][1] != ' ';
      case 6: 
        return gameboard[1][2] != ' ';
      case 7: 
        return gameboard[2][0] != ' ';
      case 8:
        return gameboard[2][1] != ' ';
      case 9:
        return gameboard[2][2] != ' ';
      default: 
        return true;
    }
  }

  public static int startchoice(){
    System.out.print("for you againts the computer press '1' and for two players press '2': ");
    int op = input.nextInt();
    while(op!=1&&op!=2){
      System.out.println("the number you typed is not correct, please enter again");
      op = input.nextInt();
    }
    if(op == 1){
      System.out.println();
      System.out.println("there is three options:");
      System.out.println("1. easy");
      System.out.println("2. normal");
      System.out.println("3. hard");
      System.out.print("your choise: ");
      int b = input.nextInt();
      while(b!=1&&b!=2&&b!=3){
        System.out.println("the number you typed is not correct, please enter again");
        b = input.nextInt();
      }
      if(b==1) return 11;
      if(b==2) return 12;
      if(b==3) return 13; 
    } 
    return 2;   
  }

  public static int BotmoveH(char[][]gameboard, char symb){
    char[][] restore = new char[3][3];
    for(int i=0;i<gameboard.length;i++) restore[i] = gameboard[i].clone();
    int counter = 0;
    for(int i=0; i<3;i++){
      for(int j=0; j<3;j++){
        for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
        counter += 1;
        if(istaken(gameboard,counter));
        else{
          insert(gameboard,counter,"player2");
          if(check(gameboard,symb).equals(""));
          else if(check(gameboard,symb).equals("win")) return counter;
          else return counter;
        }
      }
    }
    for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
    counter = 0;
    for(int i=0; i<3;i++){
      for(int j=0; j<3;j++){
        for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
        counter += 1;
        if(istaken(gameboard,counter));
        else{
          insert(gameboard,counter,"player1");
          if(check(gameboard,'X').equals(""));
          else if(check(gameboard,symb).equals("win")) return counter;
          else return counter;
        }
      }
    }
    for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
    return bot_help(gameboard,'O');
  }

  public static int Botmove(char[][]gameboard, char symb){
    char[][] restore = new char[3][3];
    for(int i=0;i<gameboard.length;i++) restore[i] = gameboard[i].clone();
    int counter = 0;
    for(int i=0; i<3;i++){
      for(int j=0; j<3;j++){
        for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
        counter += 1;
        if(istaken(gameboard,counter));
        else{
          insert(gameboard,counter,"player2");
          if(check(gameboard,symb).equals(""));
          else if(check(gameboard,symb).equals("win")) return counter;
          else return counter;
        }
      }
    }
    for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
    counter = 0;
    for(int i=0; i<3;i++){
      for(int j=0; j<3;j++){
        for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
        counter += 1;
        if(istaken(gameboard,counter));
        else{
          insert(gameboard,counter,"player1");
          if(check(gameboard,'X').equals(""));
          else if(check(gameboard,symb).equals("win")) return counter;
          else return counter;
        }
      }
    }
    for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
    int[]a = new int[9];
    int count = 0;
    int d = -1;
    for(int i =0;i<3;i++){
      for(int j =0;j<3;j++){
        count +=1;
        if(d!=8)d+=1;
        if(gameboard[i][j]==' ') a[d] = count;
      }
    }
    int n = (int)(Math.random()*(a.length));
    return a[n];
  }




  public static int bot_help(char[][]gameboard, char now){
    int counter = 0;
    for(int i=0;i<3; i++){
      for(int j=0;j<3;j++){
        if(gameboard[i][j] == ' ')counter++;
      }
    }
    if(counter == 9){
      int[] arr = {1,3,5,7,9};
      int random = (int)(Math.random()*5);
      return arr[random];
    }
    char[][]gameb = new char[3][3];
    for(int i=0;i<gameb.length;i++) gameb[i] = gameboard[i].clone();
    int count = 1, score = 1;
    return bot(gameb,now,count,score);
  }


  public static int bot(char[][]gameboard, char now, int count, int score){
    if(check(gameboard,'O').equals("win")||check(gameboard,'O').equals("tie")){
      return score(gameboard);
    }
    int counter = 0;
    char [][] restore = new char[3][3];
    for(int i=0;i<gameboard.length;i++) restore[i] = gameboard[i].clone();
    int max = 0;
    for(int i = 0; i<3;i++){
      for(int j=0;j<3;j++){
        for(int k=0;k<gameboard.length;k++) gameboard[k] = restore[k].clone();
        counter++;
        if(istaken(gameboard,counter));
        else{
          if(now=='O'){
            insert(gameboard,counter,"player2");
            score = bot(gameboard,'X',count,score);
            if(score > max){
              max = score;
              count = counter;
            } 
          }
          else{
            insert(gameboard,counter,"player1");
            score = bot(gameboard,'O',count,score);
            if(score > max){
              max = score;
              count = counter;
            }
          }
        }

      }
    }
    return count;
  }

  public static int score(char[][]g){
    if(g[0][0]=='O'&&g[1][0]=='O'&&g[2][0]=='O'&&g[0][2]=='O') return 10;
    else if(g[2][0]=='O'&&g[2][1]=='O'&&g[2][2]=='O'&&g[0][2]=='O') return 9;
    else if(g[0][0]=='O'&&g[2][0]=='O'&&g[1][1]=='O'&&g[0][2]=='O') return 8;
    else if(g[0][0]=='O'&&g[2][0]=='O'&&g[2][1]=='O'&&g[2][2]=='O') return 7;
    else if(g[0][0]=='O'&&g[0][2]=='O'&&g[1][2]=='O'&&g[2][2]=='O') return 6;
    else if(g[0][0]=='O'&&g[1][1]=='O'&&g[2][2]=='O') return 5;
    else if(g[0][2]=='O'&&g[1][1]=='O'&&g[2][0]=='O') return 4;
    else if(check(g,'O').equals("win")) return 3;
    else if(check(g,'O').equals("tie")) return 2; 
    else return 1;
  }



}