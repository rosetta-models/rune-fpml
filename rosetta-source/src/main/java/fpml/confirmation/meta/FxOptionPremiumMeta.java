package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxOptionPremium;
import fpml.confirmation.validation.FxOptionPremiumTypeFormatValidator;
import fpml.confirmation.validation.FxOptionPremiumValidator;
import fpml.confirmation.validation.exists.FxOptionPremiumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxOptionPremium.class)
public class FxOptionPremiumMeta implements RosettaMetaData<FxOptionPremium> {

	@Override
	public List<Validator<? super FxOptionPremium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxOptionPremium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxOptionPremium> validator() {
		return new FxOptionPremiumValidator();
	}

	@Override
	public Validator<? super FxOptionPremium> typeFormatValidator() {
		return new FxOptionPremiumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxOptionPremium, Set<String>> onlyExistsValidator() {
		return new FxOptionPremiumOnlyExistsValidator();
	}
}
