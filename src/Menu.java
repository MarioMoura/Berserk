
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Menu {
    Sprites sprite = new Sprites();
    Game game;
    Image  A = new ImageIcon(getClass().getResource("/Letras/A.png")).getImage();
    Image  B = new ImageIcon(getClass().getResource("/Letras/B.png")).getImage();
    Image  K = new ImageIcon(getClass().getResource("/Letras/K.png")).getImage();
    Image  N = new ImageIcon(getClass().getResource("/Letras/N.png")).getImage();
    Image  R = new ImageIcon(getClass().getResource("/Letras/R.png")).getImage();
    Image  S = new ImageIcon(getClass().getResource("/Letras/S.png")).getImage();
    Image  E = new ImageIcon(getClass().getResource("/Letras/E.png")).getImage();
    Image  T = new ImageIcon(getClass().getResource("/Letras/T.png")).getImage();
    Image  D = new ImageIcon(getClass().getResource("/Letras/D.png")).getImage();
    Image  M = new ImageIcon(getClass().getResource("/Letras/M.png")).getImage();
    Image  C = new ImageIcon(getClass().getResource("/Letras/C.png")).getImage();
    Image  H = new ImageIcon(getClass().getResource("/Letras/H.png")).getImage();
    Image  U = new ImageIcon(getClass().getResource("/Letras/U.png")).getImage();
    Image  Y = new ImageIcon(getClass().getResource("/Letras/Y.png")).getImage();
    Image  F = new ImageIcon(getClass().getResource("/Letras/F.png")).getImage();
    Image  O = new ImageIcon(getClass().getResource("/Letras/O.png")).getImage();
    Image  V = new ImageIcon(getClass().getResource("/Letras/V.png")).getImage();
    Image  I = new ImageIcon(getClass().getResource("/Letras/I.png")).getImage();
    Image  Z = new ImageIcon(getClass().getResource("/Letras/Z.png")).getImage();
    Image  J = new ImageIcon(getClass().getResource("/Letras/J.png")).getImage();
    Image  G = new ImageIcon(getClass().getResource("/Letras/G.png")).getImage();
    Image  L = new ImageIcon(getClass().getResource("/Letras/l.png")).getImage();
    Image  point = new ImageIcon(getClass().getResource("/Letras/point.png")).getImage();
    
    int x = 415;
    int y = 250;
    
    int x1 = 520;
    int y1 = 320;
    
    int cvx = 200;
    JLabel arrow11 =new JLabel();
    JLabel arrow12 =new JLabel();
    JLabel arrow21 =new JLabel();
    JLabel arrow22 =new JLabel();
    
    public void drawMenu(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, 1200, 700);
        g.setColor(Color.red);
        g.fillRect(37, 35, 1120, 600);
        
        
        g.drawImage(B, x, y, game);
        g.drawImage(E, x+50, y, game);
        g.drawImage(R, x+100, y, game);
        g.drawImage(S, x+150, y, game);
        g.drawImage(E, x+200, y, game);
        g.drawImage(R, x+250, y, game);
        g.drawImage(K, x+300, y, game);
        
        g.drawImage(A, x1, y1, 25,25 , game);
        g.drawImage(R, x1+30, y1, 25,25 , game);
        g.drawImage(E, x1+60, y1, 25,25 , game);
        g.drawImage(N, x1+90, y1, 25,25 , game);
        g.drawImage(A, x1+120, y1, 25,25 , game);
    }
    public void drawVictory(Graphics g,Game game){
        g.setColor(Color.black);
        g.fillRect(0, 0, 1200, 700);
        
        g.setColor(Color.RED);
        g.fillRect(37, 35, 1120, 600);
        g.setColor(Color.black);
        g.fillRect(580, 0, 20, 700);
        if (game.victory == 1) {
            g.drawImage(V, 280, 170, game);
            g.drawImage(I, 280, 170+50, game);
            g.drawImage(C, 280, 170+100, game);
            g.drawImage(T, 280, 170+150, game);
            g.drawImage(O, 280, 170+200, game);
            g.drawImage(R, 280, 170+250, game);
            g.drawImage(Y, 280, 170+300, game);
            
            g.drawImage(D, 860, 170, game);
            g.drawImage(E, 860, 170+50, game);
            g.drawImage(F, 860, 170+100, game);
            g.drawImage(E, 860, 170+150, game);
            g.drawImage(A, 860, 170+200, game);
            g.drawImage(T, 860, 170+250, game);
        }
        if (game.victory == 2) {
            g.drawImage(D, 280, 170, game);
            g.drawImage(E, 280, 170+50, game);
            g.drawImage(F, 280, 170+100, game);
            g.drawImage(E, 280, 170+150, game);
            g.drawImage(A, 280, 170+200, game);
            g.drawImage(T, 280, 170+250, game);
            
            
            g.drawImage(V, 860, 170, game);
            g.drawImage(I, 860, 170+50, game);
            g.drawImage(C, 860, 170+100, game);
            g.drawImage(T, 860, 170+150, game);
            g.drawImage(O, 860, 170+200, game);
            g.drawImage(R, 860, 170+250, game);
            g.drawImage(Y, 860, 170+300, game);
        }
        
    }
    public void drawCharacterChoiceMenu(Graphics g,Game game){
        g.setColor(Color.black);
        g.fillRect(0, 0, 1200, 700);
        g.setColor(Color.red);
        g.fillRect(37, 35, 1120, 600);
        g.drawImage(sprite.choiceviwer, cvx, 200, game);
        
        drawChoice1(g, game);
        
        g.drawImage(sprite.choiceviwer, cvx+600, 200, game);
        
        drawChoice2(g, game);
        
        
        
//        g.drawImage(sprite.arrow1, cvx+200, 260, 50, 50, game);
//        g.drawImage(sprite.arrow2, cvx-80, 260, 50, 50, game);
//        g.drawImage(sprite.arrow1, cvx+800, 260, 50, 50, game);
//        g.drawImage(sprite.arrow2, cvx+520, 260, 50, 50, game);
        
        g.drawImage(C, 110+200, 50, game);
        g.drawImage(H, 110+200+50, 50, game);
        g.drawImage(O, 110+200+100, 50, game);
        g.drawImage(O, 110+200+150, 50, game);
        g.drawImage(S, 110+200+200, 50, game);
        g.drawImage(E, 110+200+250, 50, game);
        g.drawImage(Y, 110+550, 50, game);
        g.drawImage(O, 110+600, 50, game);
        g.drawImage(U, 110+650, 50, game);
        g.drawImage(R, 110+700, 50, game);
        
        g.drawImage(C, 320+50-10, 100, game);
        g.drawImage(H, 320+100-10, 100, game);
        g.drawImage(A, 320+150-10, 100, game);
        g.drawImage(R, 320+200-10, 100, game);
        g.drawImage(A, 320+250-10, 100, game);
        g.drawImage(C, 320+300-10, 100, game);
        g.drawImage(T, 320+350-10, 100, game);
        g.drawImage(E, 320+400-10, 100, game);
        g.drawImage(R, 320+450-10, 100, game);
        
        game.add(game.arrow11);
        game.add(game.arrow12);
        game.add(game.arrow21);
        game.add(game.arrow22);
        
        
    }
    
    private void drawChoice1(Graphics g, Game game){
        if (game.equipment1 == 1) {
            g.drawImage(sprite.motoboy00, 255, 260, game);
            g.drawImage(R, 165, 400, game);
            g.drawImage(A, 165+50, 400, game);
            g.drawImage(Z, 165+100, 400, game);
            g.drawImage(O, 165+150, 400, game);
            g.drawImage(R, 165+200, 400, game);
        }
        if (game.equipment1 == 2) {
            g.drawImage(sprite.ares00, 255, 260, game);
            g.drawImage(A,20+ 170, 400, game);
            g.drawImage(R,20+ 170+50, 400, game);
            g.drawImage(E,20+ 170+100, 400, game);
            g.drawImage(S,20+ 170+150, 400, game);
        }
        if (game.equipment1 == 3) {
            g.drawImage(sprite.bomber00, 255, 260, game);
            g.drawImage(J, 45, 400, game);
            g.drawImage(U, 45+50, 400, game);
            g.drawImage(G, 45+100, 400, game);
            g.drawImage(G, 45+150, 400, game);
            g.drawImage(E, 45+200, 400, game);
            g.drawImage(R, 45+250, 400, game);
            g.drawImage(N, 45+300, 400, game);
            g.drawImage(A, 45+350, 400, game);
            g.drawImage(U, 45+400, 400, game);
            g.drawImage(T, 45+450, 400, game);
        }
        if (game.equipment1 == 4) {
            g.drawImage(sprite.lf00, 255, 260, game);
            g.drawImage(M, 55, 400, game);
            g.drawImage(R, 115, 400, game);
            g.drawImage(point, 115+50, 400+20, game);
            g.drawImage(C, 115+100, 400, game);
            g.drawImage(A, 115+150, 400, game);
            g.drawImage(N, 115+200, 400, game);
            g.drawImage(N, 115+250, 400, game);
            g.drawImage(O, 115+300, 400, game);
            g.drawImage(L, 115+350, 400, game);
            g.drawImage(I, 115+400, 400, game);
            
        }
        
    }
    private void drawChoice2(Graphics g, Game game){
        if (game.equipment2 == 1) {
            g.drawImage(sprite.motoboy00, 255+600, 260, game);
            g.drawImage(R, 600+165, 400, game);
            g.drawImage(A, 600+165+50, 400, game);
            g.drawImage(Z, 600+165+100, 400, game);
            g.drawImage(O, 600+165+150, 400, game);
            g.drawImage(R, 600+165+200, 400, game);
        }
        if (game.equipment2 == 2) {
            g.drawImage(sprite.ares00, 255+600, 260, game);
            g.drawImage(A,620+ 170, 400, game);
            g.drawImage(R,620+ 170+50, 400, game);
            g.drawImage(E,620+ 170+100, 400, game);
            g.drawImage(S,620+ 170+150, 400, game);
        }
        if (game.equipment2 == 3) {
            g.drawImage(sprite.bomber00, 255+600, 260, game);
            g.drawImage(J, 600+45, 400, game);
            g.drawImage(U, 600+45+50, 400, game);
            g.drawImage(G, 600+45+100, 400, game);
            g.drawImage(G, 600+45+150, 400, game);
            g.drawImage(E, 600+45+200, 400, game);
            g.drawImage(R, 600+45+250, 400, game);
            g.drawImage(N, 600+45+300, 400, game);
            g.drawImage(A, 600+45+350, 400, game);
            g.drawImage(U, 600+45+400, 400, game);
            g.drawImage(T, 600+45+450, 400, game);
        }
        if (game.equipment2 == 4) {
            g.drawImage(sprite.lf00, 255+600, 260, game);
            g.drawImage(M, 570+55, 400, game);
            g.drawImage(R, 570+115, 400, game);
            g.drawImage(point, 570+115+50, 400+20, game);
            g.drawImage(C, 570+115+100, 400, game);
            g.drawImage(A, 570+115+150, 400, game);
            g.drawImage(N, 570+115+200, 400, game);
            g.drawImage(N, 570+115+250, 400, game);
            g.drawImage(O, 570+115+300, 400, game);
            g.drawImage(L, 570+115+350, 400, game);
            g.drawImage(I, 570+115+400, 400, game);
        }
        
    }
    public void drawModeChoiceMenu(Graphics g,Game game){
        g.setColor(Color.black);
        g.fillRect(0, 0, 1200, 700);
        g.setColor(Color.red);
        g.fillRect(37, 35, 1120, 600);
        
        g.drawImage(B, x, y-150, game);
        g.drawImage(E, x+50, y-150, game);
        g.drawImage(R, x+100, y-150, game);
        g.drawImage(S, x+150, y-150, game);
        g.drawImage(E, x+200, y-150, game);
        g.drawImage(R, x+250, y-150, game);
        g.drawImage(K, x+300, y-150, game);
        g.drawImage(A, x1, y1-150, 25,25 , game);
        g.drawImage(R, x1+30, y1-150, 25,25 , game);
        g.drawImage(E, x1+60, y1-150, 25,25 , game);
        g.drawImage(N, x1+90, y1-150, 25,25 , game);
        g.drawImage(A, x1+120, y1-150, 25,25 , game);
    }
    
    
}
