package com.example.timetable.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.Ordered;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.timetable.utils.Constants.*;
import static org.springframework.core.env.AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME;

@Slf4j
@Configuration
public class PropertySourceConfig {

  @Bean
  static PropertySourcesPlaceholderConfigurer configurer() throws IOException {

    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
    ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();

    String profile = System.getProperty(ACTIVE_PROFILES_PROPERTY_NAME);
    profile = (null == profile ? LOCAL_ENVIRONMENT_PROFILE : profile);

    Resource[] projectResources =
        patternResolver.getResources(String.format(RESOURCE_FILE_PATH_PATTERN, profile));

    List<Resource> externalizedResourcesList = new ArrayList<>();
    RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
    String externalPropResourceDir =
        runtimeMxBean.getSystemProperties().get(EXTERNAL_PROPERTY_RESOURCE);

    Resource[] externalResources =
        patternResolver.getResources(
            String.format(EXTERNAL_RESOURCE_FILE_PATH_PATTERN, externalPropResourceDir));
    externalizedResourcesList.addAll(Arrays.asList(externalResources));
    externalizedResourcesList.addAll(Arrays.asList(projectResources));

    Resource[] allResources = externalizedResourcesList.toArray(new Resource[0]);
    configurer.setLocations(allResources);
    configurer.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return configurer;
  }
}
