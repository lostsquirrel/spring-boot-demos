package demo.spring.boot.config.config;

//@Component
//@Configuratnt
//@ConfigurationProperties(prefix = "foo")
public class FooProperties {

    private String bar;

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
