package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxStraddlePremium;
import fpml.confirmation.validation.FxStraddlePremiumTypeFormatValidator;
import fpml.confirmation.validation.FxStraddlePremiumValidator;
import fpml.confirmation.validation.exists.FxStraddlePremiumOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxStraddlePremium.class)
public class FxStraddlePremiumMeta implements RosettaMetaData<FxStraddlePremium> {

	@Override
	public List<Validator<? super FxStraddlePremium>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxStraddlePremium, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxStraddlePremium> validator() {
		return new FxStraddlePremiumValidator();
	}

	@Override
	public Validator<? super FxStraddlePremium> typeFormatValidator() {
		return new FxStraddlePremiumTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxStraddlePremium, Set<String>> onlyExistsValidator() {
		return new FxStraddlePremiumOnlyExistsValidator();
	}
}
