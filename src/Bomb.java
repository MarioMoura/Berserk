

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bomb extends Projectile {
   double x;
   double y;
   int largura;
   int altura;
   double angle;
   int cont = 0;
   Rectangle collision;
   
   AudioClip explosion = Applet.newAudioClip(getClass().getResource("/Sound/explosion.wav"));
   public Bomb(int x,int y,int algura,int largura,int angle){
       this.x = x;
       this.y = y;
       this.altura = algura;
       this.largura = largura;
       this.angle = angle;
       collision = new Rectangle((int)this.x, (int)this.y, this.largura, this.altura);
   }
   public void criarBomb(Graphics g) {
       g.fillRect((int)x, (int)y, largura, altura);

    }

    public void moverBomba() {
        x = x + 6 * Math.cos(Math.toRadians(angle));
        y = y - 6 * Math.sin(Math.toRadians(angle));
        collision = new Rectangle((int)this.x-2, (int)this.y-2, this.largura+4, this.altura+4);
    }
    public void detonarBomb (Hero hero){
        for (int i = 0; i < 36; i++) {
            hero.tiro[i] = new Tiro((int) x, (int) y, 5, 5, 10*i,6);
            
        }
        explosion.play();
        hero.bomb = null;
        hero.settiro = 0;
        hero.reload(3000);
        
    }
}

