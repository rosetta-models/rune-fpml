package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradingWaiver;
import fpml.confirmation.validation.TradingWaiverTypeFormatValidator;
import fpml.confirmation.validation.TradingWaiverValidator;
import fpml.confirmation.validation.exists.TradingWaiverOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradingWaiver.class)
public class TradingWaiverMeta implements RosettaMetaData<TradingWaiver> {

	@Override
	public List<Validator<? super TradingWaiver>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradingWaiver, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradingWaiver> validator() {
		return new TradingWaiverValidator();
	}

	@Override
	public Validator<? super TradingWaiver> typeFormatValidator() {
		return new TradingWaiverTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradingWaiver, Set<String>> onlyExistsValidator() {
		return new TradingWaiverOnlyExistsValidator();
	}
}
