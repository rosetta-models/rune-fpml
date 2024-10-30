package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.WeightedPartialDerivative;
import fpml.confirmation.validation.WeightedPartialDerivativeTypeFormatValidator;
import fpml.confirmation.validation.WeightedPartialDerivativeValidator;
import fpml.confirmation.validation.exists.WeightedPartialDerivativeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=WeightedPartialDerivative.class)
public class WeightedPartialDerivativeMeta implements RosettaMetaData<WeightedPartialDerivative> {

	@Override
	public List<Validator<? super WeightedPartialDerivative>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WeightedPartialDerivative, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super WeightedPartialDerivative> validator() {
		return new WeightedPartialDerivativeValidator();
	}

	@Override
	public Validator<? super WeightedPartialDerivative> typeFormatValidator() {
		return new WeightedPartialDerivativeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WeightedPartialDerivative, Set<String>> onlyExistsValidator() {
		return new WeightedPartialDerivativeOnlyExistsValidator();
	}
}
