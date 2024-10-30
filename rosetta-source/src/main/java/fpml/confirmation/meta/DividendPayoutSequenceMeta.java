package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DividendPayoutSequence;
import fpml.confirmation.validation.DividendPayoutSequenceTypeFormatValidator;
import fpml.confirmation.validation.DividendPayoutSequenceValidator;
import fpml.confirmation.validation.exists.DividendPayoutSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=DividendPayoutSequence.class)
public class DividendPayoutSequenceMeta implements RosettaMetaData<DividendPayoutSequence> {

	@Override
	public List<Validator<? super DividendPayoutSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DividendPayoutSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DividendPayoutSequence> validator() {
		return new DividendPayoutSequenceValidator();
	}

	@Override
	public Validator<? super DividendPayoutSequence> typeFormatValidator() {
		return new DividendPayoutSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPayoutSequence, Set<String>> onlyExistsValidator() {
		return new DividendPayoutSequenceOnlyExistsValidator();
	}
}
