import java.awt.Color;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class HangMan {
   
   private JFrame frame = new JFrame("Hangman by SSMCosmic");
   private JLabel label = new JLabel("");
   private ArrayList<JButton> buttonList = new ArrayList<JButton>();
   private JTextField genreText = new JTextField();
   private int totalLetters = 0;
   private int correctInputs = 0;
   private int attemptsLeft = 6;
   private String word;

   // Button Creation (A-Z)
   private JButton buttonA = new JButton("A");
   private JButton buttonB = new JButton("B");
   private JButton buttonC = new JButton("C");
   private JButton buttonD = new JButton("D");
   private JButton buttonE = new JButton("E");
   private JButton buttonF = new JButton("F");
   private JButton buttonG = new JButton("G");
   private JButton buttonH = new JButton("H");
   private JButton buttonI = new JButton("I");
   private JButton buttonJ = new JButton("J");
   private JButton buttonK = new JButton("K");
   private JButton buttonL = new JButton("L");
   private JButton buttonM = new JButton("M");
   private JButton buttonN = new JButton("N");
   private JButton buttonO = new JButton("O");
   private JButton buttonP = new JButton("P");
   private JButton buttonQ = new JButton("Q");
   private JButton buttonR = new JButton("R");
   private JButton buttonS = new JButton("S");
   private JButton buttonT = new JButton("T");
   private JButton buttonU = new JButton("U");
   private JButton buttonV = new JButton("V");
   private JButton buttonW = new JButton("W");
   private JButton buttonX = new JButton("X");
   private JButton buttonY = new JButton("Y");
   private JButton buttonZ = new JButton("Z");
  

   public HangMan() {
      this.frame.setDefaultCloseOperation(3);

      // Change Resolution Here:
      this.frame.setSize(1080, 720);

      this.frame.setResizable(false);
      this.frame.setLayout((LayoutManager)null);
      Color background = new Color(194, 178, 128);
      this.frame.getContentPane().setBackground(background);
      this.loadHangman();
      this.selectWord();
      this.createOutputBoxes();
      this.createButtons();
      this.createActionListener();
      this.displayElements();
      this.frame.setVisible(true);
   }

   private void displayElements() {
      this.frame.add(this.buttonA);
      this.frame.add(this.buttonB);
      this.frame.add(this.buttonC);
      this.frame.add(this.buttonD);
      this.frame.add(this.buttonE);
      this.frame.add(this.buttonF);
      this.frame.add(this.buttonG);
      this.frame.add(this.buttonH);
      this.frame.add(this.buttonI);
      this.frame.add(this.buttonJ);
      this.frame.add(this.buttonK);
      this.frame.add(this.buttonL);
      this.frame.add(this.buttonM);
      this.frame.add(this.buttonN);
      this.frame.add(this.buttonO);
      this.frame.add(this.buttonP);
      this.frame.add(this.buttonQ);
      this.frame.add(this.buttonR);
      this.frame.add(this.buttonS);
      this.frame.add(this.buttonT);
      this.frame.add(this.buttonU);
      this.frame.add(this.buttonV);
      this.frame.add(this.buttonW);
      this.frame.add(this.buttonX);
      this.frame.add(this.buttonY);
      this.frame.add(this.buttonZ);
      this.frame.add(this.label);
      this.frame.add(this.genreText);
   }

   private void createButtons() {
      this.buttonA.setSize(50, 50);
      this.buttonB.setSize(50, 50);
      this.buttonC.setSize(50, 50);
      this.buttonD.setSize(50, 50);
      this.buttonE.setSize(50, 50);
      this.buttonF.setSize(50, 50);
      this.buttonG.setSize(50, 50);
      this.buttonH.setSize(50, 50);
      this.buttonI.setSize(50, 50);
      this.buttonJ.setSize(50, 50);
      this.buttonK.setSize(50, 50);
      this.buttonL.setSize(50, 50);
      this.buttonM.setSize(50, 50);
      this.buttonN.setSize(50, 50);
      this.buttonO.setSize(50, 50);
      this.buttonP.setSize(50, 50);
      this.buttonQ.setSize(50, 50);
      this.buttonR.setSize(50, 50);
      this.buttonS.setSize(50, 50);
      this.buttonT.setSize(50, 50);
      this.buttonU.setSize(50, 50);
      this.buttonV.setSize(50, 50);
      this.buttonW.setSize(50, 50);
      this.buttonX.setSize(50, 50);
      this.buttonY.setSize(50, 50);
      this.buttonZ.setSize(50, 50);
      this.buttonA.setLocation(300, 400);
      this.buttonB.setLocation(350, 400);
      this.buttonC.setLocation(400, 400);
      this.buttonD.setLocation(450, 400);
      this.buttonE.setLocation(500, 400);
      this.buttonF.setLocation(550, 400);
      this.buttonG.setLocation(300, 450);
      this.buttonH.setLocation(350, 450);
      this.buttonI.setLocation(400, 450);
      this.buttonJ.setLocation(450, 450);
      this.buttonK.setLocation(500, 450);
      this.buttonL.setLocation(550, 450);
      this.buttonM.setLocation(300, 500);
      this.buttonN.setLocation(350, 500);
      this.buttonO.setLocation(400, 500);
      this.buttonP.setLocation(450, 500);
      this.buttonQ.setLocation(500, 500);
      this.buttonR.setLocation(550, 500);
      this.buttonS.setLocation(300, 550);
      this.buttonT.setLocation(350, 550);
      this.buttonU.setLocation(400, 550);
      this.buttonV.setLocation(450, 550);
      this.buttonW.setLocation(500, 550);
      this.buttonX.setLocation(550, 550);
      this.buttonY.setLocation(300, 600);
      this.buttonZ.setLocation(350, 600);
      this.genreText.setSize(150, 50);
      this.genreText.setLocation(700, 200);
      this.genreText.setEditable(false);
   }

   private void selectWord() {

      /** Generates a random number between 1 and 7, for the 7 genres
       * Chooses one of the genres, and then chooses a word from the genre
       * This is a simple implementation of HangMan
       */

      Random generator = new Random();
      int randomNumGenre = generator.nextInt(7) + 1;

      ArrayList<String> food = new ArrayList<String>();
      ArrayList<String> bird = new ArrayList<String>();
      ArrayList<String> animal = new ArrayList<String>();
      ArrayList<String> movie = new ArrayList<String>();
      ArrayList<String> country = new ArrayList<String>();
      ArrayList<String> game = new ArrayList<String>();
      ArrayList<String> videoGame = new ArrayList<String>();

      food.add("BURGER");
      food.add("PIZZA");
      food.add("PASTA");
      food.add("SUSHI");
      food.add("TACO");
      food.add("SANDWICH");
      food.add("SALAD");
      food.add("STEAK");
      food.add("FRIES");
      food.add("ICE CREAM");
      food.add("CHOCOLATE");
      food.add("SOUP");
      food.add("PANCAKES");
      food.add("WAFFLES");
      food.add("CHICKEN");

      bird.add("SPARROW");
      bird.add("EAGLE");
      bird.add("PARROT");
      bird.add("PENGUIN");
      bird.add("FLAMINGO");
      bird.add("OWL");
      bird.add("PEACOCK");
      bird.add("ROBIN");
      bird.add("SWAN");
      bird.add("HAWK");
      bird.add("DOVE");
      bird.add("WOODPECKER");
      bird.add("SEAGULL");
      bird.add("HUMMINGBIRD");
      bird.add("CROW");

      animal.add("LION");
      animal.add("TIGER");
      animal.add("ELEPHANT");
      animal.add("ZEBRA");
      animal.add("GIRAFFE");
      animal.add("BEAR");
      animal.add("MONKEY");
      animal.add("DEER");
      animal.add("WOLF");
      animal.add("FOX");
      animal.add("KANGAROO");
      animal.add("PANDA");
      animal.add("RABBIT");
      animal.add("HIPPO");
      animal.add("RHINO");

      movie.add("INCEPTION");
      movie.add("TITANIC");
      movie.add("AVATAR");
      movie.add("GLADIATOR");
      movie.add("THE MATRIX");
      movie.add("JURASSIC PARK");
      movie.add("THE GODFATHER");
      movie.add("FORREST GUMP");
      movie.add("THE DARK KNIGHT");
      movie.add("STAR WARS");
      movie.add("THE LION KING");
      movie.add("PULP FICTION");
      movie.add("SCHINDLER'S LIST");
      movie.add("FIGHT CLUB");
      movie.add("BACK TO THE FUTURE");

      country.add("USA");
      country.add("CANADA");
      country.add("BRAZIL");
      country.add("UK");
      country.add("GERMANY");
      country.add("FRANCE");
      country.add("ITALY");
      country.add("JAPAN");
      country.add("CHINA");
      country.add("INDIA");
      country.add("RUSSIA");
      country.add("AUSTRALIA");
      country.add("MEXICO");
      country.add("SOUTH KOREA");
      country.add("SOUTH AFRICA");

      game.add("CHESS");
      game.add("SOCCER");
      game.add("BASKETBALL");
      game.add("BASEBALL");
      game.add("CRICKET");
      game.add("TENNIS");
      game.add("GOLF");
      game.add("VOLLEYBALL");
      game.add("HOCKEY");
      game.add("BADMINTON");
      game.add("RUGBY");
      game.add("TABLE TENNIS");
      game.add("SWIMMING");
      game.add("BOXING");
      game.add("CYCLING");

      videoGame.add("GOD OF WAR");
      videoGame.add("RED DEAD REDEMPTION");
      videoGame.add("SUPER MARIO ODYSSEY");
      videoGame.add("FORTNITE");
      videoGame.add("MINECRAFT");
      videoGame.add("OVERWATCH");
      videoGame.add("GRAND THEFT AUTO V");
      videoGame.add("CALL OF DUTY: MODERN WARFARE");
      videoGame.add("ASSASSIN'S CREED VALHALLA");
      videoGame.add("ANIMAL CROSSING: NEW HORIZONS");
      videoGame.add("DOOM ETERNAL");

      int randomNumElement;

      // This is where a random word is selected, depending on what the genre is

      switch(randomNumGenre) {
      case 1:
         randomNumElement = generator.nextInt(food.size());
         this.word = (String)food.get(randomNumElement);
         this.genreText.setText("food");
         break;
      case 2:
         randomNumElement = generator.nextInt(bird.size());
         this.word = (String)bird.get(randomNumElement);
         this.genreText.setText("bird");
         break;
      case 3:
         randomNumElement = generator.nextInt(animal.size());
         this.word = (String)animal.get(randomNumElement);
         this.genreText.setText("animal");
         break;
      case 4:
         randomNumElement = generator.nextInt(movie.size());
         this.word = (String)movie.get(randomNumElement);
         this.genreText.setText("movie");
         break;
      case 5:
         randomNumElement = generator.nextInt(country.size());
         this.word = (String)country.get(randomNumElement);
         this.genreText.setText("country");
         break;
      case 6:
         randomNumElement = generator.nextInt(game.size());
         this.word = (String)game.get(randomNumElement);
         this.genreText.setText("game");
         break;
      case 7:
         randomNumElement = generator.nextInt(videoGame.size());
         this.word = (String)videoGame.get(randomNumElement);
         this.genreText.setText("videogame");
      }

   }

   private void loadHangman() {

      // Directory for hangman png files (do not modify png names)
      String file = "D:\\\\Coding Projects\\\\HangMan"; 
      
      ImageIcon image1 = new ImageIcon(file+"\\1.jpg");
      ImageIcon image2 = new ImageIcon(file+"\\2.jpg");
      ImageIcon image3 = new ImageIcon(file+"\\3.jpg");
      ImageIcon image4 = new ImageIcon(file+"\\4.jpg");
      ImageIcon image5 = new ImageIcon(file+"\\5.jpg");
      ImageIcon image6 = new ImageIcon(file+"\\6.jpg");
      ImageIcon image7 = new ImageIcon(file+"\\7.jpg");

      this.label.setSize(250, 250);
      this.label.setLocation(350, 120);


      // This is where the hang man 'animation' progresses, depending on incorrect answers.
      switch(this.attemptsLeft) {
      case 0:
         this.label.setIcon(image7);
         break;
      case 1:
         this.label.setIcon(image6);
         break;
      case 2:
         this.label.setIcon(image5);
         break;
      case 3:
         this.label.setIcon(image4);
         break;
      case 4:
         this.label.setIcon(image3);
         break;
      case 5:
         this.label.setIcon(image2);
         break;
      case 6:
         this.label.setIcon(image1);
      }

   }

   private void createOutputBoxes() {

      // Using a for loop to efficiently create an output box for each letter.
      // If the word has spaces, do not put an output box at that space position

      int x = 50;
      int y = 25;
      int arrIndex = 0;

      for(int i = 0; i < this.word.length(); ++i) {
         char ch = this.word.charAt(i);
         if (Character.isLetter(ch)) {
            ++this.totalLetters;
            this.buttonList.add(new JButton());
            ((JButton)this.buttonList.get(arrIndex)).setSize(50, 50);
            ((JButton)this.buttonList.get(arrIndex)).setLocation(x, y);
            this.frame.add((Component)this.buttonList.get(arrIndex));
            x += 50;
            ++arrIndex;
         } else {
            x += 50;
         }
      }

   }

   private void checkNSetLetter(JButton button) {

      int arrIndex = 0;
      boolean match = false;
      char letter = button.getText().charAt(0); // what the user guessed

      for(int i = 0; i < this.word.length(); ++i) {
         char ch = this.word.charAt(i);
         if (Character.isLetter(ch)) { // we only want to compare letters, not spaces
            if (letter == ch) {
               ((JButton)this.buttonList.get(arrIndex)).setText(Character.toString(letter));
               match = true;
               ++this.correctInputs;
            }

            ++arrIndex; // Our word may include spaces, but our buttonList does not know what a space is -> this deals with that issue
         }
      }

      if (!match) {
         --this.attemptsLeft;
         System.out.println(this.attemptsLeft);
      }

   }

   private void checkOverStatus() {
      if (this.attemptsLeft == 0 || this.correctInputs == this.totalLetters) {


         // We disable the buttons to avoid further input

         this.buttonA.setEnabled(false);
         this.buttonB.setEnabled(false);
         this.buttonC.setEnabled(false);
         this.buttonD.setEnabled(false);
         this.buttonE.setEnabled(false);
         this.buttonF.setEnabled(false);
         this.buttonG.setEnabled(false);
         this.buttonH.setEnabled(false);
         this.buttonI.setEnabled(false);
         this.buttonJ.setEnabled(false);
         this.buttonK.setEnabled(false);
         this.buttonL.setEnabled(false);
         this.buttonM.setEnabled(false);
         this.buttonN.setEnabled(false);
         this.buttonO.setEnabled(false);
         this.buttonP.setEnabled(false);
         this.buttonQ.setEnabled(false);
         this.buttonR.setEnabled(false);
         this.buttonS.setEnabled(false);
         this.buttonT.setEnabled(false);
         this.buttonU.setEnabled(false);
         this.buttonV.setEnabled(false);
         this.buttonW.setEnabled(false);
         this.buttonX.setEnabled(false);
         this.buttonY.setEnabled(false);
         this.buttonZ.setEnabled(false);

         if (this.attemptsLeft > 0) {
            this.genreText.setText("You win!");
         } else {
            this.genreText.setText("You Lose!");
         }

         int arrIndex = 0;

         // We disabled the output boxes as an effect that the game is over

         for(int i = 0; i < this.word.length(); ++i) {
            ((JButton)this.buttonList.get(arrIndex)).setEnabled(false);
            char ch = this.word.charAt(i);
            if (Character.isLetter(ch)) {
               ((JButton)this.buttonList.get(arrIndex)).setText(Character.toString(ch));
               ++arrIndex;
            }
         }

         System.out.println(arrIndex);
      }

   }


   // The following lines include checks made upon the press of each button A-Z. A better approach will be tested out in future versions

   private void createActionListener() {
      this.buttonA.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonA);
            HangMan.this.loadHangman();
            HangMan.this.buttonA.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonB.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonB);
            HangMan.this.loadHangman();
            HangMan.this.buttonB.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonC.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonC);
            HangMan.this.buttonC.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonD.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonD);
            HangMan.this.loadHangman();
            HangMan.this.buttonD.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonE.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonE);
            HangMan.this.loadHangman();
            HangMan.this.buttonE.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonF.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonF);
            HangMan.this.loadHangman();
            HangMan.this.buttonF.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonG.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonG);
            HangMan.this.loadHangman();
            HangMan.this.buttonG.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonH.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonH);
            HangMan.this.loadHangman();
            HangMan.this.buttonH.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonI.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonI);
            HangMan.this.loadHangman();
            HangMan.this.buttonI.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonJ.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonJ);
            HangMan.this.loadHangman();
            HangMan.this.buttonJ.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonK.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonK);
            HangMan.this.loadHangman();
            HangMan.this.buttonK.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonL.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonL);
            HangMan.this.loadHangman();
            HangMan.this.buttonL.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonM.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonM);
            HangMan.this.loadHangman();
            HangMan.this.buttonM.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonN.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonN);
            HangMan.this.loadHangman();
            HangMan.this.buttonN.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonO.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonO);
            HangMan.this.loadHangman();
            HangMan.this.buttonO.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonP.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonP);
            HangMan.this.loadHangman();
            HangMan.this.buttonP.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonQ.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonQ);
            HangMan.this.loadHangman();
            HangMan.this.buttonQ.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonR.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonR);
            HangMan.this.loadHangman();
            HangMan.this.buttonR.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonS.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonS);
            HangMan.this.loadHangman();
            HangMan.this.buttonS.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonT.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonT);
            HangMan.this.loadHangman();
            HangMan.this.buttonT.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonU.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonU);
            HangMan.this.loadHangman();
            HangMan.this.buttonU.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonV.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonV);
            HangMan.this.loadHangman();
            HangMan.this.buttonV.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonW.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonW);
            HangMan.this.loadHangman();
            HangMan.this.buttonW.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonX.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonX);
            HangMan.this.loadHangman();
            HangMan.this.buttonX.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonY.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonY);
            HangMan.this.loadHangman();
            HangMan.this.buttonY.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
      this.buttonZ.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            HangMan.this.checkNSetLetter(HangMan.this.buttonZ);
            HangMan.this.loadHangman();
            HangMan.this.buttonZ.setEnabled(false);
            HangMan.this.checkOverStatus();
         }
      });
   }


   // Driver class
   public static void main(String[] args) {
      new HangMan();
   }
}
    