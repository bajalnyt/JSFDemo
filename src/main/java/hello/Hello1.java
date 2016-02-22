package hello;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "hello1")
public class Hello1 {

    final String message = "Hello World!";

    public String getMessage() {
        return message;
    }
}