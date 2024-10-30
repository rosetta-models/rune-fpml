package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RolloverChoice;
import fpml.confirmation.validation.RolloverChoiceTypeFormatValidator;
import fpml.confirmation.validation.RolloverChoiceValidator;
import fpml.confirmation.validation.exists.RolloverChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RolloverChoice.class)
public class RolloverChoiceMeta implements RosettaMetaData<RolloverChoice> {

	@Override
	public List<Validator<? super RolloverChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.RolloverChoice>create(fpml.confirmation.validation.datarule.RolloverChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RolloverChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RolloverChoice> validator() {
		return new RolloverChoiceValidator();
	}

	@Override
	public Validator<? super RolloverChoice> typeFormatValidator() {
		return new RolloverChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RolloverChoice, Set<String>> onlyExistsValidator() {
		return new RolloverChoiceOnlyExistsValidator();
	}
}
