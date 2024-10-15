package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrincipalExchange;
import fpml.confirmation.validation.PrincipalExchangeTypeFormatValidator;
import fpml.confirmation.validation.PrincipalExchangeValidator;
import fpml.confirmation.validation.exists.PrincipalExchangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PrincipalExchange.class)
public class PrincipalExchangeMeta implements RosettaMetaData<PrincipalExchange> {

	@Override
	public List<Validator<? super PrincipalExchange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PrincipalExchange> validator() {
		return new PrincipalExchangeValidator();
	}

	@Override
	public Validator<? super PrincipalExchange> typeFormatValidator() {
		return new PrincipalExchangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchange, Set<String>> onlyExistsValidator() {
		return new PrincipalExchangeOnlyExistsValidator();
	}
}
