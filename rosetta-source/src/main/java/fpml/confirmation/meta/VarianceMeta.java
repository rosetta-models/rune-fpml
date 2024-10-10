package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Variance;
import fpml.confirmation.validation.VarianceTypeFormatValidator;
import fpml.confirmation.validation.VarianceValidator;
import fpml.confirmation.validation.exists.VarianceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Variance.class)
public class VarianceMeta implements RosettaMetaData<Variance> {

	@Override
	public List<Validator<? super Variance>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationFromObservation>create(fpml.confirmation.validation.datarule.CalculationFromObservationChoice.class),
			factory.<fpml.confirmation.Variance>create(fpml.confirmation.validation.datarule.VarianceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Variance, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Variance> validator() {
		return new VarianceValidator();
	}

	@Override
	public Validator<? super Variance> typeFormatValidator() {
		return new VarianceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Variance, Set<String>> onlyExistsValidator() {
		return new VarianceOnlyExistsValidator();
	}
}
