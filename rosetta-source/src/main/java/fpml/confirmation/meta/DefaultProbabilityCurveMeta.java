package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DefaultProbabilityCurve;
import fpml.confirmation.validation.DefaultProbabilityCurveTypeFormatValidator;
import fpml.confirmation.validation.DefaultProbabilityCurveValidator;
import fpml.confirmation.validation.exists.DefaultProbabilityCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DefaultProbabilityCurve.class)
public class DefaultProbabilityCurveMeta implements RosettaMetaData<DefaultProbabilityCurve> {

	@Override
	public List<Validator<? super DefaultProbabilityCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DefaultProbabilityCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DefaultProbabilityCurve> validator() {
		return new DefaultProbabilityCurveValidator();
	}

	@Override
	public Validator<? super DefaultProbabilityCurve> typeFormatValidator() {
		return new DefaultProbabilityCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DefaultProbabilityCurve, Set<String>> onlyExistsValidator() {
		return new DefaultProbabilityCurveOnlyExistsValidator();
	}
}
