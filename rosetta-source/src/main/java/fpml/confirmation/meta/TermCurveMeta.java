package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TermCurve;
import fpml.confirmation.validation.TermCurveTypeFormatValidator;
import fpml.confirmation.validation.TermCurveValidator;
import fpml.confirmation.validation.exists.TermCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TermCurve.class)
public class TermCurveMeta implements RosettaMetaData<TermCurve> {

	@Override
	public List<Validator<? super TermCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TermCurve> validator() {
		return new TermCurveValidator();
	}

	@Override
	public Validator<? super TermCurve> typeFormatValidator() {
		return new TermCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermCurve, Set<String>> onlyExistsValidator() {
		return new TermCurveOnlyExistsValidator();
	}
}
