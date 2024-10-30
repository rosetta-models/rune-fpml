package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeLegNotionalScheduleChangeModel;
import fpml.confirmation.validation.TradeLegNotionalScheduleChangeModelTypeFormatValidator;
import fpml.confirmation.validation.TradeLegNotionalScheduleChangeModelValidator;
import fpml.confirmation.validation.exists.TradeLegNotionalScheduleChangeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeLegNotionalScheduleChangeModel.class)
public class TradeLegNotionalScheduleChangeModelMeta implements RosettaMetaData<TradeLegNotionalScheduleChangeModel> {

	@Override
	public List<Validator<? super TradeLegNotionalScheduleChangeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeLegNotionalScheduleChangeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeLegNotionalScheduleChangeModel> validator() {
		return new TradeLegNotionalScheduleChangeModelValidator();
	}

	@Override
	public Validator<? super TradeLegNotionalScheduleChangeModel> typeFormatValidator() {
		return new TradeLegNotionalScheduleChangeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeLegNotionalScheduleChangeModel, Set<String>> onlyExistsValidator() {
		return new TradeLegNotionalScheduleChangeModelOnlyExistsValidator();
	}
}
