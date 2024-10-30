package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeLegNotionalChangeModel;
import fpml.confirmation.validation.TradeLegNotionalChangeModelTypeFormatValidator;
import fpml.confirmation.validation.TradeLegNotionalChangeModelValidator;
import fpml.confirmation.validation.exists.TradeLegNotionalChangeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeLegNotionalChangeModel.class)
public class TradeLegNotionalChangeModelMeta implements RosettaMetaData<TradeLegNotionalChangeModel> {

	@Override
	public List<Validator<? super TradeLegNotionalChangeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeLegNotionalChangeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeLegNotionalChangeModel> validator() {
		return new TradeLegNotionalChangeModelValidator();
	}

	@Override
	public Validator<? super TradeLegNotionalChangeModel> typeFormatValidator() {
		return new TradeLegNotionalChangeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeLegNotionalChangeModel, Set<String>> onlyExistsValidator() {
		return new TradeLegNotionalChangeModelOnlyExistsValidator();
	}
}
