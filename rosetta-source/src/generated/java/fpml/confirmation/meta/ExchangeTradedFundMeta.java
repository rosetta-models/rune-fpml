package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ExchangeTradedFund;
import fpml.confirmation.validation.ExchangeTradedFundTypeFormatValidator;
import fpml.confirmation.validation.ExchangeTradedFundValidator;
import fpml.confirmation.validation.exists.ExchangeTradedFundOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ExchangeTradedFund.class)
public class ExchangeTradedFundMeta implements RosettaMetaData<ExchangeTradedFund> {

	@Override
	public List<Validator<? super ExchangeTradedFund>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExchangeTradedFund, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ExchangeTradedFund> validator() {
		return new ExchangeTradedFundValidator();
	}

	@Override
	public Validator<? super ExchangeTradedFund> typeFormatValidator() {
		return new ExchangeTradedFundTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExchangeTradedFund, Set<String>> onlyExistsValidator() {
		return new ExchangeTradedFundOnlyExistsValidator();
	}
}
