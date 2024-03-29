package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("validators.EMailValidator")
public class EMailValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		Pattern pattern = Pattern.compile(".+@.+\\..+");
		Matcher matcher = pattern.matcher(String.valueOf(value));
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage("E-Mail falsch!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			throw new ValidatorException(msg);
			
		}
		
	}

}
