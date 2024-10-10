package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PrincipalExchangeDescriptions;
import fpml.confirmation.validation.PrincipalExchangeDescriptionsTypeFormatValidator;
import fpml.confirmation.validation.PrincipalExchangeDescriptionsValidator;
import fpml.confirmation.validation.exists.PrincipalExchangeDescriptionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PrincipalExchangeDescriptions.class)
public class PrincipalExchangeDescriptionsMeta implements RosettaMetaData<PrincipalExchangeDescriptions> {

	@Override
	public List<Validator<? super PrincipalExchangeDescriptions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchangeDescriptions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PrincipalExchangeDescriptions> validator() {
		return new PrincipalExchangeDescriptionsValidator();
	}

	@Override
	public Validator<? super PrincipalExchangeDescriptions> typeFormatValidator() {
		return new PrincipalExchangeDescriptionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchangeDescriptions, Set<String>> onlyExistsValidator() {
		return new PrincipalExchangeDescriptionsOnlyExistsValidator();
	}
}
