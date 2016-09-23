import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import io.springfox.documentation.swagger2.annotations.EnableSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EnableSwagger2
@ComponentScan(basePackages = { "com.sallyfinaljava" })
public class App 
{
    public static void main( String[] args )
    {
//        JdbcDataSource ds = new JdbcDataSource();
//        ds.setURL("jdbc:h2:file:~/learn");
//        ds.setUser("sa");
//        ds.setPassword("");
//        try{
//        Context ctx = new InitialContext();
//        ctx.bind("jdbc/nnn", ds);}
//        catch (NamingException exp)
//        {
//
//        }

        SpringApplication.run(App.class, args);



        System.out.println( "Hello World!" );
    }
}
