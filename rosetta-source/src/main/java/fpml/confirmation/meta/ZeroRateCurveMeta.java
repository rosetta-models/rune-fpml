package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ZeroRateCurve;
import fpml.confirmation.validation.ZeroRateCurveTypeFormatValidator;
import fpml.confirmation.validation.ZeroRateCurveValidator;
import fpml.confirmation.validation.exists.ZeroRateCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ZeroRateCurve.class)
public class ZeroRateCurveMeta implements RosettaMetaData<ZeroRateCurve> {

	@Override
	public List<Validator<? super ZeroRateCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ZeroRateCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ZeroRateCurve> validator() {
		return new ZeroRateCurveValidator();
	}

	@Override
	public Validator<? super ZeroRateCurve> typeFormatValidator() {
		return new ZeroRateCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ZeroRateCurve, Set<String>> onlyExistsValidator() {
		return new ZeroRateCurveOnlyExistsValidator();
	}
}
