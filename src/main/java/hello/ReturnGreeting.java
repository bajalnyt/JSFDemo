package hello;

/**
 * Created by 908752 on 2/22/16.
 */
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class ReturnGreeting implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWelcomeMessage(){
        return "Hello " + (name==null?"":name) +", from AJAX";
    }
}