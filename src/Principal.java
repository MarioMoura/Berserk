
import javax.swing.JFrame;
import org.lwjgl.glfw.GLFW;

public class Principal {

    public static void main(String[] args) {
        
        Sprites sprite = new Sprites();

        JFrame tela = new JFrame();
        Game q = new Game();
        
        q.Pad();
        tela.add(q);
        tela.setSize(1215, 710);
        tela.setTitle("BERSERK");
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setIconImage(sprite.Icon);
        while(true){
            GLFW.glfwPollEvents();
        }
        
        
    }

}
