
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class MrCnl extends Hero {

    Image lf00 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend00.png")).getImage();
    Image lf01 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend01.png")).getImage();
    Image lf02 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend02.png")).getImage();
    Image lf03 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend03.png")).getImage();
    Image lf04 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend04.png")).getImage();
    Image lf05 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend05.png")).getImage();
    Image lf06 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend06.png")).getImage();
    Image lf07 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend07.png")).getImage();
    Image lf08 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend08.png")).getImage();
    Image lf09 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend09.png")).getImage();
    Image lf10 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend10.png")).getImage();
    Image lf11 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend11.png")).getImage();
    Image lf12 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend12.png")).getImage();
    Image lf13 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend13.png")).getImage();
    Image lf14 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend14.png")).getImage();
    Image lf15 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend15.png")).getImage();
    Image lf16 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend16.png")).getImage();
    Image lf17 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend17.png")).getImage();
    Image lf18 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend18.png")).getImage();
    Image lf19 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend19.png")).getImage();
    Image lf20 = new ImageIcon(getClass().getResource("/Imagens/Little_Friend20.png")).getImage();

    public MrCnl(int x, int y, int Joystick) {
        initTiro();
        this.x = x;
        this.y = y;
        this.life = 80;
        this.lifetotal = 80;
        this.movespeed = 3;
        this.dmg = 10;
        this.bulletSpeed = 8;
        this.joystick = Joystick;
    }

    @Override
    public void shooting() {
        if (RT == 1 && settiro == 1) {
            smg();
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
                g.drawImage(lf00, x, y, game);
            } else if (i == 3 | i == 4 | i == 5) {
                g.drawImage(lf01, x, y, game);
            } else if (i == 6 | i == 7 | i == 8) {
                g.drawImage(lf02, x, y, game);;
            } else if (i == 9 | i == 10 | i == 11) {
                g.drawImage(lf03, x, y, game);
            } else if (i == 12 | i == 13 | i == 14) {
                g.drawImage(lf04, x, y, game);
            }
        } else if (animation == 2) {

            if (danimation == 1) {
                deathAnimation(g, game, this);
                basicAnimation(g, 14);
            } else if (i == 0 | i == 1 | i == 2) {
                g.drawImage(lf10, x, y, game);
            } else if (i == 3 | i == 4 | i == 5) {
                g.drawImage(lf11, x, y, game);
            } else if (i == 6 | i == 7 | i == 8) {
                g.drawImage(lf12, x, y, game);;
            } else if (i == 9 | i == 10 | i == 11) {
                g.drawImage(lf13, x, y, game);
            } else if (i == 12 | i == 13 | i == 14) {
                g.drawImage(lf14, x, y, game);
            }
        } else if (animation == 3) {
            if (direçao == R) {
                g.drawImage(lf05, x, y, game);
            }else
            if (direçao == L) {
                g.drawImage(lf15, x, y, game);
            }else
            if (direçao == UR) {
                g.drawImage(lf06, x, y, game);
            }else
            if (direçao == UL) {
                g.drawImage(lf16, x, y, game);
            }else
            if (direçao == U && conserve == 1) {
                g.drawImage(lf08, x, y, game);
            }else
            if (direçao == U && conserve == 2) {
                g.drawImage(lf18, x, y, game);
            }else
            if (direçao == DR) {
                g.drawImage(lf07, x, y, game);
            }else
            if (direçao == D && conserve == 1) {
                g.drawImage(lf09, x, y, game);
            }else
            if (direçao == D && conserve == 2) {
                g.drawImage(lf19, x, y, game);
            }else
            if (direçao == DL) {
                g.drawImage(lf17, x, y, game);
            }
        }
    }

    @Override
    public void tests(Hero hero,Game game) {
        for (int i = 0; i < 60; i++) {
            tiro[i].defineCollison();
            tiro[i].test(this, hero, i);
        }
    }

    @Override
    public void drawShoots(Graphics g) {
        g.setColor(Color.black);
        for (int i = 0; i < 60; i++) {
            tiro[i].drawProjectile(g);
            tiro[i].moveProjectile();
        }
    }
}
