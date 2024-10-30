package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotionalStepRuleSequence;
import fpml.confirmation.validation.NotionalStepRuleSequenceTypeFormatValidator;
import fpml.confirmation.validation.NotionalStepRuleSequenceValidator;
import fpml.confirmation.validation.exists.NotionalStepRuleSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NotionalStepRuleSequence.class)
public class NotionalStepRuleSequenceMeta implements RosettaMetaData<NotionalStepRuleSequence> {

	@Override
	public List<Validator<? super NotionalStepRuleSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalStepRuleSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NotionalStepRuleSequence> validator() {
		return new NotionalStepRuleSequenceValidator();
	}

	@Override
	public Validator<? super NotionalStepRuleSequence> typeFormatValidator() {
		return new NotionalStepRuleSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalStepRuleSequence, Set<String>> onlyExistsValidator() {
		return new NotionalStepRuleSequenceOnlyExistsValidator();
	}
}
