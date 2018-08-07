
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.lwjgl.glfw.GLFW;

public class Game extends JPanel implements KeyListener, ActionListener {

    AudioClip click = Applet.newAudioClip(getClass().getResource("/Sound/buttonclick.wav"));

    private static final int Start_Menu = 1;
    private static final int Mode_Choice_Menu = 2;
    private static final int Character_Choice_Menu = 3;
    private static final int Game_Itself = 4;
    private static final int Victory_Menu = 5;

    int gState = 1;

    int equipment1 = 1;
    int equipment2 = 1;

    Fase_1 fase1 = new Fase_1();

    Menu m = new Menu();

    Hero hero;
    Hero hero2;

    int victory = 1;

    int fases = 1;

    private int gameSpeed = 130;

    Timer timer = new Timer(gameSpeed, this);

    JLabel arrow11 = new JLabel();
    JLabel arrow12 = new JLabel();
    JLabel arrow21 = new JLabel();
    JLabel arrow22 = new JLabel();

    Block block = new Block(100, 100, 150, 150);

    int A[] = new int[2];

    int DpadRight[] = new int[2];
    int DpadLeft[] = new int[2];

    ByteBuffer buttons[] = new ByteBuffer[2];
    boolean controllersPresence[] = {false, false};

    public Game() {
        GLFW.glfwInit();
        setLabelArrow11(this);
        setLabelArrow12(this);
        setLabelArrow21(this);
        setLabelArrow22(this);
    }

