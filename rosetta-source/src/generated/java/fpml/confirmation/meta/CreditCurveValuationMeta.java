package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CreditCurveValuation;
import fpml.confirmation.validation.CreditCurveValuationTypeFormatValidator;
import fpml.confirmation.validation.CreditCurveValuationValidator;
import fpml.confirmation.validation.exists.CreditCurveValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CreditCurveValuation.class)
public class CreditCurveValuationMeta implements RosettaMetaData<CreditCurveValuation> {

	@Override
	public List<Validator<? super CreditCurveValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditCurveValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CreditCurveValuation> validator() {
		return new CreditCurveValuationValidator();
	}

	@Override
	public Validator<? super CreditCurveValuation> typeFormatValidator() {
		return new CreditCurveValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditCurveValuation, Set<String>> onlyExistsValidator() {
		return new CreditCurveValuationOnlyExistsValidator();
	}
}
