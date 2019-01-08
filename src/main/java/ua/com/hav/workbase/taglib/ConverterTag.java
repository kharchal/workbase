package ua.com.hav.workbase.taglib;

import lombok.Data;
import ua.com.hav.workbase.model.DateConverter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

@Data
public class ConverterTag extends SimpleTagSupport {

    private int convert;

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String string = DateConverter.toString(convert);
        out.print(string);
    }
}
