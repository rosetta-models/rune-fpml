package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradingEventsModel;
import fpml.confirmation.validation.TradingEventsModelTypeFormatValidator;
import fpml.confirmation.validation.TradingEventsModelValidator;
import fpml.confirmation.validation.exists.TradingEventsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradingEventsModel.class)
public class TradingEventsModelMeta implements RosettaMetaData<TradingEventsModel> {

	@Override
	public List<Validator<? super TradingEventsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradingEventsModel>create(fpml.confirmation.validation.datarule.TradingEventsModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradingEventsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradingEventsModel> validator() {
		return new TradingEventsModelValidator();
	}

	@Override
	public Validator<? super TradingEventsModel> typeFormatValidator() {
		return new TradingEventsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradingEventsModel, Set<String>> onlyExistsValidator() {
		return new TradingEventsModelOnlyExistsValidator();
	}
}
