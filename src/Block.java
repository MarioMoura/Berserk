
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block {

    int x;
    int y;
    int height;
    int width;

    Rectangle up;
    Rectangle down;
    Rectangle right;
    Rectangle left;
    Rectangle central;

    int dmg;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dmg = dmg;
        defineBlocks();
    }

    public void defineBlocks() {
        left = new Rectangle(x, y + 4, 1, height - 8);
        up = new Rectangle(x + 4, y, width - 8, 1);
        right = new Rectangle(x + width - 1, y + 4, 1, height - 8);
        down = new Rectangle(x + 4, y + height - 1, width - 8, 1);
        central = new Rectangle(x, y, width, height);
    }

    public void drawBlock(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
        g.setColor(Color.yellow);
        g.fillRect(left.x, left.y, left.width, left.height);
        g.fillRect(up.x, up.y, up.width, up.height);
        g.fillRect(right.x, right.y, right.width, right.height);
        g.fillRect(down.x, down.y, down.width, down.height);

    }

    public void intersect(Hero hero) {
        if (hero.collision.intersects(left)) {
            hero.x += -hero.movespeed;
        } else if (hero.collision.intersects(down)) {
            hero.y += hero.movespeed;
        } else if (hero.collision.intersects(up)) {
            hero.y += -hero.movespeed;
        } else if (hero.collision.intersects(right)) {
            hero.x += hero.movespeed;
        }
    }
    public boolean intersects(Rectangle r){
        if (r.intersects(central)) {
            return true;
            
        }else{
            return false;
        }
    }
}
