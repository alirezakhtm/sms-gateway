package ir.navaco.mcb.sms.gateway.register.config;

import javax.xml.bind.annotation.XmlElement;

public class XMLAPI {
    private String name;
    private String url;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
