package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PenaltyRateChange;
import fpml.confirmation.validation.PenaltyRateChangeTypeFormatValidator;
import fpml.confirmation.validation.PenaltyRateChangeValidator;
import fpml.confirmation.validation.exists.PenaltyRateChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PenaltyRateChange.class)
public class PenaltyRateChangeMeta implements RosettaMetaData<PenaltyRateChange> {

	@Override
	public List<Validator<? super PenaltyRateChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PenaltyRateChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PenaltyRateChange> validator() {
		return new PenaltyRateChangeValidator();
	}

	@Override
	public Validator<? super PenaltyRateChange> typeFormatValidator() {
		return new PenaltyRateChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PenaltyRateChange, Set<String>> onlyExistsValidator() {
		return new PenaltyRateChangeOnlyExistsValidator();
	}
}
