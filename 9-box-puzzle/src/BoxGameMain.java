import awtextras.AbsoluteConstraints;
import awtextras.AbsoluteLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class BoxGameMain extends JFrame {
    ArrayList<Node> leaderboard = new ArrayList();
    String path_1;
    String getCd = System.getProperty("user.dir");
//    String name  = JOptionPane.showInputDialog((Component)null, "RULES\nTo move:  If there is an empty adjacent square next to a tile, a tile may be slid into the empty location.\nTo win:  The tiles must be moved back into their original positions, numbered 1 through 8.\n\nEnter your name: ", "9 Box-Puzzle", 3);
    // CHANGES {
    String name="";

    public BoxGameMain() {
        this.initComponents();
        showNameInputDialog();

        boolean flag1 = false;

        for(int i = 0; i < this.getCd.length() - 1; ++i) {
            if (this.getCd.substring(i, i + 1).equals("/")) {
                flag1 = true;
                break;
            }
        }

        if (!flag1) {
            this.getCd = this.getCd + "\\database.txt";
        } else {
            this.getCd = this.getCd + "/database.txt";
        }

        this.path_1 = this.getCd;
        System.out.println(this.path_1);

        // Display a welcome message with the entered name
        if (name != null && !name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Welcome to the game " + name + "!");
        } else {
            JOptionPane.showMessageDialog(this, "No name entered. Please enter a valid name to play the game.");
        }
    }

    private void showNameInputDialog() {
        // Create a text field for name input
        JTextField nameField = new JTextField(10);

        // Create a panel to display the rules and input field
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("<html>RULES<br>"
                + "To move: If there is an empty adjacent square next to a tile, "
                + "a tile may be slid into the empty location.<br>"
                + "To win: The tiles must be moved back into their original positions, "
                + "numbered 1 through 8.<br><br>Enter your name: </html>"));
        panel.add(nameField);

        // Show dialog with only "OK" button
        int result = JOptionPane.showOptionDialog(
                this,
                panel,
                "9 Box-Puzzle",
                JOptionPane.OK_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[]{"OK"}, // Only "OK" button
                "OK"
        );

        // Get name from the text field after clicking "OK"
        if (result == JOptionPane.OK_OPTION) {
            name = nameField.getText();
        }
    }
    // }

    int Counter;
    private JFrame frame;
    private JButton eighth;
    private JButton empty;
    private JButton fifth;
    private JButton first;
    private JButton fourth;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JLabel jblNumberOfMoves;
    private JButton jbtnExit;
    private JButton jbtnReset;
    private JButton jbtnReset1;
    private JButton jbtnSolution;
    private JButton second;
    private JButton seventh;
    private JButton sixth;
    private JButton third;

    // CHANGES
    boolean f = true;
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jbtnExit = new JButton();
        this.jbtnReset = new JButton();
        this.jbtnSolution = new JButton();
        this.jPanel3 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jPanel4 = new JPanel();
        this.first = new JButton();
        this.third = new JButton();
        this.second = new JButton();
        this.fifth = new JButton();
        this.fourth = new JButton();
        this.sixth = new JButton();
        this.eighth = new JButton();
        this.seventh = new JButton();
        this.empty = new JButton();
        this.jPanel5 = new JPanel();
        this.jblNumberOfMoves = new JLabel();
        this.jLabel3 = new JLabel();
        this.jbtnReset1 = new JButton();
        this.setDefaultCloseOperation(3);
        this.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent evt) {
                BoxGameMain.this.formWindowActivated(evt);
            }
        });
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4));
        // Exit Button
        this.jbtnExit.setFont(new Font("American Typewriter", 0, 50));
        this.jbtnExit.setText("Exit");
        this.jbtnExit.setBackground(Color.black); // Black background
        this.jbtnExit.setForeground(new Color(255, 255, 255)); // White text for better visibility
        this.jbtnExit.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4)); // Dynamic reddish-orange border
        this.jbtnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.jbtnExitActionPerformed(evt);
                // CHANGES
                // for exit error
                f = false;
            }
        });

        // New Game Button
        this.jbtnReset.setFont(new Font("American Typewriter", 0, 36));
        this.jbtnReset.setText("New Game");
        this.jbtnReset.setBackground(Color.black); // Black background
        this.jbtnReset.setForeground(new Color(255, 255, 255)); // White text for better visibility
        this.jbtnReset.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4)); // Dynamic reddish-orange border
        this.jbtnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.jbtnResetActionPerformed(evt);
            }
        });

        // Solution Button
        this.jbtnSolution.setFont(new Font("American Typewriter", 0, 50));
        this.jbtnSolution.setText("Solution");
        this.jbtnSolution.setBackground(Color.black); // Black background
        this.jbtnSolution.setForeground(new Color(255, 255, 255)); // White text for better visibility
        this.jbtnSolution.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4)); // Dynamic reddish-orange border
        this.jbtnSolution.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.jbtnSolutionActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(31, 32767).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addComponent(this.jbtnExit, -2, 234, -2).addComponent(this.jbtnReset, -2, 234, -2).addComponent(this.jbtnSolution, -2, 234, -2)).addGap(27, 27, 27)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(25, 32767).addComponent(this.jbtnSolution, -2, 155, -2).addGap(18, 18, 18).addComponent(this.jbtnReset, -2, 155, -2).addGap(18, 18, 18).addComponent(this.jbtnExit, -2, 155, -2).addGap(116, 116, 116)));
        this.getContentPane().add(this.jPanel1, new AbsoluteConstraints(1090, 140, 300, 650));
        this.jbtnSolution.setBackground(new Color(0, 0, 0));  // added
        //this.jPanel3.setBorder(BorderFactory.createLineBorder(new Color(255, 69, 0), 4));
        this.jLabel1.setFont(new Font("American Typewriter", 0, 88));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("9 Box Puzzle Game");
        this.jLabel1.setForeground(Color.white);

        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(288, 288, 288).addComponent(this.jLabel1, -2, 942, -2).addContainerGap(142, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -1, -1, 32767).addContainerGap()));
        this.getContentPane().add(this.jPanel3, new AbsoluteConstraints(10, 10, 1380, -1));
        this.jPanel4.setBackground(Color.black);   // addded
        this.jPanel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4));

        this.first.setFont(new Font("American Typewriter", 0, 60));
        this.first.setText("1");
        this.first.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.firstActionPerformed(evt);
            }
        });

        this.third.setFont(new Font("American Typewriter", 0, 60));
        this.third.setText("3");
        this.third.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.thirdActionPerformed(evt);
            }
        });
        this.second.setFont(new Font("American Typewriter", 0, 60));
        this.second.setText("2");
        this.second.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.secondActionPerformed(evt);
            }
        });
        this.fifth.setFont(new Font("American Typewriter", 0, 60));
        this.fifth.setText("5");
        this.fifth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.fifthActionPerformed(evt);
            }
        });
        this.fourth.setFont(new Font("American Typewriter", 0, 60));
        this.fourth.setText("4");
        this.fourth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.fourthActionPerformed(evt);
            }
        });
        this.sixth.setFont(new Font("American Typewriter", 0, 60));
        this.sixth.setText("6");
        this.sixth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.sixthActionPerformed(evt);
            }
        });
        this.eighth.setFont(new Font("American Typewriter", 0, 60));
        this.eighth.setText("8");
        this.eighth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.eighthActionPerformed(evt);
            }
        });
        this.seventh.setFont(new Font("American Typewriter", 0, 60));
        this.seventh.setText("7");
        this.seventh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.seventhActionPerformed(evt);
            }
        });
        this.empty.setFont(new Font("American Typewriter", 0, 60));
        this.empty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.emptyActionPerformed(evt);
            }
        });

        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.first, -1, -1, 32767).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.second, -2, 233, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.third, -2, 234, -2)).addGroup(Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.fourth, -1, 231, 32767).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.fifth, -2, 233, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.sixth, -2, 234, -2)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.seventh, -1, 231, 32767).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.eighth, -2, 233, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.empty, -2, 234, -2))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.first, -2, 155, -2).addComponent(this.second, -2, 155, -2).addComponent(this.third, -2, 155, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.fourth, -2, 155, -2).addComponent(this.fifth, -2, 155, -2).addComponent(this.sixth, -2, 155, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.seventh, -2, 155, -2).addComponent(this.eighth, -2, 155, -2).addComponent(this.empty, -2, 155, -2)).addContainerGap(17, 32767)));
        this.getContentPane().add(this.jPanel4, new AbsoluteConstraints(10, 140, 730, 540));
        this.jPanel4.setBackground(Color.black);
        this.jPanel5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4));
        this.jblNumberOfMoves.setFont(new Font("American Typewriter", 0, 50));
        this.jblNumberOfMoves.setHorizontalAlignment(0);

        this.jblNumberOfMoves.setText("0");

        this.jblNumberOfMoves.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4));
        this.jblNumberOfMoves.setOpaque(true);
        this.jblNumberOfMoves.setBackground(Color.black);    // added
        this.jblNumberOfMoves.setForeground(new Color(255, 255, 255));
        this.jLabel3.setBackground(Color.black);   // Set background to black
        this.jLabel3.setOpaque(true);  // Make sure the background color is applied
        this.jLabel3.setForeground(new Color(255, 255, 255)); // Set text color to white
        this.jLabel3.setFont(new Font("American Typewriter", 0, 50)); // Set font
        this.jLabel3.setHorizontalAlignment(0); // Center align text
        this.jLabel3.setText("Moves:"); // Set the text label

        this.jPanel3.setBackground(Color.BLACK);  // A shorthand for black color
        this.jLabel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4));
        this.jbtnReset1.setBackground(Color.black); // Set background to black
        this.jbtnReset1.setOpaque(true);  // Make sure the background color is applied
        this.jbtnReset1.setForeground(new Color(255, 255, 255)); // Set text color to white
        this.jbtnReset1.setFont(new Font("American Typewriter", 0, 36)); // Set font
        this.jbtnReset1.setText("LeaderBoard"); // Set the button text
        this.jbtnReset1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 255), 4)); // Set border

        this.jbtnReset1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BoxGameMain.this.jbtnReset1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(24, 24, 24).addGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.jbtnReset1, -1, -1, 32767).addComponent(this.jblNumberOfMoves, -1, 245, 32767).addComponent(this.jLabel3, -1, 245, 32767)).addContainerGap(23, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(35, 35, 35).addComponent(this.jLabel3, -2, 150, -2).addGap(29, 29, 29).addComponent(this.jblNumberOfMoves, -2, 150, -2).addGap(18, 18, 18).addComponent(this.jbtnReset1, -2, 155, -2).addContainerGap(105, 32767)));
        this.getContentPane().add(this.jPanel5, new AbsoluteConstraints(770, 140, 300, 650));
        this.pack();
        this.setLocationRelativeTo((Component)null);
    }

    void EmptySpotChecker(JButton Button1, JButton Button2) {
        String ShuffleNumber = Button2.getText();
        if (ShuffleNumber == "") {
            Button2.setText(Button1.getText());
            Button1.setText("");
            this.SolutionChecker();
        }

    }

