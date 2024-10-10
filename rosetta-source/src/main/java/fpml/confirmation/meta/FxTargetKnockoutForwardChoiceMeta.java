package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxTargetKnockoutForwardChoice;
import fpml.confirmation.validation.FxTargetKnockoutForwardChoiceTypeFormatValidator;
import fpml.confirmation.validation.FxTargetKnockoutForwardChoiceValidator;
import fpml.confirmation.validation.exists.FxTargetKnockoutForwardChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxTargetKnockoutForwardChoice.class)
public class FxTargetKnockoutForwardChoiceMeta implements RosettaMetaData<FxTargetKnockoutForwardChoice> {

	@Override
	public List<Validator<? super FxTargetKnockoutForwardChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxTargetKnockoutForwardChoice>create(fpml.confirmation.validation.datarule.FxTargetKnockoutForwardChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxTargetKnockoutForwardChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxTargetKnockoutForwardChoice> validator() {
		return new FxTargetKnockoutForwardChoiceValidator();
	}

	@Override
	public Validator<? super FxTargetKnockoutForwardChoice> typeFormatValidator() {
		return new FxTargetKnockoutForwardChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetKnockoutForwardChoice, Set<String>> onlyExistsValidator() {
		return new FxTargetKnockoutForwardChoiceOnlyExistsValidator();
	}
}
