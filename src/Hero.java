
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.net.URL;
import java.nio.FloatBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.glfw.GLFW.GLFW_JOYSTICK_1;
import static org.lwjgl.glfw.GLFW.GLFW_JOYSTICK_2;
import static org.lwjgl.glfw.GLFW.glfwGetJoystickAxes;

public class Hero {

    Sprites sprite = new Sprites();

    URL url1 = getClass().getResource("/Sound/shoot.wav");
    AudioClip shoot1 = Applet.newAudioClip(url1);
    AudioClip shoot2 = Applet.newAudioClip(url1);
    AudioClip shoot3 = Applet.newAudioClip(url1);
    AudioClip shoot4 = Applet.newAudioClip(url1);
    AudioClip shoot5 = Applet.newAudioClip(url1);
    AudioClip shoot6 = Applet.newAudioClip(url1);

    AudioClip gun1 = Applet.newAudioClip(getClass().getResource("/Sound/shot and reload.wav"));
    AudioClip lfgun1 = Applet.newAudioClip(getClass().getResource("/Sound/gunshot2.wav"));
    AudioClip lfgun2 = Applet.newAudioClip(getClass().getResource("/Sound/gunshot2.wav"));
    AudioClip lfgun3 = Applet.newAudioClip(getClass().getResource("/Sound/gunshot2.wav"));
    AudioClip lfgun4 = Applet.newAudioClip(getClass().getResource("/Sound/gunshot2.wav"));
    AudioClip lfgun5 = Applet.newAudioClip(getClass().getResource("/Sound/gunshot2.wav"));
    AudioClip lfgun6 = Applet.newAudioClip(getClass().getResource("/Sound/gunshot2.wav"));
    AudioClip lfgun7 = Applet.newAudioClip(getClass().getResource("/Sound/gunshot2.wav"));

    AudioClip gl = Applet.newAudioClip(getClass().getResource("/Sound/grenade launcher.wav"));

    AudioClip smgreload = Applet.newAudioClip(getClass().getResource("/Sound/smgreload.wav"));

    static final int U = 1;
    static final int UR = 2;
    static final int UL = 3;
    static final int D = 4;
    static final int DR = 5;
    static final int DL = 6;
    static final int R = 7;
    static final int L = 8;

    protected double life;
    protected double lifetotal;
    protected int movespeed;
    protected int dmg;

    private int up = 0;
    private int setup = 1;
    private int down = 0;
    private int setdown = 1;
    private int left = 0;
    private int setleft = 1;
    private int right = 0;
    private int setright = 1;

    double an1X;
    double an1Y;

    int RT = -1;

    

    int settiro = 1;

    int shooting = 0;

    int direçao = R;

    private int set = 1;

    private int dperiodo = 0;

    int equipment;

    
    Projectile[] tiro = new Projectile[110];
    
    Bomb bomb;

    AudioClip death = Applet.newAudioClip(getClass().getResource("/Sound/deathsound.wav"));

    int danimation = 0;

    Game game;
    Fase_1 fase1;
    Fase_2 fase2;
    Fase_3 fase3;

    Rectangle collision = new Rectangle(-100, -100, 20, 20);

    protected int x;
    protected int y;

    private int pixel = 3;

    protected int animation = 1;

    protected int conserve = 1;

    protected int periodo = 0;

    int colors = 1;

    protected int conttiro = 0;
    
    protected int i = periodo % 15;
    
    protected int bulletSpeed;

    protected int joystick;

    FloatBuffer axes;
    
    public void initTiro(){
        for (int j = 0; j < tiro.length; j++) {
            tiro[j] = new Projectile();
        }
    }
    
    public void CALLHERO(Graphics g,Game game,Hero hero){
        drawShoots(g);
        drawHero(g, game);
        moverHeroi();
        tests(hero,game);
        drawLifeBar(g);
        
        
    }
    
    public void drawHero(Graphics g, Game game) {
        
    }

