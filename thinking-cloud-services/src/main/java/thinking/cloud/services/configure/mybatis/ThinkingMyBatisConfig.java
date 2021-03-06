package thinking.cloud.services.configure.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import thinking.cloud.services.handler.MybatisLimitInterceptor;

/**
 * MyBatis的配置对象
 * <P>
 * 	MyBatis的配置对象
 * </P>
 * @author thinking
 * @date 2021年2月16日
 */
@Configuration
public class ThinkingMyBatisConfig {
    /**
     * 添加mybatis分页拦截器
     * @return
     */    
    @Bean
    public MybatisLimitInterceptor limitInterceptor(){
        return new MybatisLimitInterceptor();
    }
}
