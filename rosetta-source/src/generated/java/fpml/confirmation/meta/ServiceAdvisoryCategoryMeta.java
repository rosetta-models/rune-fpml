package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ServiceAdvisoryCategory;
import fpml.confirmation.validation.ServiceAdvisoryCategoryTypeFormatValidator;
import fpml.confirmation.validation.ServiceAdvisoryCategoryValidator;
import fpml.confirmation.validation.exists.ServiceAdvisoryCategoryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ServiceAdvisoryCategory.class)
public class ServiceAdvisoryCategoryMeta implements RosettaMetaData<ServiceAdvisoryCategory> {

	@Override
	public List<Validator<? super ServiceAdvisoryCategory>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ServiceAdvisoryCategory, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ServiceAdvisoryCategory> validator() {
		return new ServiceAdvisoryCategoryValidator();
	}

	@Override
	public Validator<? super ServiceAdvisoryCategory> typeFormatValidator() {
		return new ServiceAdvisoryCategoryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ServiceAdvisoryCategory, Set<String>> onlyExistsValidator() {
		return new ServiceAdvisoryCategoryOnlyExistsValidator();
	}
}
