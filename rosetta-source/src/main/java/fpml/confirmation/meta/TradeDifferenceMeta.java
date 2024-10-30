package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeDifference;
import fpml.confirmation.validation.TradeDifferenceTypeFormatValidator;
import fpml.confirmation.validation.TradeDifferenceValidator;
import fpml.confirmation.validation.exists.TradeDifferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeDifference.class)
public class TradeDifferenceMeta implements RosettaMetaData<TradeDifference> {

	@Override
	public List<Validator<? super TradeDifference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeDifference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeDifference> validator() {
		return new TradeDifferenceValidator();
	}

	@Override
	public Validator<? super TradeDifference> typeFormatValidator() {
		return new TradeDifferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeDifference, Set<String>> onlyExistsValidator() {
		return new TradeDifferenceOnlyExistsValidator();
	}
}
