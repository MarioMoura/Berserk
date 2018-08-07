
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fase_3 {

    Game game;

    int location = 1;

    private int px1 = 15;
    private int py1 = 15;
    private int px2 = 780;
    private int py2 = 15;
    private int px3 = 15;
    private int py3 = 15;
    private int px4 = 1150;
    private int py4 = 15;
    private int px5 = 15;
    private int py5 = 410;
    private int px6 = 1150;
    private int py6 = 410;
    private int px7 = 780;
    private int py7 = 625;
    private int px8 = 15;
    private int py8 = 625;
    private int px9 = 200;
    private int py9 = 190;
    private int px10 = 950;
    private int py10 = 190;
    private int px11 = 300;
    private int py11 = 130;
    private int px12 = 300;
    private int py12 = 510;

    Rectangle parede1 = new Rectangle(px1, py1, 390, 20);
    Rectangle parede2 = new Rectangle(px2, py2, 390, 20);
    Rectangle parede3 = new Rectangle(px3, py3, 20, 235);
    Rectangle parede4 = new Rectangle(px4, py4, 20, 235);
    Rectangle parede5 = new Rectangle(px5, py5, 20, 235);
    Rectangle parede6 = new Rectangle(px6, py6, 20, 235);
    Rectangle parede7 = new Rectangle(px7, py7, 390, 20);
    Rectangle parede8 = new Rectangle(px8, py8, 390, 20);
    Rectangle parede9 = new Rectangle(px9, py9, 20, 300);
    Rectangle parede10 = new Rectangle(px10, py10, 20, 300);
    Rectangle parede11 = new Rectangle(px11, py11, 600, 20);
    Rectangle parede12 = new Rectangle(px12, py12, 600, 20);

    public void desenharParedes(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(px1, py1, 390, 20);
        g.fillRect(px2, py2, 390, 20);
        g.fillRect(px3, py3, 20, 235);
        g.fillRect(px4, py4, 20, 235);
        g.fillRect(px4, py4, 20, 235);
        g.fillRect(px5, py5, 20, 235);
        g.fillRect(px6, py6, 20, 235);
        g.fillRect(px7, py7, 390, 20);
        g.fillRect(px8, py8, 390, 20);
        g.fillRect(px9, py9, 20, 300);
        g.fillRect(px10, py10, 20, 300);
        g.fillRect(px11, py11, 600, 20);
        g.fillRect(px12, py12, 600, 20);
    }

    public void colisoesFase_3(Game game, Hero hero, Tiro[] tiro) {
        if (hero.collision.intersects(parede1) | hero.collision.intersects(parede2)
                | hero.collision.intersects(parede3) | hero.collision.intersects(parede4)
                | hero.collision.intersects(parede5) | hero.collision.intersects(parede6)
                | hero.collision.intersects(parede7) | hero.collision.intersects(parede8)
                | hero.collision.intersects(parede9) | hero.collision.intersects(parede10)
                | hero.collision.intersects(parede11) | hero.collision.intersects(parede12)) {
            hero.danimation = 1;
        }
        for (int i = 0; i <= hero.getContTiro(); i++) {
            if (tiro[i] != null) {
                if (parede1.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede2.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede3.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede4.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede5.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede7.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede8.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede9.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede10.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede11.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)
                        | parede12.intersects(tiro[i].x, tiro[i].y, tiro[i].largura, tiro[i].altura)) {
                    tiro[i] = null;
                }
            }

        }
    }

}
