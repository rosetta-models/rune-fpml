package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ForwardRateCurve;
import fpml.confirmation.validation.ForwardRateCurveTypeFormatValidator;
import fpml.confirmation.validation.ForwardRateCurveValidator;
import fpml.confirmation.validation.exists.ForwardRateCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ForwardRateCurve.class)
public class ForwardRateCurveMeta implements RosettaMetaData<ForwardRateCurve> {

	@Override
	public List<Validator<? super ForwardRateCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ForwardRateCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ForwardRateCurve> validator() {
		return new ForwardRateCurveValidator();
	}

	@Override
	public Validator<? super ForwardRateCurve> typeFormatValidator() {
		return new ForwardRateCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ForwardRateCurve, Set<String>> onlyExistsValidator() {
		return new ForwardRateCurveOnlyExistsValidator();
	}
}
