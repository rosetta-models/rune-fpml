package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeTradedContract;
import fpml.confirmation.validation.ExchangeTradedContractTypeFormatValidator;
import fpml.confirmation.validation.ExchangeTradedContractValidator;
import fpml.confirmation.validation.exists.ExchangeTradedContractOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ExchangeTradedContract.class)
public class ExchangeTradedContractMeta implements RosettaMetaData<ExchangeTradedContract> {

	@Override
	public List<Validator<? super ExchangeTradedContract>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedContract, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeTradedContract> validator() {
		return new ExchangeTradedContractValidator();
	}

	@Override
	public Validator<? super ExchangeTradedContract> typeFormatValidator() {
		return new ExchangeTradedContractTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedContract, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedContractOnlyExistsValidator();
	}
}
