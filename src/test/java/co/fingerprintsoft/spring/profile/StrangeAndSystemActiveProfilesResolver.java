package co.fingerprintsoft.spring.profile;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ActiveProfilesResolver;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: naeem
 * Date: 2014/10/04
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
public class StrangeAndSystemActiveProfilesResolver implements ActiveProfilesResolver {

    private static final Log logger = LogFactory.getLog(StrangeAndSystemActiveProfilesResolver.class);


    /**
     * Resolve the <em>bean definition profiles</em> for the given {@linkplain
     * Class test class} based on profiles configured declaratively via
     * {@link ActiveProfiles#profiles} or {@link ActiveProfiles#value}.
     * @param testClass the test class for which the profiles should be resolved;
     * never {@code null}
     * @return the list of bean definition profiles to use when loading the
     * {@code ApplicationContext}; never {@code null}
     */
    @Override
    public String[] resolve(Class<?> testClass) {
        Assert.notNull(testClass, "Class must not be null");
        final Set<String> activeProfiles = new HashSet<String>();

        Set<String> sProfiles = StringUtils.commaDelimitedListToSet(System.getProperty("spring.profiles.active"));
        activeProfiles.addAll(sProfiles);
        activeProfiles.add("strange");

        return StringUtils.toStringArray(activeProfiles);
    }
}