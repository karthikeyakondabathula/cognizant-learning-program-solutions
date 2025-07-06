import com.example.service.ReaderAssist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpot
{

public static void main ( String[] a )
{
ApplicationContext thingy = new ClassPathXmlApplicationContext ("applicationContext.xml");
ReaderAssist dude = (ReaderAssist) thingy.getBean ("bookHelper");
dude.helpFindBooks( );
}

}
