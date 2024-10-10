package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DeliveryMethod;
import fpml.confirmation.validation.DeliveryMethodTypeFormatValidator;
import fpml.confirmation.validation.DeliveryMethodValidator;
import fpml.confirmation.validation.exists.DeliveryMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DeliveryMethod.class)
public class DeliveryMethodMeta implements RosettaMetaData<DeliveryMethod> {

	@Override
	public List<Validator<? super DeliveryMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeliveryMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DeliveryMethod> validator() {
		return new DeliveryMethodValidator();
	}

	@Override
	public Validator<? super DeliveryMethod> typeFormatValidator() {
		return new DeliveryMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliveryMethod, Set<String>> onlyExistsValidator() {
		return new DeliveryMethodOnlyExistsValidator();
	}
}
