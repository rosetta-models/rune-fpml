package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.YieldCurveMethod;
import fpml.confirmation.validation.YieldCurveMethodTypeFormatValidator;
import fpml.confirmation.validation.YieldCurveMethodValidator;
import fpml.confirmation.validation.exists.YieldCurveMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=YieldCurveMethod.class)
public class YieldCurveMethodMeta implements RosettaMetaData<YieldCurveMethod> {

	@Override
	public List<Validator<? super YieldCurveMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super YieldCurveMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super YieldCurveMethod> validator() {
		return new YieldCurveMethodValidator();
	}

	@Override
	public Validator<? super YieldCurveMethod> typeFormatValidator() {
		return new YieldCurveMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super YieldCurveMethod, Set<String>> onlyExistsValidator() {
		return new YieldCurveMethodOnlyExistsValidator();
	}
}
