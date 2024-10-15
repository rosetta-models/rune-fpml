package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxVarianceSwap;
import fpml.confirmation.validation.FxVarianceSwapTypeFormatValidator;
import fpml.confirmation.validation.FxVarianceSwapValidator;
import fpml.confirmation.validation.exists.FxVarianceSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxVarianceSwap.class)
public class FxVarianceSwapMeta implements RosettaMetaData<FxVarianceSwap> {

	@Override
	public List<Validator<? super FxVarianceSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxPerformanceSwap>create(fpml.confirmation.validation.datarule.FxPerformanceSwapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxVarianceSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxVarianceSwap> validator() {
		return new FxVarianceSwapValidator();
	}

	@Override
	public Validator<? super FxVarianceSwap> typeFormatValidator() {
		return new FxVarianceSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxVarianceSwap, Set<String>> onlyExistsValidator() {
		return new FxVarianceSwapOnlyExistsValidator();
	}
}
