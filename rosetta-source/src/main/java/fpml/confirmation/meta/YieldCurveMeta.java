package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.YieldCurve;
import fpml.confirmation.validation.YieldCurveTypeFormatValidator;
import fpml.confirmation.validation.YieldCurveValidator;
import fpml.confirmation.validation.exists.YieldCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=YieldCurve.class)
public class YieldCurveMeta implements RosettaMetaData<YieldCurve> {

	@Override
	public List<Validator<? super YieldCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super YieldCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super YieldCurve> validator() {
		return new YieldCurveValidator();
	}

	@Override
	public Validator<? super YieldCurve> typeFormatValidator() {
		return new YieldCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super YieldCurve, Set<String>> onlyExistsValidator() {
		return new YieldCurveOnlyExistsValidator();
	}
}
