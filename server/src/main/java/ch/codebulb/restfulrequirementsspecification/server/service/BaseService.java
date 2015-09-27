package ch.codebulb.restfulrequirementsspecification.server.service;

import ch.codebulb.restfulrequirementsspecification.server.model.BaseModel;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

// Mocked implementation
public abstract class BaseService<T extends BaseModel> {
    private final Map<Long, T> ENTITIES = new HashMap<>();
    private long currentId = 0;
    
    public T findById(Long id) {
        return ENTITIES.get(id);
    }
    
    public List<T> findAll() {
        return new ArrayList<>(ENTITIES.values());
    }
    
    public T save(T entity) throws ConstraintViolationException {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(entity);
        if (violations.size() > 0) {
            List<String> violationMessages = new ArrayList<>();
            for (ConstraintViolation<T> violation : violations) {
                violationMessages.add(createConstraintViolationMessage(violation));
            }
            throw new ConstraintViolationException(violationMessages);
        }
        
        // CREATE
        if (entity.getId() == null) {
            entity.setId(currentId++);
        }
        // UPDATE
        ENTITIES.put(entity.getId(), entity);
        
        return entity;
    }

    private static String createConstraintViolationMessage(ConstraintViolation violation) {
        return MessageFormat.format("{0}: {1} ({2})", violation.getPropertyPath(), violation.getMessage(), violation.getInvalidValue());
    }
    
    public void delete(Long id) throws ConstraintViolationException {
        ENTITIES.remove(id);
    }
}
