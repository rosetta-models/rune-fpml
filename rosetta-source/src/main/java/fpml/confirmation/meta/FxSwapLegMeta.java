package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxSwapLeg;
import fpml.confirmation.validation.FxSwapLegTypeFormatValidator;
import fpml.confirmation.validation.FxSwapLegValidator;
import fpml.confirmation.validation.exists.FxSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxSwapLeg.class)
public class FxSwapLegMeta implements RosettaMetaData<FxSwapLeg> {

	@Override
	public List<Validator<? super FxSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxSwapLeg> validator() {
		return new FxSwapLegValidator();
	}

	@Override
	public Validator<? super FxSwapLeg> typeFormatValidator() {
		return new FxSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSwapLeg, Set<String>> onlyExistsValidator() {
		return new FxSwapLegOnlyExistsValidator();
	}
}
