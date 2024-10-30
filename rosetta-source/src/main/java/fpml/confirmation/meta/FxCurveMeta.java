package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxCurve;
import fpml.confirmation.validation.FxCurveTypeFormatValidator;
import fpml.confirmation.validation.FxCurveValidator;
import fpml.confirmation.validation.exists.FxCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxCurve.class)
public class FxCurveMeta implements RosettaMetaData<FxCurve> {

	@Override
	public List<Validator<? super FxCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxCurve> validator() {
		return new FxCurveValidator();
	}

	@Override
	public Validator<? super FxCurve> typeFormatValidator() {
		return new FxCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxCurve, Set<String>> onlyExistsValidator() {
		return new FxCurveOnlyExistsValidator();
	}
}
