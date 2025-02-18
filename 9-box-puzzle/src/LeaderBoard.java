import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

public class LeaderBoard extends JFrame {
    ArrayList<Node> board = new ArrayList();
    String getCd = System.getProperty("user.dir");
    String path_1;
    String[] columns = new String[]{"Player Name", "Score(moves)"};
    DefaultTableModel tableModel;
    private JScrollPane jScrollPane1;
    private JTable leaderboard;

    public LeaderBoard() {
        this.tableModel = new DefaultTableModel(this.columns, 0);
        this.initComponents();
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
        File ff1 = new File(this.path_1);
        this.board.clear();

        try {
            Scanner sc1 = new Scanner(ff1);

            while(true) {
                String temp = sc1.nextLine();
                System.out.println(temp + "less");
                if (temp.length() == 0 || temp.charAt(0) == '\n') {
                    System.out.println("ArrayList Ended\n");
                    break;
                }

                String[] t1 = temp.split(" ");
                System.out.println(temp);
                Node obj = new Node(t1[1], Integer.parseInt(t1[0]));
                this.board.add(obj);
            }
        } catch (Exception var8) {
            System.out.println("Exception!!!!" + var8);
        }

        String[][] data = new String[100][100];
        if (this.board != null) {
            Collections.sort(this.board, new Comparator());

            for(int i1 = 0; i1 < this.board.size(); ++i1) {
                int scoree = ((Node)this.board.get(i1)).score1;
                String name2 = ((Node)this.board.get(i1)).name;
                Object[] objs = new Object[]{name2, scoree};
                this.tableModel.addRow(objs);
            }

            this.tableModel.fireTableDataChanged();
        }

    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.leaderboard = new JTable();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.leaderboard.setModel(this.tableModel);
        this.jScrollPane1.setViewportView(this.leaderboard);
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 733, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 497, 32767).addContainerGap()));
        this.pack();
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
            Logger.getLogger(LeaderBoard.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(LeaderBoard.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(LeaderBoard.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(LeaderBoard.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new LeaderBoard()).setVisible(true);
            }
        });
    }
}
