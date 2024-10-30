package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TriggerChoice;
import fpml.confirmation.validation.TriggerChoiceTypeFormatValidator;
import fpml.confirmation.validation.TriggerChoiceValidator;
import fpml.confirmation.validation.exists.TriggerChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TriggerChoice.class)
public class TriggerChoiceMeta implements RosettaMetaData<TriggerChoice> {

	@Override
	public List<Validator<? super TriggerChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TriggerChoice>create(fpml.confirmation.validation.datarule.TriggerChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TriggerChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TriggerChoice> validator() {
		return new TriggerChoiceValidator();
	}

	@Override
	public Validator<? super TriggerChoice> typeFormatValidator() {
		return new TriggerChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TriggerChoice, Set<String>> onlyExistsValidator() {
		return new TriggerChoiceOnlyExistsValidator();
	}
}
