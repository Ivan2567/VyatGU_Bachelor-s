import java.lang.annotation.*;
import java.util.ArrayList;
@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
@interface MarkingAnnotation { }
//@interface Tablesd{String title() default "title"; }

    public class exmpl {
        //@Tablesd()
        @MarkingAnnotation
        public int markedMethod() {
            System.out.println("Java");  int k = 0;return k;
        }
        @MarkingAnnotation
        public void markedMethod2() {
            System.out.println("Java");
        }



    }