    public void Pad() {
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        timer.start();
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gState == Start_Menu) {
            m.drawMenu(g);
            useControllers();
        } else if (gState == Mode_Choice_Menu) {
            m.drawModeChoiceMenu(g, this);
            useControllers();
        } else if (gState == Character_Choice_Menu) {
            m.drawCharacterChoiceMenu(g, this);
            useControllers();

        } else if (gState == Game_Itself) {
            gamerender(g);
            this.remove(arrow11);
            this.remove(arrow12);
            this.remove(arrow21);
            this.remove(arrow22);
            tests();

            g.drawRect(hero.collision.x, hero.collision.y, hero.collision.width, hero.collision.height);
        } else if (gState == Victory_Menu) {
            m.drawVictory(g, this);
            useControllers();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gState == Start_Menu) {
            gState = Mode_Choice_Menu;
        } else if (gState == Mode_Choice_Menu) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                gState = Character_Choice_Menu;

            }
        } else if (gState == Character_Choice_Menu) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (GLFW.glfwJoystickPresent(GLFW.GLFW_JOYSTICK_1) | GLFW.glfwJoystickPresent(1)) {
                    gState = Game_Itself;
                    setHeros();
                }
            }
        } else if (gState == Game_Itself) {

        } else if (gState == Victory_Menu) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                gState = 1;

            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();

    }

    public void gametests() {

    }

    public void gamerender(Graphics g) {

        fase1.desenharParede(g,hero,hero2);
        fase1.colisoesFase_1(this, hero.tiro, hero);
        fase1.colisoesFase_1(this, hero2.tiro, hero2);

        hero.CALLHERO(g, this, hero2);
        hero2.CALLHERO(g, this, hero);
    }

    public void setHeros() {
        timer.setDelay(15);
        switch (equipment1) {
            case 1:
                hero = new MB(167, 415, 0);
                break;
            case 2:
                hero = new Ares(167, 415, 0);
                break;
            case 3:
                hero = new Juggernaut(167, 415, 0);
                break;
            case 4:
                hero = new MrCnl(167, 415, 0);
                break;
        }
        switch (equipment2) {
            case 1:
                hero2 = new MB(867, 415, 1);
                break;
            case 2:
                hero2 = new Ares(867, 415, 1);
                break;
            case 3:
                hero2 = new Juggernaut(867, 415, 1);
                break;
            case 4:
                hero2 = new MrCnl(867, 415, 1);
                break;
        }

    }

    public void tests() {
        if (hero.life < 1) {
            gState = Victory_Menu;
            victory = 2;
            timer.setDelay(130);
        }

        if (hero2.life < 1) {
            gState = Victory_Menu;
            victory = 1;
            timer.setDelay(130);
        }

    }

    private void useControllers() {
        if (GLFW.glfwJoystickPresent(0)) {
            controllersPresence[0] = GLFW.glfwJoystickPresent(0);
            buttons[0] = GLFW.glfwGetJoystickButtons(0);
            A[0] = buttons[0].get(0);
            DpadRight[0] = buttons[0].get(11);
            DpadLeft[0] = buttons[0].get(13);
            if (A[0] == 1) {
                changegState();
            }
            if (DpadRight[0] == 1) {
                equipment1++;
                if (equipment1 > 4) {
                    equipment1 = 1;
                }
                click.play();
            } else if (DpadLeft[0] == 1) {
                equipment1--;
                if (equipment1 < 1) {
                    equipment1 = 4;
                }
                click.play();
            }
        }
        if (GLFW.glfwJoystickPresent(1)) {
            controllersPresence[1] = GLFW.glfwJoystickPresent(1);
            buttons[1] = GLFW.glfwGetJoystickButtons(1);
            A[1] = buttons[1].get(0);
            DpadRight[1] = buttons[1].get(11);
            DpadLeft[1] = buttons[1].get(13);
            if (A[1] == 1) {
                changegState();
            }
            if (DpadRight[1] == 1) {
                equipment2++;
                if (equipment2 > 4) {
                    equipment2 = 1;
                }
                click.play();
            } else if (DpadLeft[1] == 1) {
                equipment2--;
                if (equipment2 < 1) {
                    equipment2 = 4;
                }
                click.play();
            }
        }
    }

    public void setLabelArrow11(Game game) {
        arrow11.setLocation(200 + 200, 260);
        arrow11.setSize(50, 50);
        arrow11.setIcon(new ImageIcon(getClass().getResource("/Imagens/Arrow1.png")));
        arrow11.setVisible(true);
        arrow11.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                equipment1++;
                if (equipment1 > 4) {
                    equipment1 = 1;
                }
                click.play();

            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                arrow11.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });

    }

    public void setLabelArrow12(Game game) {
        arrow12.setLocation(200 - 80, 260);
        arrow12.setSize(50, 50);
        arrow12.setIcon(new ImageIcon(getClass().getResource("/Imagens/Arrow2.png")));
        arrow12.setVisible(true);
        arrow12.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                equipment1--;
                if (equipment1 < 1) {
                    equipment1 = 4;
                }
                click.play();
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                arrow12.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });

    }

    public void setLabelArrow21(Game game) {
        arrow21.setLocation(200 + 800, 260);
        arrow21.setSize(50, 50);
        arrow21.setIcon(new ImageIcon(getClass().getResource("/Imagens/Arrow1.png")));
        arrow21.setVisible(true);
        arrow21.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                equipment2++;
                if (equipment2 > 4) {
                    equipment2 = 1;
                }
                click.play();
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                arrow21.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });

    }

    public void setLabelArrow22(Game game) {
        arrow22.setLocation(200 + 520, 260);
        arrow22.setSize(50, 50);
        arrow22.setIcon(new ImageIcon(getClass().getResource("/Imagens/Arrow2.png")));
        arrow22.setVisible(true);
        arrow22.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                equipment2--;
                if (equipment2 < 1) {
                    equipment2 = 4;
                }
                click.play();
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                arrow22.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {

            }
        });

    }

    public void changegState() {
        switch (gState) {
            case Start_Menu:
                gState = Mode_Choice_Menu;
                break;
            case Mode_Choice_Menu:
                gState = Character_Choice_Menu;
                break;
            case Character_Choice_Menu:
                setHeros();
                gState = Game_Itself;
                break;
            case Victory_Menu:
                gState = Start_Menu;
                break;
        }
    }
}
