
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class MB extends Hero {

    Image motoboy00 = new ImageIcon(getClass().getResource("/Imagens/Motoboy00.png")).getImage();
    Image motoboy01 = new ImageIcon(getClass().getResource("/Imagens/Motoboy01.png")).getImage();
    Image motoboy02 = new ImageIcon(getClass().getResource("/Imagens/Motoboy02.png")).getImage();
    Image motoboy03 = new ImageIcon(getClass().getResource("/Imagens/Motoboy03.png")).getImage();
    Image motoboy04 = new ImageIcon(getClass().getResource("/Imagens/Motoboy04.png")).getImage();
    Image motoboy05 = new ImageIcon(getClass().getResource("/Imagens/Motoboy05.png")).getImage();
    Image motoboy06 = new ImageIcon(getClass().getResource("/Imagens/Motoboy06.png")).getImage();
    Image motoboy07 = new ImageIcon(getClass().getResource("/Imagens/Motoboy07.png")).getImage();
    Image motoboy08 = new ImageIcon(getClass().getResource("/Imagens/Motoboy08.png")).getImage();
    Image motoboy09 = new ImageIcon(getClass().getResource("/Imagens/Motoboy09.png")).getImage();
    Image motoboy10 = new ImageIcon(getClass().getResource("/Imagens/Motoboy10.png")).getImage();
    Image motoboy11 = new ImageIcon(getClass().getResource("/Imagens/Motoboy11.png")).getImage();
    Image motoboy12 = new ImageIcon(getClass().getResource("/Imagens/Motoboy12.png")).getImage();
    Image motoboy13 = new ImageIcon(getClass().getResource("/Imagens/Motoboy13.png")).getImage();
    Image motoboy14 = new ImageIcon(getClass().getResource("/Imagens/Motoboy14.png")).getImage();
    Image motoboy15 = new ImageIcon(getClass().getResource("/Imagens/Motoboy15.png")).getImage();
    Image motoboy16 = new ImageIcon(getClass().getResource("/Imagens/Motoboy16.png")).getImage();
    Image motoboy17 = new ImageIcon(getClass().getResource("/Imagens/Motoboy17.png")).getImage();
    Image motoboy18 = new ImageIcon(getClass().getResource("/Imagens/Motoboy18.png")).getImage();
    Image motoboy19 = new ImageIcon(getClass().getResource("/Imagens/Motoboy19.png")).getImage();
    Image motoboy20 = new ImageIcon(getClass().getResource("/Imagens/Motoboy20.png")).getImage();

    public MB(int x, int y, int Joystick) {
        initTiro();
        this.x = x;
        this.y = y;
        this.life = 100;
        this.lifetotal = 100;
        this.movespeed = 4;
        this.dmg = 15;
        this.bulletSpeed = 6;
        this.joystick = Joystick;
    }

    @Override
    public void shooting() {
        if (RT == 1) {
            if (settiro == 1) {
                basicShooting(tiro);
                settiro = 0;
            }
        } else {
            settiro = 1;
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
                g.drawImage(motoboy00, x, y, game);
            } else if (i == 3 | i == 4 | i == 5) {
                g.drawImage(motoboy01, x, y, game);
            } else if (i == 6 | i == 7 | i == 8) {
                g.drawImage(motoboy02, x, y, game);;
            } else if (i == 9 | i == 10 | i == 11) {
                g.drawImage(motoboy03, x, y, game);
            } else if (i == 12 | i == 13 | i == 14) {
                g.drawImage(motoboy04, x, y, game);
            }
        } else if (animation == 2) {

            if (danimation == 1) {
                deathAnimation(g, game, this);
                basicAnimation(g, 14);
            } else if (i == 0 | i == 1 | i == 2) {
                g.drawImage(motoboy10, x, y, game);
            } else if (i == 3 | i == 4 | i == 5) {
                g.drawImage(motoboy11, x, y, game);
            } else if (i == 6 | i == 7 | i == 8) {
                g.drawImage(motoboy12, x, y, game);;
            } else if (i == 9 | i == 10 | i == 11) {
                g.drawImage(motoboy13, x, y, game);
            } else if (i == 12 | i == 13 | i == 14) {
                g.drawImage(motoboy14, x, y, game);
            }
        } else if (animation == 3) {
            if (direçao == R) {
                g.drawImage(motoboy00, x, y, game);
            }else
            if (direçao == L) {
                g.drawImage(motoboy10, x, y, game);
            }else
            if (direçao == U && conserve == 1) {
                g.drawImage(motoboy09, x, y, game);
            }else
            if (direçao == U && conserve == 2) {
                g.drawImage(motoboy19, x, y, game);
            }else
            if (direçao == UR) {
                g.drawImage(motoboy06, x, y, game);
            }else
            if (direçao == UL) {
                g.drawImage(motoboy16, x, y, game);
            }else
            if (direçao == D && conserve == 1) {
                g.drawImage(motoboy08, x, y, game);
            }else
            if (direçao == D && conserve == 2) {
                g.drawImage(motoboy18, x, y, game);
            }else
            if (direçao == DL) {
                g.drawImage(motoboy17, x, y, game);
            }else
            if (direçao == DR) {
                g.drawImage(motoboy07, x, y, game);
            }
        }
    }

    @Override
    public void tests(Hero hero,Game game) {
        for (int i = 0; i < 50; i++) {
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
