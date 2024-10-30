package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BoundedVariance;
import fpml.confirmation.validation.BoundedVarianceTypeFormatValidator;
import fpml.confirmation.validation.BoundedVarianceValidator;
import fpml.confirmation.validation.exists.BoundedVarianceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BoundedVariance.class)
public class BoundedVarianceMeta implements RosettaMetaData<BoundedVariance> {

	@Override
	public List<Validator<? super BoundedVariance>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BoundedVariance, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BoundedVariance> validator() {
		return new BoundedVarianceValidator();
	}

	@Override
	public Validator<? super BoundedVariance> typeFormatValidator() {
		return new BoundedVarianceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BoundedVariance, Set<String>> onlyExistsValidator() {
		return new BoundedVarianceOnlyExistsValidator();
	}
}
