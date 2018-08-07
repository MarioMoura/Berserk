
import java.awt.Graphics;
import java.awt.Rectangle;

public class Tiro extends Projectile {

    double x;
    double y;
    int largura;
    int altura;
    double angle;
    int speed;

    public Tiro(int tx, int ty, int taltura, int tlargura, int angle, int speed) {
        x = tx;
        y = ty;
        altura = taltura;
        largura = tlargura;
        this.angle = angle;
        this.speed = speed;
    }

    @Override
    public void drawProjectile(Graphics g) {
        g.fillRect((int) x, (int) y, largura, altura);

    }

    @Override
    public void moveProjectile() {
        x = x + speed * Math.cos(Math.toRadians(angle));
        y = y - speed * Math.sin(Math.toRadians(angle));
    }

    @Override
    public void defineCollison() {
        collision = new Rectangle((int) x, (int) y, largura, altura);
    }

    @Override
    public void test(Hero mainHero,Hero hero,int i) {
        if (this.collision.intersects(hero.collision)) {
            hero.addLive(-mainHero.dmg);
            mainHero.setToNull(i);
            
        }
    }
    

}
