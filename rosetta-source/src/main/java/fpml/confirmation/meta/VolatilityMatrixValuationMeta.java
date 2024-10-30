package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VolatilityMatrixValuation;
import fpml.confirmation.validation.VolatilityMatrixValuationTypeFormatValidator;
import fpml.confirmation.validation.VolatilityMatrixValuationValidator;
import fpml.confirmation.validation.exists.VolatilityMatrixValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=VolatilityMatrixValuation.class)
public class VolatilityMatrixValuationMeta implements RosettaMetaData<VolatilityMatrixValuation> {

	@Override
	public List<Validator<? super VolatilityMatrixValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityMatrixValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VolatilityMatrixValuation> validator() {
		return new VolatilityMatrixValuationValidator();
	}

	@Override
	public Validator<? super VolatilityMatrixValuation> typeFormatValidator() {
		return new VolatilityMatrixValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityMatrixValuation, Set<String>> onlyExistsValidator() {
		return new VolatilityMatrixValuationOnlyExistsValidator();
	}
}