// its for shuffling the numbers
    public void Shuffle() {
        int[] arr = new int[9];
        Boolean[] done = new Boolean[9];

        int ct;
        for(ct = 0; ct < 9; ++ct) {
            done[ct] = false;
        }

        ct = 0;
        // outer do while will run till all the numbers have been shown
        Boolean flag;
        do {
            int nums;
            flag = true;
            // inner do while will run till the a number that is not yet shown will be generated
            do {
                while(true) {
                    Random rand = new Random();
                    nums = rand.nextInt(9);
                    // ever number will be there except 0
                    if (nums == 0) {
                        continue;
                    }
                    break;
                }
            } while(done[nums]);

            done[nums] = true;
            // saving that value to the array
            arr[ct + 1] = nums;
            ++ct;

            for(int k = 1; k < 9; ++k) {
                // if not all number not done it will remain false
                if (!done[k]) {
                    flag = false;
                }
            }
        } while(!flag);
        // putting the sequence to the boxes
        this.first.setText(Integer.toString(arr[1]));
        this.second.setText(Integer.toString(arr[2]));
        this.third.setText(Integer.toString(arr[3]));
        this.fourth.setText(Integer.toString(arr[4]));
        this.fifth.setText(Integer.toString(arr[5]));
        this.sixth.setText(Integer.toString(arr[6]));
        this.seventh.setText(Integer.toString(arr[7]));
        this.eighth.setText(Integer.toString(arr[8]));
        this.empty.setText("");

        // Check if the shuffled puzzle is solvable; if not, reshuffle
        if (!isSolvable()) {
            Shuffle();
        }
    }

    public void SolutionChecker() {
        String b1 = this.first.getText();
        String b2 = this.second.getText();
        String b3 = this.third.getText();
        String b4 = this.fourth.getText();
        String b5 = this.fifth.getText();
        String b6 = this.sixth.getText();
        String b7 = this.seventh.getText();
        String b8 = this.eighth.getText();
        // checking if all numbers from 1 to 8 is present or not in sequence
        if (b1.indexOf(49) == 0 && b2.indexOf(50) == 0 && b3.indexOf(51) == 0 && b4.indexOf(52) == 0 && b5.indexOf(53) == 0 && b6.indexOf(54) == 0 && b7.indexOf(55) == 0 && b8.indexOf(56) == 0) {
            JOptionPane.showMessageDialog(this, "YOU WIN THE GAME", "PUZZLE GAME", 1);
            // CHANGES for sol error
            this.jblNumberOfMoves.setText(Integer.toString(this.Counter+1));
            try {
                String var10000 = Integer.toString(this.Counter + 1);
                String x = var10000 + " " + this.name + "\n";
                BufferedWriter out = new BufferedWriter(new FileWriter(this.path_1, true));
                out.write(x);
                out.close();
            } catch (Exception var11) {
                System.out.println("Error");
            }
            this.Counter = -1;
        }

        ++this.Counter;
        this.jblNumberOfMoves.setText(Integer.toString(this.Counter));
    }

    private void firstActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.first, this.second);
        this.EmptySpotChecker(this.first, this.fourth);
    }

    private void thirdActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.third, this.second);
        this.EmptySpotChecker(this.third, this.sixth);
    }

    private void secondActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.second, this.first);
        this.EmptySpotChecker(this.second, this.fifth);
        this.EmptySpotChecker(this.second, this.third);
    }

    private void fifthActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.fifth, this.second);
        this.EmptySpotChecker(this.fifth, this.sixth);
        this.EmptySpotChecker(this.fifth, this.fourth);
        this.EmptySpotChecker(this.fifth, this.eighth);
    }

    private void fourthActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.fourth, this.first);
        this.EmptySpotChecker(this.fourth, this.fifth);
        this.EmptySpotChecker(this.fourth, this.seventh);
    }

    private void sixthActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.sixth, this.third);
        this.EmptySpotChecker(this.sixth, this.empty);
        this.EmptySpotChecker(this.sixth, this.fifth);
    }

    private void eighthActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.eighth, this.seventh);
        this.EmptySpotChecker(this.eighth, this.empty);
        this.EmptySpotChecker(this.eighth, this.fifth);
    }

    private void seventhActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.seventh, this.fourth);
        this.EmptySpotChecker(this.seventh, this.eighth);
    }

    private void emptyActionPerformed(ActionEvent evt) {
        this.EmptySpotChecker(this.empty, this.sixth);
        this.EmptySpotChecker(this.empty, this.eighth);
    }

    private void jbtnExitActionPerformed(ActionEvent evt) {
        this.frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(this.frame, "Do You want to exit the game?", "PUZZLE GAME", 0) == 0) {
            System.exit(0);
        }

    }

    private void jbtnResetActionPerformed(ActionEvent evt) {
        if (JOptionPane.showConfirmDialog(this.frame, "Do You want a new Game?", "PUZZLE GAME", 0) == 0) {
            f = false;
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    (new BoxGameMain()).setVisible(true);
                    BoxGameMain.this.setVisible(false);
                }
            });
        }
        else {
            f = false;
        }
    }

    private void jbtnSolutionActionPerformed(ActionEvent evt) {
        this.first.setText(Integer.toString(1));
        this.second.setText(Integer.toString(2));
        this.third.setText(Integer.toString(3));
        this.fourth.setText(Integer.toString(4));
        this.fifth.setText(Integer.toString(5));
        this.sixth.setText(Integer.toString(6));
        this.seventh.setText(Integer.toString(7));
        this.eighth.setText(Integer.toString(8));
        this.empty.setText("");
        this.Counter = 0;
        this.jblNumberOfMoves.setText(Integer.toString(this.Counter));
        JOptionPane.showMessageDialog(this, "GRID HAS BEEN SOLVED", "PUZZLE GAME", 1);
    }


