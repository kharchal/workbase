package ua.com.hav.workbase.taglib;

import lombok.Data;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

@Data
public class ButtonTag extends SimpleTagSupport {

    private String url;
    private String urlend = "";
    private String id = "";
    private String text;
    private String color = "default";
    private List rights;

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (!rights.contains(url + text + "/" + urlend)) {
            String s = "<a href=\"" + url + text + "/" + id + "\" class=\"btn btn-" + color + " btn-xs\">" + text + "</a>";
            out.print(s);
        }
    }
}
