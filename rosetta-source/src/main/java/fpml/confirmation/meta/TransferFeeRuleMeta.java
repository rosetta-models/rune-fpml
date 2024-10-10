package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TransferFeeRule;
import fpml.confirmation.validation.TransferFeeRuleTypeFormatValidator;
import fpml.confirmation.validation.TransferFeeRuleValidator;
import fpml.confirmation.validation.exists.TransferFeeRuleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TransferFeeRule.class)
public class TransferFeeRuleMeta implements RosettaMetaData<TransferFeeRule> {

	@Override
	public List<Validator<? super TransferFeeRule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransferFeeRule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TransferFeeRule> validator() {
		return new TransferFeeRuleValidator();
	}

	@Override
	public Validator<? super TransferFeeRule> typeFormatValidator() {
		return new TransferFeeRuleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransferFeeRule, Set<String>> onlyExistsValidator() {
		return new TransferFeeRuleOnlyExistsValidator();
	}
}
