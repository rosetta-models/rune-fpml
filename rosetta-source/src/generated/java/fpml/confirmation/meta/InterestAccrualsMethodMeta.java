package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestAccrualsMethod;
import fpml.confirmation.validation.InterestAccrualsMethodTypeFormatValidator;
import fpml.confirmation.validation.InterestAccrualsMethodValidator;
import fpml.confirmation.validation.exists.InterestAccrualsMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestAccrualsMethod.class)
public class InterestAccrualsMethodMeta implements RosettaMetaData<InterestAccrualsMethod> {

	@Override
	public List<Validator<? super InterestAccrualsMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.InterestAccrualsMethod>create(fpml.confirmation.validation.datarule.InterestAccrualsMethodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestAccrualsMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestAccrualsMethod> validator() {
		return new InterestAccrualsMethodValidator();
	}

	@Override
	public Validator<? super InterestAccrualsMethod> typeFormatValidator() {
		return new InterestAccrualsMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAccrualsMethod, Set<String>> onlyExistsValidator() {
		return new InterestAccrualsMethodOnlyExistsValidator();
	}
}
