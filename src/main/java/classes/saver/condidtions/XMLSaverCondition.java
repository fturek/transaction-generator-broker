package classes.saver.condidtions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class XMLSaverCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String format = context.getEnvironment().getProperty("format");
        if(format == null){
            return false;
        }
        return format.equals("xml");
    }
}
