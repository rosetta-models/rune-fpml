package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeRestrictions;
import fpml.confirmation.validation.ExchangeRestrictionsTypeFormatValidator;
import fpml.confirmation.validation.ExchangeRestrictionsValidator;
import fpml.confirmation.validation.exists.ExchangeRestrictionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeRestrictions.class)
public class ExchangeRestrictionsMeta implements RosettaMetaData<ExchangeRestrictions> {

	@Override
	public List<Validator<? super ExchangeRestrictions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeRestrictions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeRestrictions> validator() {
		return new ExchangeRestrictionsValidator();
	}

	@Override
	public Validator<? super ExchangeRestrictions> typeFormatValidator() {
		return new ExchangeRestrictionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeRestrictions, Set<String>> onlyExistsValidator() {
		return new ExchangeRestrictionsOnlyExistsValidator();
	}
}
