package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAverageStrike;
import fpml.confirmation.validation.FxAverageStrikeTypeFormatValidator;
import fpml.confirmation.validation.FxAverageStrikeValidator;
import fpml.confirmation.validation.exists.FxAverageStrikeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAverageStrike.class)
public class FxAverageStrikeMeta implements RosettaMetaData<FxAverageStrike> {

	@Override
	public List<Validator<? super FxAverageStrike>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxRateObservable>create(fpml.confirmation.validation.datarule.FxRateObservableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAverageStrike, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAverageStrike> validator() {
		return new FxAverageStrikeValidator();
	}

	@Override
	public Validator<? super FxAverageStrike> typeFormatValidator() {
		return new FxAverageStrikeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAverageStrike, Set<String>> onlyExistsValidator() {
		return new FxAverageStrikeOnlyExistsValidator();
	}
}
