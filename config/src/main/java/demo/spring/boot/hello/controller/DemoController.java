package demo.spring.boot.hello.controller;

import demo.spring.boot.hello.config.FooProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

@RestController
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    final FooProperties fooProperties;

    @Autowired
    Environment env;

    public DemoController(FooProperties fooProperties) {
        this.fooProperties = fooProperties;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/foo")
    @ResponseBody
    FooProperties foo() {
        return fooProperties;
    }

    @GetMapping("/sys")
    @ResponseBody
    Properties sys() {
        return System.getProperties();
    }

    @GetMapping("/env")
    @ResponseBody
    Map<String, Object> env() {
        Map<String, Object> map = new HashMap();
        for(Iterator it = ((AbstractEnvironment) env).getPropertySources().iterator(); it.hasNext(); ) {
            PropertySource propertySource = (PropertySource) it.next();
            if (propertySource instanceof MapPropertySource) {
                map.putAll(((MapPropertySource) propertySource).getSource());
                log.debug("Map PropertySource: %s", propertySource);
            } else {
                log.debug("None Map PropertySource: %s", propertySource);
            }
        }
        return map;
    }

}
