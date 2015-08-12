package za.co.fingerprints.multipart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * A Spring bean post processor that ensures we can use matrix variables in our URLs.
 * <p>
 * The post processor modifies the <code>RequestMappingHandlerMapping</code> bean specifying that it should not remove
 * semi colon's from URL's when handling any HTTP requests.
 */
@Component
public class RequestMappingHandlerMappingProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        if (bean instanceof RequestMappingHandlerMapping) {
            ((RequestMappingHandlerMapping) bean).setRemoveSemicolonContent(false);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


}
