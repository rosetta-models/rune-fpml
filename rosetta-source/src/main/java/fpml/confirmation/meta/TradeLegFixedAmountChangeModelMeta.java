package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeLegFixedAmountChangeModel;
import fpml.confirmation.validation.TradeLegFixedAmountChangeModelTypeFormatValidator;
import fpml.confirmation.validation.TradeLegFixedAmountChangeModelValidator;
import fpml.confirmation.validation.exists.TradeLegFixedAmountChangeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeLegFixedAmountChangeModel.class)
public class TradeLegFixedAmountChangeModelMeta implements RosettaMetaData<TradeLegFixedAmountChangeModel> {

	@Override
	public List<Validator<? super TradeLegFixedAmountChangeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeLegFixedAmountChangeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeLegFixedAmountChangeModel> validator() {
		return new TradeLegFixedAmountChangeModelValidator();
	}

	@Override
	public Validator<? super TradeLegFixedAmountChangeModel> typeFormatValidator() {
		return new TradeLegFixedAmountChangeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeLegFixedAmountChangeModel, Set<String>> onlyExistsValidator() {
		return new TradeLegFixedAmountChangeModelOnlyExistsValidator();
	}
}
