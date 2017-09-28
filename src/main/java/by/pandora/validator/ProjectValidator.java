package by.pandora.validator;


import by.pandora.model.Project;
import by.pandora.model.User;
import by.pandora.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link  .pandora.model.User} class,
 * implements {@link Validator} interface.
 *
 * @author Gulevich Ulyana
 * @version 1.0
 */

@Component
public class ProjectValidator implements Validator {

    @Autowired
    private ProjectService projectService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Project project = (Project) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (project.getName().length() < 8 || project.getName().length() > 255) {
            errors.rejectValue("name", "Size.projectForm.name");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Required");
        if (project.getDescription().length() < 100) {
            errors.rejectValue("description", "Size.projectForm.description");
        }
    }
}
