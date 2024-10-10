package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradingEventsBaseModel;
import fpml.confirmation.validation.TradingEventsBaseModelTypeFormatValidator;
import fpml.confirmation.validation.TradingEventsBaseModelValidator;
import fpml.confirmation.validation.exists.TradingEventsBaseModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradingEventsBaseModel.class)
public class TradingEventsBaseModelMeta implements RosettaMetaData<TradingEventsBaseModel> {

	@Override
	public List<Validator<? super TradingEventsBaseModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradingEventsBaseModel>create(fpml.confirmation.validation.datarule.TradingEventsBaseModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradingEventsBaseModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradingEventsBaseModel> validator() {
		return new TradingEventsBaseModelValidator();
	}

	@Override
	public Validator<? super TradingEventsBaseModel> typeFormatValidator() {
		return new TradingEventsBaseModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradingEventsBaseModel, Set<String>> onlyExistsValidator() {
		return new TradingEventsBaseModelOnlyExistsValidator();
	}
}
