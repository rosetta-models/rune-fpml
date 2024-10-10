package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CorrelationLeg;
import fpml.confirmation.validation.CorrelationLegTypeFormatValidator;
import fpml.confirmation.validation.CorrelationLegValidator;
import fpml.confirmation.validation.exists.CorrelationLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CorrelationLeg.class)
public class CorrelationLegMeta implements RosettaMetaData<CorrelationLeg> {

	@Override
	public List<Validator<? super CorrelationLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CorrelationLeg> validator() {
		return new CorrelationLegValidator();
	}

	@Override
	public Validator<? super CorrelationLeg> typeFormatValidator() {
		return new CorrelationLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationLeg, Set<String>> onlyExistsValidator() {
		return new CorrelationLegOnlyExistsValidator();
	}
}
