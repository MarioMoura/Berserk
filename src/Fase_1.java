
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;
import org.lwjgl.system.CallbackI;

public class Fase_1 {

    Image obs1 = new ImageIcon(getClass().getResource("/Imagens/obs1.png")).getImage();
    Image obs2 = new ImageIcon(getClass().getResource("/Imagens/obs2.png")).getImage();
    Image obs3 = new ImageIcon(getClass().getResource("/Imagens/obs3.png")).getImage();
    Image obs4 = new ImageIcon(getClass().getResource("/Imagens/obs4.png")).getImage();
    Image obs5 = new ImageIcon(getClass().getResource("/Imagens/obs5.png")).getImage();
    Image obs6 = new ImageIcon(getClass().getResource("/Imagens/obs6.png")).getImage();
    Image obs7 = new ImageIcon(getClass().getResource("/Imagens/obs7.png")).getImage();
    Image obs8 = new ImageIcon(getClass().getResource("/Imagens/obs8.png")).getImage();
    Image obs9 = new ImageIcon(getClass().getResource("/Imagens/obs9.png")).getImage();
    Image poste = new ImageIcon(getClass().getResource("/Imagens/poste.png")).getImage();
    Image poste2 = new ImageIcon(getClass().getResource("/Imagens/poste2.png")).getImage();
    Image map = new ImageIcon(getClass().getResource("/Imagens/Map.png")).getImage();
    Image texture = new ImageIcon(getClass().getResource("texture.png")).getImage();

    URL url = getClass().getResource("/Sound/impact.wav");
    AudioClip impact = Applet.newAudioClip(url);

    Game game;
    
    Hero hero;

    int location = 1;
    
    Block block[] = new Block[22];

    public Fase_1() {
        block[0]= new Block(0, 120, 1200, 10);
        //g.fillRect(0, 0, 10, 700);
        block[1] = new Block(0, 0, 10, 700);
        //g.fillRect(1190, 0, 10, 700);
        block[2] = new Block(1190, 0, 10, 700);
        //g.fillRect(0, 660, 1200, 10);
        block[3] = new Block(0, 660, 1200, 10);
        
       // g.fillRect(350, 450, 20, 100);
        block[4] = new Block(350, 450, 20, 100);
        //g.fillRect(350, 570, 250, 20);
        block[5] = new Block(350, 570, 250, 20);
        
        //g.fillRect(830, 240, 20, 100);
        block[6] = new Block(830, 240, 20, 100);
        //g.fillRect(600, 200, 250, 20);
        block[7] = new Block(600,200,250,20);
        
        //g.fillRect(70, 370, 180, 20);
        block[8] = new Block(70,370,180,20);
        //g.fillRect(950, 410, 180, 20);
        block[9] = new Block(950,410,180,20);
        
        //g.fillRect(580, 310, 20, 80);
        block[10] = new Block(580,310,20,80);
        //g.fillRect(600, 410, 20, 80);
        block[11] = new Block(600,410,20,80);
        
        //g.fillRect(450, 130, 20, 180);
        block[12] = new Block(450,130,20,180);
        //g.fillRect(730, 480, 20, 180);
        block[13] = new Block(730,480,20,180);
        //g.fillRect(300, 210, 140, 20);
        block[14] = new Block(300,210,140,20);
        //g.fillRect(760, 560, 140, 20);
        block[15] = new Block(760,560,140,20);
        //g.fillRect(160, 130, 20, 140);
        block[16] = new Block(160,130,20,140);
        //g.fillRect(1020, 520, 20, 140);
        block[17] = new Block(1020,520,20,140);
    
    }
    

    
    
    public void desenharParede(Graphics g,Hero hero1,Hero hero2) {

        
        g.drawImage(map, -5, -16, game);
        g.setColor(Color.black);
        g.fillRect(10, 11, 1180, 110);
        g.setColor(Color.green);
        g.fillRect(600, 40, (int)((hero2.life/hero2.lifetotal)*590), 50);
        g.fillRect(10, 40, (int)((hero1.life/hero1.lifetotal)*590), 50);
        
    }

    public void colisoesFase_1(Game game, Projectile[] tiro, Hero hero) {
        for (int i = 0; i < 18; i++) {
            block[i].intersect(hero);
        }
        
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 18; j++) {
                if (tiro[i].collision.intersects(block[j].central)) {
                    tiro[i] = new Projectile();
                }
            }
        }
        
        

    }

}
