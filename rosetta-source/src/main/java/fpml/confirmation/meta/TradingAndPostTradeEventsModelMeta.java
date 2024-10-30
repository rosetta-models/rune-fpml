package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradingAndPostTradeEventsModel;
import fpml.confirmation.validation.TradingAndPostTradeEventsModelTypeFormatValidator;
import fpml.confirmation.validation.TradingAndPostTradeEventsModelValidator;
import fpml.confirmation.validation.exists.TradingAndPostTradeEventsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradingAndPostTradeEventsModel.class)
public class TradingAndPostTradeEventsModelMeta implements RosettaMetaData<TradingAndPostTradeEventsModel> {

	@Override
	public List<Validator<? super TradingAndPostTradeEventsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradingAndPostTradeEventsModel>create(fpml.confirmation.validation.datarule.TradingAndPostTradeEventsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradingAndPostTradeEventsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradingAndPostTradeEventsModel> validator() {
		return new TradingAndPostTradeEventsModelValidator();
	}

	@Override
	public Validator<? super TradingAndPostTradeEventsModel> typeFormatValidator() {
		return new TradingAndPostTradeEventsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradingAndPostTradeEventsModel, Set<String>> onlyExistsValidator() {
		return new TradingAndPostTradeEventsModelOnlyExistsValidator();
	}
}
