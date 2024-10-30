package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxOptionPayout;
import fpml.confirmation.validation.FxOptionPayoutTypeFormatValidator;
import fpml.confirmation.validation.FxOptionPayoutValidator;
import fpml.confirmation.validation.exists.FxOptionPayoutOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxOptionPayout.class)
public class FxOptionPayoutMeta implements RosettaMetaData<FxOptionPayout> {

	@Override
	public List<Validator<? super FxOptionPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxOptionPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxOptionPayout> validator() {
		return new FxOptionPayoutValidator();
	}

	@Override
	public Validator<? super FxOptionPayout> typeFormatValidator() {
		return new FxOptionPayoutTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOptionPayout, Set<String>> onlyExistsValidator() {
		return new FxOptionPayoutOnlyExistsValidator();
	}
}