    public void moverHeroi() {
        
        shooting();

        axes = glfwGetJoystickAxes(joystick);
        

        an1X = axes.get(0);
        an1Y = axes.get(1);

        RT = (int) axes.get(5);
        
        if ((an1X > 0.5) && (an1Y > 0.5)) {
            if (setup == 1 && setright == 1) {
////                x++;
////                x++;
////                y--;
////                y--;
                x = x + movespeed;
                y = y - movespeed;

                animation = 1;

                periodo++;
            }
            conserve = 1;
            direçao = UR;
        } else if ((an1X < -0.5) && (an1Y > 0.5)) {
            if (setup == 1 && setleft == 1) {
//                x--;
//                x--;
//                y--;
//                y--;
                x = x - movespeed;
                y = y - movespeed;

                animation = 2;

                periodo++;
            }
            conserve = 2;
            direçao = UL;
        } else if ((an1X > 0.5) && (an1Y < -0.5)) {
            if (setdown == 1 && setright == 1) {
//                x++;
//                x++;
//                y++;
//                y++;
                x = x + movespeed;
                y = y + movespeed;

                animation = 1;

                periodo++;
            }
            conserve = 1;
            direçao = DR;
        } else if ((an1X < -0.5) && (an1Y < -0.5)) {
            if (setdown == 1 && setleft == 1) {
//                x--;
//                x--;
//                y++;
//                y++;
                x = x - movespeed;
                y = y + movespeed;

                animation = 2;

                periodo++;
            }
            conserve = 2;
            direçao = DL;
        } else if ((an1Y > 0.5)) {
            if (setup == 1) {
//                y--;
//                y--;
                y = y - movespeed;
                animation = conserve;
                periodo++;

            }
            direçao = U;

        } else if ((an1Y < -0.5)) {
            if (setdown == 1) {
//                y++;
//                y++;
                y = y + movespeed;
                animation = conserve;
                periodo++;
            }
            direçao = D;
        } else if ((an1X > 0.5)) {
            if (setright == 1) {
//                x++;
//                x++;
                x = x + movespeed;

                animation = 1;

                periodo++;
            }
            conserve = 1;
            direçao = R;

        } else if ((an1X < -0.5)) {
            if (setleft == 1) {
//                x--;
//                x--;
                x = x - movespeed;

                animation = 2;

                periodo++;
            }
            conserve = 2;
            direçao = L;
        } else if (an1X < 0.5 && an1X > -0.5 && an1Y < 0.5 && an1Y > -0.5) {
            periodo = 0;
        }

        collision.x = x + 12;
        collision.y = y;
        collision.width = 8 * pixel;
        collision.height = 16 * pixel;

    }

