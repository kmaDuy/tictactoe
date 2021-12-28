package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.border.EmptyBorder;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel=new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] buttons = new JButton[9];
    JButton btn = new JButton();


    boolean playerTurn_1;
    // Setup giao diện
    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800,800);

        frame.getContentPane().setBackground(new Color(50,50,50));

        frame.setLayout(new BorderLayout());

        frame.setVisible(true);

        textField.setBackground(new Color(25,25,25));

        textField.setForeground(new Color(25,255,0));

        textField.setFont(new Font("Ink Free",Font.BOLD,75));

        textField.setHorizontalAlignment(JLabel.CENTER);

        textField.setText("Tic-Tac-Toe");

        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());

        titlePanel.setBounds(0,0,800,100);



        buttonPanel.setLayout(new GridLayout(3,3));

        buttonPanel.setBackground(new Color(150,150,150));



//    tạo mới 9 button

        for(int i=0;i<9;i++) {

            buttons[i] = new JButton();

            buttonPanel.add(buttons[i]);

            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));

            buttons[i].setFocusable(false);

            buttons[i].addActionListener(this);

        }



        titlePanel.add(textField);

        frame.add(titlePanel,BorderLayout.NORTH);

        frame.add(buttonPanel);



        firstTurn();

    }
    public void firstTurn() {



        if(random.nextInt(2)==0) {

            playerTurn_1=true;

            textField.setText("X turn");

        }

        else {

            playerTurn_1=false;

            textField.setText("O turn");

        }

    }

    public boolean check() {

        //Kiểm tra X thắng

        if(

                (buttons[0].getText()=="X") &&

                        (buttons[1].getText()=="X") &&

                        (buttons[2].getText()=="X")

        ) {

            xWins(0,1,2);

            return true;


        }

        if(

                (buttons[3].getText()=="X") &&

                        (buttons[4].getText()=="X") &&

                        (buttons[5].getText()=="X")

        ) {

            xWins(3,4,5);

            return true;


        }

        if(

                (buttons[6].getText()=="X") &&

                        (buttons[7].getText()=="X") &&

                        (buttons[8].getText()=="X")

        ) {

            xWins(6,7,8);

            return true;


        }

        if(

                (buttons[0].getText()=="X") &&

                        (buttons[3].getText()=="X") &&

                        (buttons[6].getText()=="X")

        ) {

            xWins(0,3,6);

            return true;


        }

        if(

                (buttons[1].getText()=="X") &&

                        (buttons[4].getText()=="X") &&

                        (buttons[7].getText()=="X")

        ) {

            xWins(1,4,7);

            return true;


        }

        if(

                (buttons[2].getText()=="X") &&

                        (buttons[5].getText()=="X") &&

                        (buttons[8].getText()=="X")

        ) {

            xWins(2,5,8);

            return true;


        }

        if(

                (buttons[0].getText()=="X") &&

                        (buttons[4].getText()=="X") &&

                        (buttons[8].getText()=="X")

        ) {

            xWins(0,4,8);

            return true;


        }

        if(

                (buttons[2].getText()=="X") &&

                        (buttons[4].getText()=="X") &&

                        (buttons[6].getText()=="X")

        ) {

            xWins(2,4,6);

            return true;


        }

        //Kiểm tra O thắng

        if(

                (buttons[0].getText()=="O") &&

                        (buttons[1].getText()=="O") &&

                        (buttons[2].getText()=="O")

        ) {

            oWins(0,1,2);

            return true;


        }

        if(

                (buttons[3].getText()=="O") &&

                        (buttons[4].getText()=="O") &&

                        (buttons[5].getText()=="O")

        ) {

            oWins(3,4,5);

            return true;


        }

        if(

                (buttons[6].getText()=="O") &&

                        (buttons[7].getText()=="O") &&

                        (buttons[8].getText()=="O")

        ) {

            oWins(6,7,8);

            return true;


        }

        if(

                (buttons[0].getText()=="O") &&

                        (buttons[3].getText()=="O") &&

                        (buttons[6].getText()=="O")

        ) {

            oWins(0,3,6);

            return true;


        }

        if(

                (buttons[1].getText()=="O") &&

                        (buttons[4].getText()=="O") &&

                        (buttons[7].getText()=="O")

        ) {

            oWins(1,4,7);

            return true;


        }

        if(

                (buttons[2].getText()=="O") &&

                        (buttons[5].getText()=="O") &&

                        (buttons[8].getText()=="O")

        ) {

            oWins(2,5,8);

            return true;


        }

        if(

                (buttons[0].getText()=="O") &&

                        (buttons[4].getText()=="O") &&

                        (buttons[8].getText()=="O")

        ) {

            oWins(0,4,8);

            return true;


        }

        if(

                (buttons[2].getText()=="O") &&

                        (buttons[4].getText()=="O") &&

                        (buttons[6].getText()=="O")

        ) {

            oWins(2,4,6);

            return true;

        }
        else {
            return false;
        }

    }
    public void xWins(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);

        buttons[b].setBackground(Color.GREEN);

        buttons[c].setBackground(Color.GREEN);



        for(int i=0;i<9;i++) {

            buttons[i].setEnabled(false);

        }

        textField.setText("X wins");
        crtpl();

    }
    public void oWins(int a, int b, int c) {

        buttons[a].setBackground(Color.GREEN);

        buttons[b].setBackground(Color.GREEN);

        buttons[c].setBackground(Color.GREEN);



        for(int i=0;i<9;i++) {

            buttons[i].setEnabled(false);

        }

        textField.setText("O wins");
        crtpl();

    }
    //kiểm tra xem có hoà không
    public boolean isTied(){
        //kiểm tra các button khác rỗng và O không win X không win
        for(int i=0;i<9;i++){
            //nếu o hoặc x win sai
            if(check()){
                return false;
            }
            //các button phải khác rỗng
            if(buttons[i].getText()==""){
                return false;
            }
        }
        return true;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++) {

            if(e.getSource()==buttons[i]) {

                if(playerTurn_1) {

                    if(buttons[i].getText()=="") {

                        buttons[i].setForeground(new Color(255,0,0));

                        buttons[i].setText("X");

                        playerTurn_1=false;

                        textField.setText("O turn");

                        check();

                    }

                }

                else {

                    if(buttons[i].getText()=="") {

                        buttons[i].setForeground(new Color(0,0,255));

                        buttons[i].setText("O");

                        playerTurn_1=true;

                        textField.setText("X turn");

                        check();

                    }

                }

            }
        }

        if(isTied()){
            textField.setText("TIED");
            crtpl();
        }
        if (e.getSource() ==      btn) {
            newGame();
        }

    }
    public void  crtpl() {
        JPanel nPanel =new JPanel(new BorderLayout(100, 100));
        btn.setText("NEW GAME");
        btn.addActionListener(this);
        nPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        nPanel.add(btn,BorderLayout.CENTER);
        frame.add(nPanel,BorderLayout.PAGE_END);

    }

    public void newGame() {
        new TicTacToe();
    }
}