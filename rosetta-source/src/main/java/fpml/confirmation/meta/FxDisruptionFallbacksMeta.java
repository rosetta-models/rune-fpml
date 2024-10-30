package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxDisruptionFallbacks;
import fpml.confirmation.validation.FxDisruptionFallbacksTypeFormatValidator;
import fpml.confirmation.validation.FxDisruptionFallbacksValidator;
import fpml.confirmation.validation.exists.FxDisruptionFallbacksOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxDisruptionFallbacks.class)
public class FxDisruptionFallbacksMeta implements RosettaMetaData<FxDisruptionFallbacks> {

	@Override
	public List<Validator<? super FxDisruptionFallbacks>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruptionFallbacks, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxDisruptionFallbacks> validator() {
		return new FxDisruptionFallbacksValidator();
	}

	@Override
	public Validator<? super FxDisruptionFallbacks> typeFormatValidator() {
		return new FxDisruptionFallbacksTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruptionFallbacks, Set<String>> onlyExistsValidator() {
		return new FxDisruptionFallbacksOnlyExistsValidator();
	}
}
