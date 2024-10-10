package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.YieldCurveValuation;
import fpml.confirmation.validation.YieldCurveValuationTypeFormatValidator;
import fpml.confirmation.validation.YieldCurveValuationValidator;
import fpml.confirmation.validation.exists.YieldCurveValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=YieldCurveValuation.class)
public class YieldCurveValuationMeta implements RosettaMetaData<YieldCurveValuation> {

	@Override
	public List<Validator<? super YieldCurveValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super YieldCurveValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super YieldCurveValuation> validator() {
		return new YieldCurveValuationValidator();
	}

	@Override
	public Validator<? super YieldCurveValuation> typeFormatValidator() {
		return new YieldCurveValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super YieldCurveValuation, Set<String>> onlyExistsValidator() {
		return new YieldCurveValuationOnlyExistsValidator();
	}
}