    public void basicAnimation(Graphics g, int a1) {
        if (colors == 1) {
            g.setColor(Color.BLACK);
        }

        if (a1 == 13) {
            g.fillRect(x + 15 + (3 * pixel), y, 3 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (2 * pixel), y + (4 * pixel), 5 * pixel, 2 * pixel);
            g.fillRect(x + 15, y + (6 * pixel), 2 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (7 * pixel), y + (6 * pixel), 2 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (3 * pixel), y + (6 * pixel), 3 * pixel, 9 * pixel);
            g.fillRect(x + 15 + (6 * pixel), y + (13 * pixel), pixel, 2 * pixel);

            g.fillRect(x + 15 + (2 * pixel), y - (2 * pixel), 5 * pixel, 1 * pixel);
            g.fillRect(x + 15 + (7 * pixel), y, 1 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (8 * pixel), y + (3 * pixel), 1 * pixel, 2 * pixel);
            g.fillRect(x + 15 + (10 * pixel), y + (6 * pixel), 1 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (3 * pixel), y + (16 * pixel), 3 * pixel, 1 * pixel);
            g.fillRect(x + 15 + (7 * pixel), y + (10 * pixel), 1 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (1 * pixel), y + (10 * pixel), 1 * pixel, 3 * pixel);
            g.fillRect(x + 15 - (2 * pixel), y + (6 * pixel), 1 * pixel, 3 * pixel);
            g.fillRect(x + 15, y + (3 * pixel), 1 * pixel, 2 * pixel);
            g.fillRect(x + 15 + (1 * pixel), y, 1 * pixel, 3 * pixel);
        }
        if (a1 == 14) {
            g.fillRect(x + 15 + (3 * pixel), y, 3 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (2 * pixel), y + (4 * pixel), 5 * pixel, 2 * pixel);
            g.fillRect(x + 15, y + (6 * pixel), 2 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (7 * pixel), y + (6 * pixel), 2 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (3 * pixel), y + (6 * pixel), 3 * pixel, 9 * pixel);
            g.fillRect(x + 15 + (2 * pixel), y + (13 * pixel), pixel, 2 * pixel);

            g.fillRect(x + 15 + (2 * pixel), y - (2 * pixel), 5 * pixel, 1 * pixel);
            g.fillRect(x + 15 + (7 * pixel), y, 1 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (8 * pixel), y + (3 * pixel), 1 * pixel, 2 * pixel);
            g.fillRect(x + 15 + (10 * pixel), y + (6 * pixel), 1 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (3 * pixel), y + (16 * pixel), 3 * pixel, 1 * pixel);
            g.fillRect(x + 15 + (7 * pixel), y + (10 * pixel), 1 * pixel, 3 * pixel);
            g.fillRect(x + 15 + (1 * pixel), y + (10 * pixel), 1 * pixel, 3 * pixel);
            g.fillRect(x + 15 - (2 * pixel), y + (6 * pixel), 1 * pixel, 3 * pixel);
            g.fillRect(x + 15, y + (3 * pixel), 1 * pixel, 2 * pixel);
            g.fillRect(x + 15 + (1 * pixel), y, 1 * pixel, 3 * pixel);
        }
    }

    public void deathAnimation(Graphics g, Game game, Hero hero) {

        while (set == 1) {
            dperiodo = 0;
            death.play();
            set = 0;

        }
        settiro = 0;
        up = 0;
        down = 0;
        left = 0;
        right = 0;
        
        if (dperiodo % 30 <= 14) {
            colors = 0;
            g.setColor(Color.red);
        }
        if (dperiodo >= 150) {

            if (game.fases == 1) {
                x = -100;
                y = -100;
                life = 0;
            }
            if (game.fases == 2) {
                fase2.setLocation(game);
            }
            if (game.fases == 3) {

            }

            danimation = 0;
            

        }
        dperiodo++;

    }

    public void shooting() {//  EMPTY METHOD

        
        
        

    }//EMPTY METHOD

