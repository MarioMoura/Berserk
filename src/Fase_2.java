
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fase_2 {

    Game game;

    int location = 1;

    private int px1 = 15;
    private int py1 = 15;
    private int px2 = 1150;
    private int py2 = 15;
    private int px3 = 15;
    private int py3 = 650;
    private int px4 = 15;
    private int py4 = 15;
    private int px5 = 780;
    private int py5 = 15;
    private int px6 = 300;
    private int py6 = 370;

    int me[] = {1, 1, 1, 1};
    int w[] = {1, 1, 1, 1};
    int mx[] = new int[4];
    int my[] = new int[4];
    int tm[] = new int[4];
    int tx;
    int ty;
    Rectangle parede1 = new Rectangle(px1, py1, 20, 650);
    Rectangle parede2 = new Rectangle(px2, py2, 20, 650);
    Rectangle parede3 = new Rectangle(px3, py3, 1155, 20);
    Rectangle parede4 = new Rectangle(px4, py4, 390, 20);
    Rectangle parede5 = new Rectangle(px5, py5, 390, 20);
    Rectangle parede6a = new Rectangle(px6 + 2, py6, 596, 2);
    Rectangle parede6b = new Rectangle(px6 + 2, py6 + 18, 596, 2);
    Rectangle parede6c = new Rectangle(px6 + 598, py6 + 1, 2, 18);
    Rectangle parede6d = new Rectangle(px6, py6 + 1, 2, 18);

    Rectangle monstro1 = null;
    Rectangle monstro2 = null;
    Rectangle monstro3 = null;
    Rectangle monstro4 = null;

    public Fase_2() {
        mx[0] = 1005;
        my[0] = 500;
        mx[1] = 1005;
        my[1] = 250;
        mx[2] = 515;
        my[2] = 75;
        mx[3] = 165;
        my[3] = 230;
    }

    public void desenharParedes(Graphics g) {
        

    }

    public void colisoesFase_2(Game game, Hero hero, Tiro[] tiro) {
        if (hero.collision.intersects(parede1) | hero.collision.intersects(parede6c) | hero.collision.intersects(parede2)
                | hero.collision.intersects(parede6d) | hero.collision.intersects(parede3) | hero.collision.intersects(parede6a)
                | hero.collision.intersects(parede4) | hero.collision.intersects(parede5) | hero.collision.intersects(parede6b)) {

            hero.danimation = 1;
        }
        for (int i = 0; i <= hero.getContTiro(); i++) {
            if (tiro[i] != null) {
                if (parede1.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede2.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede3.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede4.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede5.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede6a.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede6b.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede6c.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede6d.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)) {
                    tiro[i] = null;
                }
            }

        }
        for (int i = 0; i <= hero.getContTiro(); i++) {

            if (monstro1 != null && tiro[i] != null) {
                if (monstro1.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)) {
                    me[0] = 0;
                    hero.tiro[i] = null;

                    monstro1 = null;
                }
            }
            if (monstro2 != null && tiro[i] != null) {
                if (monstro2.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)) {
                    me[1] = 0;
                    hero.tiro[i] = null;

                    monstro2 = null;
                }
            }
            if (monstro3 != null && tiro[i] != null) {
                if (monstro3.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)) {
                    me[2] = 0;
                    hero.tiro[i] = null;

                    monstro3 = null;
                }
            }
            if (monstro4 != null && tiro[i] != null) {
                if (monstro4.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)) {
                    me[3] = 0;
                    hero.tiro[i] = null;

                    monstro4 = null;
                }
            }
        }
    }

    public void desenharMonstros(Graphics g) {

        if (me[0] == 1) {
            g.setColor(Color.yellow);
            g.fillRect(mx[0], my[0], 30, 30);
            monstro1 = new Rectangle(mx[0], my[0], 30, 30);
        }
        if (me[1] == 1) {
            g.setColor(Color.yellow);
            g.fillRect(mx[1], my[1], 30, 30);
            monstro2 = new Rectangle(mx[1], my[1], 30, 30);
        }
        if (me[2] == 1) {
            g.setColor(Color.yellow);
            g.fillRect(mx[2], my[2], 30, 30);
            monstro3 = new Rectangle(mx[2], my[2], 30, 30);
        }
        if (me[3] == 1) {
            g.setColor(Color.yellow);
            g.fillRect(mx[3], my[3], 30, 30);
            monstro4 = new Rectangle(mx[3], my[3], 30, 30);
        }

    }

    public void movermonstros(Fase_2 fase2) {
        if (fase2.w[3] == 1) {
            if (fase2.mx[3] == 165) {
                fase2.my[3]++;

            }
            if (fase2.mx[3] == 166) {
                fase2.my[3]--;
            }
            if (fase2.my[3] == 550) {
                fase2.mx[3]++;
            }
            if (fase2.my[3] == 225) {
                fase2.mx[3]--;
            }

        }

    }
    public void setLocation(Game game){
        
    }
}
