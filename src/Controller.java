
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.glfw.GLFW;


public class Controller {
    public ByteBuffer controllerButtons(){
        return GLFW.glfwGetJoystickButtons(GLFW.GLFW_JOYSTICK_1);
    }
    public FloatBuffer controllerAxes(){
        return GLFW.glfwGetJoystickAxes(GLFW.GLFW_JOYSTICK_1);
    }
    public void setButtons(Hero hero){
        
    }
    
    
}
