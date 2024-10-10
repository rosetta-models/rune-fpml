package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InterestAccrualsCompoundingMethod;
import fpml.confirmation.validation.InterestAccrualsCompoundingMethodTypeFormatValidator;
import fpml.confirmation.validation.InterestAccrualsCompoundingMethodValidator;
import fpml.confirmation.validation.exists.InterestAccrualsCompoundingMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=InterestAccrualsCompoundingMethod.class)
public class InterestAccrualsCompoundingMethodMeta implements RosettaMetaData<InterestAccrualsCompoundingMethod> {

	@Override
	public List<Validator<? super InterestAccrualsCompoundingMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.InterestAccrualsMethod>create(fpml.confirmation.validation.datarule.InterestAccrualsMethodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestAccrualsCompoundingMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InterestAccrualsCompoundingMethod> validator() {
		return new InterestAccrualsCompoundingMethodValidator();
	}

	@Override
	public Validator<? super InterestAccrualsCompoundingMethod> typeFormatValidator() {
		return new InterestAccrualsCompoundingMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAccrualsCompoundingMethod, Set<String>> onlyExistsValidator() {
		return new InterestAccrualsCompoundingMethodOnlyExistsValidator();
	}
}
