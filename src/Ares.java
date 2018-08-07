
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Ares extends Hero {

    Image ares00 = new ImageIcon(getClass().getResource("/Imagens/Ares00.png")).getImage();
    Image ares01 = new ImageIcon(getClass().getResource("/Imagens/Ares01.png")).getImage();
    Image ares02 = new ImageIcon(getClass().getResource("/Imagens/Ares02.png")).getImage();
    Image ares03 = new ImageIcon(getClass().getResource("/Imagens/Ares03.png")).getImage();
    Image ares04 = new ImageIcon(getClass().getResource("/Imagens/Ares04.png")).getImage();
    Image ares05 = new ImageIcon(getClass().getResource("/Imagens/Ares05.png")).getImage();
    Image ares06 = new ImageIcon(getClass().getResource("/Imagens/Ares06.png")).getImage();
    Image ares07 = new ImageIcon(getClass().getResource("/Imagens/Ares07.png")).getImage();
    Image ares08 = new ImageIcon(getClass().getResource("/Imagens/Ares08.png")).getImage();
    Image ares09 = new ImageIcon(getClass().getResource("/Imagens/Ares09.png")).getImage();
    Image ares10 = new ImageIcon(getClass().getResource("/Imagens/Ares10.png")).getImage();
    Image ares11 = new ImageIcon(getClass().getResource("/Imagens/Ares11.png")).getImage();
    Image ares12 = new ImageIcon(getClass().getResource("/Imagens/Ares12.png")).getImage();
    Image ares13 = new ImageIcon(getClass().getResource("/Imagens/Ares13.png")).getImage();
    Image ares14 = new ImageIcon(getClass().getResource("/Imagens/Ares14.png")).getImage();
    Image ares15 = new ImageIcon(getClass().getResource("/Imagens/Ares15.png")).getImage();
    Image ares16 = new ImageIcon(getClass().getResource("/Imagens/Ares16.png")).getImage();
    Image ares17 = new ImageIcon(getClass().getResource("/Imagens/Ares17.png")).getImage();
    Image ares18 = new ImageIcon(getClass().getResource("/Imagens/Ares18.png")).getImage();
    Image ares19 = new ImageIcon(getClass().getResource("/Imagens/Ares19.png")).getImage();
    Image ares20 = new ImageIcon(getClass().getResource("/Imagens/Ares20.png")).getImage();

    public Ares(int x, int y, int joystick) {
        initTiro();
        this.x = x;
        this.y = y;
        this.life = 100;
        this.lifetotal = 100;
        this.movespeed = 2;
        this.dmg = 12;
        this.bulletSpeed = 6;
        this.joystick = joystick;

    }

    @Override
    public void shooting() {
        if (RT == 1 && settiro == 1) {
            shotGun(tiro);
            settiro = 0;
            reload(3000);
        }
    }

    @Override
    public void drawHero(Graphics g, Game game) {
        i = periodo % 15;
        if (animation == 1) {

            if (danimation == 1) {
                deathAnimation(g, game, this);
                basicAnimation(g, 13);
            } else if (i == 0 | i == 1 | i == 2) {
                g.drawImage(ares00, x, y, game);
            } else if (i == 3 | i == 4 | i == 5) {
                g.drawImage(ares01, x, y, game);
            } else if (i == 6 | i == 7 | i == 8) {
                g.drawImage(ares02, x, y, game);;
            } else if (i == 9 | i == 10 | i == 11) {
                g.drawImage(ares03, x, y, game);
            } else if (i == 12 | i == 13 | i == 14) {
                g.drawImage(ares04, x, y, game);
            }
        } else if (animation == 2) {
            if (danimation == 1) {
                deathAnimation(g, game, this);
                basicAnimation(g, 14);
            } else if (i == 0 | i == 1 | i == 2) {
                g.drawImage(ares10, x, y, game);
            } else if (i == 3 | i == 4 | i == 5) {
                g.drawImage(ares11, x, y, game);
            } else if (i == 6 | i == 7 | i == 8) {
                g.drawImage(ares12, x, y, game);;
            } else if (i == 9 | i == 10 | i == 11) {
                g.drawImage(ares13, x, y, game);
            } else if (i == 12 | i == 13 | i == 14) {
                g.drawImage(ares14, x, y, game);
            }
        } else if (animation == 3) {
            
            if (direçao == R) {
                g.drawImage(ares05, x, y, game);
            }else 
            if (direçao == L) {
                g.drawImage(ares15, x, y, game);
            }else
            if (direçao == UR) {
                g.drawImage(ares07, x, y, game);
            }else 
            if (direçao == UL) {
                g.drawImage(ares17, x, y, game);
            }else 
            if (direçao == U && conserve == 1) {
                g.drawImage(ares09, x, y, game);
            }else
            if (direçao == U && conserve == 2) {
                g.drawImage(ares19, x, y, game);
            }else
            if (direçao == DR) {
                g.drawImage(ares06, x, y, game);
            }else
            if (direçao == D && conserve == 1) {
                g.drawImage(ares08, x, y, game);
            }else
            if (direçao == D && conserve == 2) {
                g.drawImage(ares18, x, y, game);
            }else
            if (direçao == DL) {
                g.drawImage(ares16, x, y, game);
            }
        }
    }

    @Override
    public void tests(Hero hero,Game game) {
        for (int i = 0; i < 80; i++) {
            tiro[i].defineCollison();
            tiro[i].test(this, hero, i);
        }
    }

    @Override
    public void drawShoots(Graphics g) {
        g.setColor(Color.black);
        for (int i = 0; i < 50; i++) {

            tiro[i].drawProjectile(g);
            tiro[i].moveProjectile();

        }
    }
}
