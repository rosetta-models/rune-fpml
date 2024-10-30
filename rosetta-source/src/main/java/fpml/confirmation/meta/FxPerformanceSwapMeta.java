package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxPerformanceSwap;
import fpml.confirmation.validation.FxPerformanceSwapTypeFormatValidator;
import fpml.confirmation.validation.FxPerformanceSwapValidator;
import fpml.confirmation.validation.exists.FxPerformanceSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxPerformanceSwap.class)
public class FxPerformanceSwapMeta implements RosettaMetaData<FxPerformanceSwap> {

	@Override
	public List<Validator<? super FxPerformanceSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxPerformanceSwap>create(fpml.confirmation.validation.datarule.FxPerformanceSwapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxPerformanceSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxPerformanceSwap> validator() {
		return new FxPerformanceSwapValidator();
	}

	@Override
	public Validator<? super FxPerformanceSwap> typeFormatValidator() {
		return new FxPerformanceSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxPerformanceSwap, Set<String>> onlyExistsValidator() {
		return new FxPerformanceSwapOnlyExistsValidator();
	}
}
