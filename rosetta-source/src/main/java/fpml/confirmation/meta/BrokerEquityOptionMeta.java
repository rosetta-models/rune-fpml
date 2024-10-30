package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BrokerEquityOption;
import fpml.confirmation.validation.BrokerEquityOptionTypeFormatValidator;
import fpml.confirmation.validation.BrokerEquityOptionValidator;
import fpml.confirmation.validation.exists.BrokerEquityOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BrokerEquityOption.class)
public class BrokerEquityOptionMeta implements RosettaMetaData<BrokerEquityOption> {

	@Override
	public List<Validator<? super BrokerEquityOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BrokerEquityOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BrokerEquityOption> validator() {
		return new BrokerEquityOptionValidator();
	}

	@Override
	public Validator<? super BrokerEquityOption> typeFormatValidator() {
		return new BrokerEquityOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BrokerEquityOption, Set<String>> onlyExistsValidator() {
		return new BrokerEquityOptionOnlyExistsValidator();
	}
}
