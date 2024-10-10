package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Correlation;
import fpml.confirmation.validation.CorrelationTypeFormatValidator;
import fpml.confirmation.validation.CorrelationValidator;
import fpml.confirmation.validation.exists.CorrelationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Correlation.class)
public class CorrelationMeta implements RosettaMetaData<Correlation> {

	@Override
	public List<Validator<? super Correlation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CalculationFromObservation>create(fpml.confirmation.validation.datarule.CalculationFromObservationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Correlation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Correlation> validator() {
		return new CorrelationValidator();
	}

	@Override
	public Validator<? super Correlation> typeFormatValidator() {
		return new CorrelationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Correlation, Set<String>> onlyExistsValidator() {
		return new CorrelationOnlyExistsValidator();
	}
}
