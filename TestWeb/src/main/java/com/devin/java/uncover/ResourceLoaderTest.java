package com.devin.java.uncover;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Created by devin on 2017/1/24.
 */
public class ResourceLoaderTest {

    public static class  ResourceLoaderBean implements ResourceLoaderAware {

        private ResourceLoader resourceLoader;

        @Override
        public void setResourceLoader(ResourceLoader resourceLoader) {
            this.resourceLoader = resourceLoader;
        }

        public ResourceLoader getResourceLoader() {
            return resourceLoader;
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-uncover.xml");
        ResourceLoaderBean resourceLoaderBean = context.getBean("resourceLoaderBean", ResourceLoaderBean.class);
        Resource resource = resourceLoaderBean.getResourceLoader().getResource("spring/spring-beans.xml");
        System.out.println(resource instanceof ClassPathResource);
    }

}
