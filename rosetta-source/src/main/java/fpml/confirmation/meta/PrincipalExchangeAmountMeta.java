package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrincipalExchangeAmount;
import fpml.confirmation.validation.PrincipalExchangeAmountTypeFormatValidator;
import fpml.confirmation.validation.PrincipalExchangeAmountValidator;
import fpml.confirmation.validation.exists.PrincipalExchangeAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PrincipalExchangeAmount.class)
public class PrincipalExchangeAmountMeta implements RosettaMetaData<PrincipalExchangeAmount> {

	@Override
	public List<Validator<? super PrincipalExchangeAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PrincipalExchangeAmount>create(fpml.confirmation.validation.datarule.PrincipalExchangeAmountChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchangeAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PrincipalExchangeAmount> validator() {
		return new PrincipalExchangeAmountValidator();
	}

	@Override
	public Validator<? super PrincipalExchangeAmount> typeFormatValidator() {
		return new PrincipalExchangeAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchangeAmount, Set<String>> onlyExistsValidator() {
		return new PrincipalExchangeAmountOnlyExistsValidator();
	}
}