    public void basicShooting(Projectile tiro[]) {
        
        if (direçao == R) {
            tiro[conttiro] = new Tiro(x + (17 * pixel), y + (6 * pixel), pixel * 2, pixel * 4, 0, bulletSpeed);
        }else if (direçao == L) {
            tiro[conttiro] = new Tiro(x + (-3 * pixel), y + (6 * pixel), pixel * 2, pixel * 4, 180, bulletSpeed);
        }else if (direçao == U) {
            if (conserve == 1) {
                tiro[conttiro] = new Tiro(x + (11 * pixel), y + (-1 * pixel), pixel * 4, pixel * 2, 90, bulletSpeed);
            } else if (conserve == 2) {
                tiro[conttiro] = new Tiro(x + (5 * pixel), y + (-1 * pixel), pixel * 4, pixel * 2, 90, bulletSpeed);
            }
        }else if (direçao == UR) {
            tiro[conttiro] = new Tiro(x + (15 * pixel), y + (0 * pixel), pixel * 2, pixel * 2, 45, bulletSpeed);
        }else if (direçao == UL) {
            tiro[conttiro] = new Tiro(x + (2 * pixel), y + (0 * pixel), pixel * 2, pixel * 2, 135, bulletSpeed);
        }else if (direçao == D) {
            if (conserve == 1) {
                tiro[conttiro] = new Tiro(x + (13 * pixel), y + (13 * pixel), pixel * 4, pixel * 2, 270, bulletSpeed);
            } else if (conserve == 2) {
                tiro[conttiro] = new Tiro(x, y + (13 * pixel), pixel * 4, pixel * 2, 270, bulletSpeed);
            }
        }else if (direçao == DR) {
            tiro[conttiro] = new Tiro(x + (17 * pixel), y + (10 * pixel), pixel * 2, pixel * 2, 315, bulletSpeed);
        }else if (direçao == DL) {
            tiro[conttiro] = new Tiro(x, y + (9 * pixel), pixel * 2, pixel * 2, 225, bulletSpeed);
        }
        animation = 3;
        conttiro++;
        switch(conttiro % 6){
            case 0 : shoot1.play();break;
            case 1 : shoot2.play();break;
            case 2 : shoot3.play();break;
            case 3 : shoot4.play();break;
            case 4 : shoot5.play();break;
            case 5 : shoot6.play();break;
        }
        
        if (conttiro >= 50) {
            conttiro = 0;
        }
    }