private boolean isSolvable() {
        ArrayList<Integer> tiles = new ArrayList<>();
        
        // Collect the current tile numbers, excluding the empty space
        tiles.add(Integer.parseInt(first.getText()));
        tiles.add(Integer.parseInt(second.getText()));
        tiles.add(Integer.parseInt(third.getText()));
        tiles.add(Integer.parseInt(fourth.getText()));
        tiles.add(Integer.parseInt(fifth.getText()));
        tiles.add(Integer.parseInt(sixth.getText()));
        tiles.add(Integer.parseInt(seventh.getText()));
        tiles.add(Integer.parseInt(eighth.getText()));
        
        int inversions = 0;
        for (int i = 0; i < tiles.size() - 1; i++) {
            for (int j = i + 1; j < tiles.size(); j++) {
                if (tiles.get(i) > tiles.get(j)) {
                    inversions++;
                }
            }
        }
        
        // For 8-puzzle, if inversions count is even, the puzzle is solvable
        return inversions % 2 == 0;
    }

    private void formWindowActivated(WindowEvent evt) {
        // CHANGES
        // when it comes from exit? it has false..then it again becomes true
        if (f) {
            this.Shuffle();
            while (!isSolvable()) {
                this.Shuffle();
            }
        }
        f = true;
    }

    private void jbtnReset1ActionPerformed(ActionEvent evt) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new LeaderBoard()).setVisible(true);
        }
        });
    }


    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Metal".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(BoxGameMain.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(BoxGameMain.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(BoxGameMain.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(BoxGameMain.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new BoxGameMain()).setVisible(true);
            }
        });
    }
}
