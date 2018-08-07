
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mario
 */
public class Juggernaut extends Hero {

    Image bomber00 = new ImageIcon(getClass().getResource("/Imagens/Bomber00.png")).getImage();
    Image bomber01 = new ImageIcon(getClass().getResource("/Imagens/Bomber01.png")).getImage();
    Image bomber02 = new ImageIcon(getClass().getResource("/Imagens/Bomber02.png")).getImage();
    Image bomber03 = new ImageIcon(getClass().getResource("/Imagens/Bomber03.png")).getImage();
    Image bomber04 = new ImageIcon(getClass().getResource("/Imagens/Bomber04.png")).getImage();
    Image bomber05 = new ImageIcon(getClass().getResource("/Imagens/Bomber05.png")).getImage();
    Image bomber06 = new ImageIcon(getClass().getResource("/Imagens/Bomber06.png")).getImage();
    Image bomber07 = new ImageIcon(getClass().getResource("/Imagens/Bomber07.png")).getImage();
    Image bomber08 = new ImageIcon(getClass().getResource("/Imagens/Bomber08.png")).getImage();
    Image bomber09 = new ImageIcon(getClass().getResource("/Imagens/Bomber09.png")).getImage();
    Image bomber10 = new ImageIcon(getClass().getResource("/Imagens/Bomber10.png")).getImage();
    Image bomber11 = new ImageIcon(getClass().getResource("/Imagens/Bomber11.png")).getImage();
    Image bomber12 = new ImageIcon(getClass().getResource("/Imagens/Bomber12.png")).getImage();
    Image bomber13 = new ImageIcon(getClass().getResource("/Imagens/Bomber13.png")).getImage();
    Image bomber14 = new ImageIcon(getClass().getResource("/Imagens/Bomber14.png")).getImage();
    Image bomber15 = new ImageIcon(getClass().getResource("/Imagens/Bomber15.png")).getImage();
    Image bomber16 = new ImageIcon(getClass().getResource("/Imagens/Bomber16.png")).getImage();

    public Juggernaut(int x, int y, int joystick) {
        initTiro();
        this.x = x;
        this.y = y;
        this.life = 120;
        this.lifetotal = 120;
        this.movespeed = 1;
        this.dmg = 10;
        this.bulletSpeed = 6;
        this.joystick = joystick;
    }

    @Override
    public void shooting() {
        if (RT == 1 && settiro == 1) {
            launchBomb();
        }
        if (RT == 0 && settiro == 1) {
            if (bomb != null) {
                bomb.detonarBomb(this);
                bomb = null;
                settiro = 0;
                conttiro = 0;
            }
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
                g.drawImage(bomber00, x, y, game);
            } else if (i == 3 | i == 4 | i == 5) {
                g.drawImage(bomber01, x, y, game);
            } else if (i == 6 | i == 7 | i == 8) {
                g.drawImage(bomber02, x, y, game);;
            } else if (i == 9 | i == 10 | i == 11) {
                g.drawImage(bomber03, x, y, game);
            } else if (i == 12 | i == 13 | i == 14) {
                g.drawImage(bomber04, x, y, game);
            }
        }
        if (animation == 2) {
            if (danimation == 1) {
                deathAnimation(g, game, this);
                basicAnimation(g, 14);
            } else if (i == 0 | i == 1 | i == 2) {
                g.drawImage(bomber08, x, y, game);
            } else if (i == 3 | i == 4 | i == 5) {
                g.drawImage(bomber09, x, y, game);
            } else if (i == 6 | i == 7 | i == 8) {
                g.drawImage(bomber10, x, y, game);;
            } else if (i == 9 | i == 10 | i == 11) {
                g.drawImage(bomber11, x, y, game);
            } else if (i == 12 | i == 13 | i == 14) {
                g.drawImage(bomber12, x, y, game);
            }
        }
        if (animation == 3) {
            if (direçao == R) {
                g.drawImage(bomber05, x, y, game);
            } else if (direçao == L) {
                g.drawImage(bomber13, x, y, game);
            } else if (direçao == UR) {
                g.drawImage(bomber06, x, y, game);
            } else if (direçao == UL) {
                g.drawImage(bomber14, x, y, game);
            } else if (direçao == U && conserve == 1) {
                g.drawImage(bomber06, x, y, game);
            } else if (direçao == U && conserve == 2) {
                g.drawImage(bomber14, x, y, game);
            } else if (direçao == DR) {
                g.drawImage(bomber07, x, y, game);
            } else if (direçao == D && conserve == 1) {
                g.drawImage(bomber07, x, y, game);
            } else if (direçao == D && conserve == 2) {
                g.drawImage(bomber15, x, y, game);
            } else if (direçao == DL) {
                g.drawImage(bomber15, x, y, game);
            }
        }

    }

    @Override
    public void tests(Hero hero, Game game) {
        for (int i = 0; i < 36; i++) {
            tiro[i].defineCollison();
            tiro[i].test(this, hero, i);

        }
        for (int j = 0; j < 18; j++) {
            if (bomb != null) {
                if (bomb.collision.intersects(game.fase1.block[j].central)) {
                    bomb.detonarBomb(this);
                    conttiro = 0;
                }
            }
        }

    }

    @Override
    public void drawShoots(Graphics g) {
        g.setColor(Color.black);
        for (int i = 0; i < 36; i++) {
            tiro[i].drawProjectile(g);
            tiro[i].moveProjectile();
        }
        if (bomb != null) {
            bomb.criarBomb(g);
            bomb.moverBomba();
        }
    }

}
