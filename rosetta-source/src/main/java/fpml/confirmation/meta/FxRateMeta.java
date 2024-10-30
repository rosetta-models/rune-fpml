package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxRate;
import fpml.confirmation.validation.FxRateTypeFormatValidator;
import fpml.confirmation.validation.FxRateValidator;
import fpml.confirmation.validation.exists.FxRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxRate.class)
public class FxRateMeta implements RosettaMetaData<FxRate> {

	@Override
	public List<Validator<? super FxRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxRate> validator() {
		return new FxRateValidator();
	}

	@Override
	public Validator<? super FxRate> typeFormatValidator() {
		return new FxRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRate, Set<String>> onlyExistsValidator() {
		return new FxRateOnlyExistsValidator();
	}
}
