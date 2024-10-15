package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAverageRate;
import fpml.confirmation.validation.FxAverageRateTypeFormatValidator;
import fpml.confirmation.validation.FxAverageRateValidator;
import fpml.confirmation.validation.exists.FxAverageRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxAverageRate.class)
public class FxAverageRateMeta implements RosettaMetaData<FxAverageRate> {

	@Override
	public List<Validator<? super FxAverageRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxRateObservable>create(fpml.confirmation.validation.datarule.FxRateObservableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAverageRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAverageRate> validator() {
		return new FxAverageRateValidator();
	}

	@Override
	public Validator<? super FxAverageRate> typeFormatValidator() {
		return new FxAverageRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAverageRate, Set<String>> onlyExistsValidator() {
		return new FxAverageRateOnlyExistsValidator();
	}
}
