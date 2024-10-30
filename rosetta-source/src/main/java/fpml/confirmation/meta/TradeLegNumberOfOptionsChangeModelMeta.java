package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel;
import fpml.confirmation.validation.TradeLegNumberOfOptionsChangeModelTypeFormatValidator;
import fpml.confirmation.validation.TradeLegNumberOfOptionsChangeModelValidator;
import fpml.confirmation.validation.exists.TradeLegNumberOfOptionsChangeModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeLegNumberOfOptionsChangeModel.class)
public class TradeLegNumberOfOptionsChangeModelMeta implements RosettaMetaData<TradeLegNumberOfOptionsChangeModel> {

	@Override
	public List<Validator<? super TradeLegNumberOfOptionsChangeModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeLegNumberOfOptionsChangeModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeLegNumberOfOptionsChangeModel> validator() {
		return new TradeLegNumberOfOptionsChangeModelValidator();
	}

	@Override
	public Validator<? super TradeLegNumberOfOptionsChangeModel> typeFormatValidator() {
		return new TradeLegNumberOfOptionsChangeModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeLegNumberOfOptionsChangeModel, Set<String>> onlyExistsValidator() {
		return new TradeLegNumberOfOptionsChangeModelOnlyExistsValidator();
	}
}
