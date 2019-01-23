package com.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import javafx.print.PrintSides;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

//自定义规则，非启动类可以扫描的包下
/*@Configuration
public class MyRule {

    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}*/

public class MyRule extends AbstractLoadBalancerRule {

    private static final int RANDOM_SIZE = 5;
    private int size = 1 ;
    private int index = 0;
    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
            if(size > RANDOM_SIZE){
                size = 1;
            }
            if(size == 1){
                index = chooseRandomInt(serverCount);
            }
            server = upList.get(index);
            size ++ ;

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
