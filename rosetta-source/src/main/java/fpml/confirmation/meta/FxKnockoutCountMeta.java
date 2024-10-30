package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxKnockoutCount;
import fpml.confirmation.validation.FxKnockoutCountTypeFormatValidator;
import fpml.confirmation.validation.FxKnockoutCountValidator;
import fpml.confirmation.validation.exists.FxKnockoutCountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxKnockoutCount.class)
public class FxKnockoutCountMeta implements RosettaMetaData<FxKnockoutCount> {

	@Override
	public List<Validator<? super FxKnockoutCount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxKnockoutCount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxKnockoutCount> validator() {
		return new FxKnockoutCountValidator();
	}

	@Override
	public Validator<? super FxKnockoutCount> typeFormatValidator() {
		return new FxKnockoutCountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxKnockoutCount, Set<String>> onlyExistsValidator() {
		return new FxKnockoutCountOnlyExistsValidator();
	}
}
