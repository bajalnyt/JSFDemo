package hello;

/**
 * Created by 908752 on 2/22/16.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "hello2")
@RequestScoped
public class Hello2 {

    @ManagedProperty(value="#{message}")
    private Message messageBean;

    private String message;

    public String getMessage() {
        if(messageBean != null){
            message = messageBean.getMessage();
        }
        return message;
    }
    public void setMessageBean(Message message) {
        this.messageBean = message;
    }
}