    public void shotGun(Projectile tiro[]) {

        if (direçao == R) {
            tiro[conttiro] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
            tiro[conttiro + 1] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
            tiro[conttiro + 2] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
            tiro[conttiro + 3] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
            tiro[conttiro + 4] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
            tiro[conttiro + 5] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
            tiro[conttiro + 6] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
            tiro[conttiro + 7] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
            tiro[conttiro + 8] = new Tiro(x + 40, y + 24, 5, 5, random(-20, 40), bulletSpeed);
        }else if (direçao == L) {
            tiro[conttiro] = new Tiro(x + 5, y + 20, 5, 5, random(-20, 40) + 180, bulletSpeed);
            tiro[conttiro + 1] = new Tiro(x + 5, y + 24, 5, 5, random(-20, 40) + 180, bulletSpeed);
            tiro[conttiro + 2] = new Tiro(x + 5, y + 24, 5, 5, random(-20, 40) + 180, bulletSpeed);
            tiro[conttiro + 3] = new Tiro(x + 5, y + 24, 5, 5, random(-20, 40) + 180, bulletSpeed);
            tiro[conttiro + 4] = new Tiro(x + 5, y + 24, 5, 5, random(-20, 40) + 180, bulletSpeed);
            tiro[conttiro + 5] = new Tiro(x + 5, y + 24, 5, 5, random(-20, 40) + 180, bulletSpeed);
            tiro[conttiro + 6] = new Tiro(x + 5, y + 24, 5, 5, random(-20, 40) + 180, bulletSpeed);
            tiro[conttiro + 7] = new Tiro(x + 5, y + 24, 5, 5, random(-20, 40) + 180, bulletSpeed);
            tiro[conttiro + 8] = new Tiro(x + 5, y + 24, 5, 5, random(-20, 40) + 180, bulletSpeed);
        }else if (direçao == U) {
            if (conserve == 1) {
                tiro[conttiro] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 1] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 2] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 3] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 4] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 5] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 6] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 7] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 8] = new Tiro(x + 15, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
            } else if (conserve == 2) {
                tiro[conttiro] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 1] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 2] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 3] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 4] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 5] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 6] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 7] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
                tiro[conttiro + 8] = new Tiro(x + 25, y, 5, 5, random(-20, 40) + 90, bulletSpeed);
            }
        }else if (direçao == UR) {
            tiro[conttiro] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
            tiro[conttiro + 1] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
            tiro[conttiro + 2] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
            tiro[conttiro + 3] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
            tiro[conttiro + 4] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
            tiro[conttiro + 5] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
            tiro[conttiro + 6] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
            tiro[conttiro + 7] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
            tiro[conttiro + 8] = new Tiro(x + 40, y + 10, 5, 5, random(-20, 40) + 45, bulletSpeed);
        }
        if (direçao == UL) {
            tiro[conttiro] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
            tiro[conttiro + 1] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
            tiro[conttiro + 2] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
            tiro[conttiro + 3] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
            tiro[conttiro + 4] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
            tiro[conttiro + 5] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
            tiro[conttiro + 6] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
            tiro[conttiro + 7] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
            tiro[conttiro + 8] = new Tiro(x + 10, y + 10, 5, 5, random(-20, 40) + 135, bulletSpeed);
        }
        if (direçao == D) {
            if (conserve == 1) {
                tiro[conttiro] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 1] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 2] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 3] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 4] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 5] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 6] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 7] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 8] = new Tiro(x + 24, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);

            } else if (conserve == 2) {
                tiro[conttiro] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 1] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 2] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 3] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 4] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 5] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 6] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 7] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
                tiro[conttiro + 8] = new Tiro(x + 20, y + 40, 5, 5, random(-20, 40) + 270, bulletSpeed);
            }
        }
        if (direçao == DR) {
            tiro[conttiro] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
            tiro[conttiro + 1] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
            tiro[conttiro + 2] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
            tiro[conttiro + 3] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
            tiro[conttiro + 4] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
            tiro[conttiro + 5] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
            tiro[conttiro + 6] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
            tiro[conttiro + 7] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
            tiro[conttiro + 8] = new Tiro(x + 35, y + 40, 5, 5, random(-20, 40) + 315, bulletSpeed);
        }
        if (direçao == DL) {
            tiro[conttiro] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
            tiro[conttiro + 1] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
            tiro[conttiro + 2] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
            tiro[conttiro + 3] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
            tiro[conttiro + 4] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
            tiro[conttiro + 5] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
            tiro[conttiro + 6] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
            tiro[conttiro + 7] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
            tiro[conttiro + 8] = new Tiro(x + 10, y + 40, 5, 5, random(-20, 40) + 225, bulletSpeed);
        }
        conttiro += 9;
        animation = 3;
        gun1.play();
        if (conttiro >=45) {
            conttiro = 0;
        }
        System.out.println(conttiro);
    }

    public void launchBomb() {
        if (bomb == null) {
            if (direçao == R) {
                bomb = new Bomb(x + 43, y + 35, 5, 5, 0);
            }
            if (direçao == L) {
                bomb = new Bomb(x - 10, y + 35, 5, 5, 180);
            }
            if (direçao == U) {
                if (conserve == 1) {
                    bomb = new Bomb(x + 43, y + 25, 5, 5, 90);
                } else if (conserve == 2) {
                    bomb = new Bomb(x - 0, y + 25, 5, 5, 90);
                }
            }
            if (direçao == D) {
                if (conserve == 1) {
                    bomb = new Bomb(x + 43, y + 45, 5, 5, 270);
                } else if (conserve == 2) {
                    bomb = new Bomb(x + 0, y + 45, 5, 5, 270);
                }
            }
            if (direçao == UR) {
                bomb = new Bomb(x + 43, y + 25, 5, 5, 45);
            }
            if (direçao == UL) {
                bomb = new Bomb(x, y + 25, 5, 5, 135);
            }
            if (direçao == DR) {
                bomb = new Bomb(x + 43, y + 45, 5, 5, 315);
            }
            if (direçao == DL) {
                bomb = new Bomb(x, y + 45, 5, 5, 225);
            }
            animation = 3;
            gl.play();
        }

    }

    public void smg() {

        if (direçao == R) {
            tiro[conttiro] = new Tiro(x + 40, y + 28, 2, pixel * 4, 0 + random(-3, 9), bulletSpeed);
        }else if (direçao == L) {
            tiro[conttiro] = new Tiro(x, y + 28, 2, pixel * 4, 180 + random(-3, 9), bulletSpeed);
        }else if (direçao == U) {
            if (conserve == 1) {
                tiro[conttiro] = new Tiro(x + 20, y + (2 * pixel), pixel * 4, 2, 90 + random(-3, 9), bulletSpeed);
            } else if (conserve == 2) {
                tiro[conttiro] = new Tiro(x + 31, y + (2 * pixel), pixel * 4, 2, 90 + random(-3, 9), bulletSpeed);
            }
        }else if (direçao == UR) {
            tiro[conttiro] = new Tiro(x + (7 * pixel) + 12, y + (2 * pixel) + 11, 3, 3, 45 + random(-3, 9), bulletSpeed);
        }else if (direçao == UL) {
            tiro[conttiro] = new Tiro(x + 10, y + 13, 3, 3, 135 + random(-3, 9), bulletSpeed);
        }else if (direçao == D) {
            if (conserve == 1) {
                tiro[conttiro] = new Tiro(x + 30, y + 40, pixel * 4, 2, 270 + random(-3, 9), bulletSpeed);
            } else if (conserve == 2) {
                tiro[conttiro] = new Tiro(x + 20, y + 40, pixel * 4, 2, 270 + random(-3, 9), bulletSpeed);
            }
        }else if (direçao == DR) {
            tiro[conttiro] = new Tiro(x + (7 * pixel) + 13, y + (8 * pixel) + 10, 3, 3, 315 + random(-3, 9), bulletSpeed);
        }else if (direçao == DL) {
            tiro[conttiro] = new Tiro(x + 12, y + (8 * pixel) + 10, 3, 3, 225 + random(-3, 9), bulletSpeed);
        }
        if (conttiro % 7 == 0) {
            lfgun1.play();
        }else if (conttiro % 7 == 1) {
            lfgun2.play();
        }else if (conttiro % 7 == 2) {
            lfgun3.play();
        }else if (conttiro % 7 == 3) {
            lfgun4.play();
        }else if (conttiro % 7 == 4) {
            lfgun5.play();
        }else if (conttiro % 7 == 5) {
            lfgun6.play();
        }else if (conttiro % 7 == 6) {
            lfgun6.play();
        }
        conttiro++;
        animation = 3;
        settiro = 0;
        if (conttiro % 35 == 0) {
            smgreload.play();
            reload(2000);
        } else {
            reload(70);
        }
        if (conttiro > 60) {
            conttiro = 0;
        }

    }

    public void tests(Hero hero,Game game) {
        
    }
    public void drawLifeBar(Graphics g){
        g.setColor(Color.black);
        g.fillRect(x + 7, y - 12, 41, 7);
        g.setColor(Color.green);
        g.fillRect(x + 10, y - 10, (int) ((life / lifetotal) * 35), 3);
    }
    public void drawShoots(Graphics g){
        
    }

    public void reload(int x) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(x);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                settiro = 1;
            }
        }).start();
    }

    public int random(int x, int y) {
        return (int) (Math.random() * y) + x;
    }

    public void setSetRight(int x) {
        setright = x;
    }

    public void setRight(int x) {
        right = x;
    }

    public void setSetLeft(int x) {
        setleft = x;
    }

    public void setLeft(int x) {
        left = x;
    }

    public void setSetUp(int x) {
        setup = x;
    }

    public void setUp(int x) {
        up = x;
    }

    public void setSetDown(int x) {
        setdown = x;
    }

    public void setDown(int x) {
        down = x;
    }

    public int getContTiro() {
        return conttiro;
    }

    public void addConttiro() {
        conttiro++;
    }
    
    public void addLive(int x) {
        life += x;
        if (life > lifetotal) {
            life = lifetotal;
        }
    }
    public void setToNull(int i){
        tiro[i] = new NullProjectile();
    }
}
