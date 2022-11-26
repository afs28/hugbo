package is.hi.hbv501g.hugbo.Security;
// https://www.section.io/engineering-education/springboot-antmatchers/
// https://stackoverflow.com/questions/48371540/spring-security-the-dependencies-of-some-of-the-beans-in-the-application-contex


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;
    /**
     * This classes is unused
     * it was supposed to be for login but a simpler solution was used instead
    */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        /*
        http.csrf().disable()
                .authorizeRequests()
                //.antMatchers("/","loginPage", "recipe/**").permitAll()
                .antMatchers("/list", "/create").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/loginPage").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .logout().permitAll()
                .and()
                .httpBasic();

         */
    }
/*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select recipeUsername, recipeUserpassword "
                        + "from recipeUser "
                        + "where recipeUser = ?");
                /*.authoritiesByUsernameQuery("select email,authority "
                        + "from authorities "
                        + "where email = ?");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();

    }

 */
}

