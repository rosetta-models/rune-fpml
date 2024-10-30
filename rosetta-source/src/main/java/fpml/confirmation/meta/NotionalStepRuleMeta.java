package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NotionalStepRule;
import fpml.confirmation.validation.NotionalStepRuleTypeFormatValidator;
import fpml.confirmation.validation.NotionalStepRuleValidator;
import fpml.confirmation.validation.exists.NotionalStepRuleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NotionalStepRule.class)
public class NotionalStepRuleMeta implements RosettaMetaData<NotionalStepRule> {

	@Override
	public List<Validator<? super NotionalStepRule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.NotionalStepRule>create(fpml.confirmation.validation.datarule.NotionalStepRuleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super NotionalStepRule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NotionalStepRule> validator() {
		return new NotionalStepRuleValidator();
	}

	@Override
	public Validator<? super NotionalStepRule> typeFormatValidator() {
		return new NotionalStepRuleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalStepRule, Set<String>> onlyExistsValidator() {
		return new NotionalStepRuleOnlyExistsValidator();
	}
}
