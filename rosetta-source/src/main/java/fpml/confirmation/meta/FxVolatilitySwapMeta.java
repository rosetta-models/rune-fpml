package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxVolatilitySwap;
import fpml.confirmation.validation.FxVolatilitySwapTypeFormatValidator;
import fpml.confirmation.validation.FxVolatilitySwapValidator;
import fpml.confirmation.validation.exists.FxVolatilitySwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FxVolatilitySwap.class)
public class FxVolatilitySwapMeta implements RosettaMetaData<FxVolatilitySwap> {

	@Override
	public List<Validator<? super FxVolatilitySwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxPerformanceSwap>create(fpml.confirmation.validation.datarule.FxPerformanceSwapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxVolatilitySwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxVolatilitySwap> validator() {
		return new FxVolatilitySwapValidator();
	}

	@Override
	public Validator<? super FxVolatilitySwap> typeFormatValidator() {
		return new FxVolatilitySwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxVolatilitySwap, Set<String>> onlyExistsValidator() {
		return new FxVolatilitySwapOnlyExistsValidator();
	}
}
