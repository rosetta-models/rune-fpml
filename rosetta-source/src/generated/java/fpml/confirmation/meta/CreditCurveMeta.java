package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditCurve;
import fpml.confirmation.validation.CreditCurveTypeFormatValidator;
import fpml.confirmation.validation.CreditCurveValidator;
import fpml.confirmation.validation.exists.CreditCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditCurve.class)
public class CreditCurveMeta implements RosettaMetaData<CreditCurve> {

	@Override
	public List<Validator<? super CreditCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditCurve> validator() {
		return new CreditCurveValidator();
	}

	@Override
	public Validator<? super CreditCurve> typeFormatValidator() {
		return new CreditCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditCurve, Set<String>> onlyExistsValidator() {
		return new CreditCurveOnlyExistsValidator();
	}
}
