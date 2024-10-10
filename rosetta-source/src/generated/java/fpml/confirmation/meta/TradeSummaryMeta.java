package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeSummary;
import fpml.confirmation.validation.TradeSummaryTypeFormatValidator;
import fpml.confirmation.validation.TradeSummaryValidator;
import fpml.confirmation.validation.exists.TradeSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeSummary.class)
public class TradeSummaryMeta implements RosettaMetaData<TradeSummary> {

	@Override
	public List<Validator<? super TradeSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeSummary> validator() {
		return new TradeSummaryValidator();
	}

	@Override
	public Validator<? super TradeSummary> typeFormatValidator() {
		return new TradeSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeSummary, Set<String>> onlyExistsValidator() {
		return new TradeSummaryOnlyExistsValidator();
	}
}
