
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.glfw.GLFW;

public class XBoxController extends Controller {

    int x;
    
    public XBoxController(int x) {
        this.x = x;
        
    }

    @Override
    public FloatBuffer controllerAxes() {
        return GLFW.glfwGetJoystickAxes(x); 
    }

    @Override
    public ByteBuffer controllerButtons() {
        return GLFW.glfwGetJoystickButtons(x); 
    }

    @Override
    public void setButtons(Hero hero) {
        //hero.RT =
    }
    
    

}
