package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VolatilityLeg;
import fpml.confirmation.validation.VolatilityLegTypeFormatValidator;
import fpml.confirmation.validation.VolatilityLegValidator;
import fpml.confirmation.validation.exists.VolatilityLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=VolatilityLeg.class)
public class VolatilityLegMeta implements RosettaMetaData<VolatilityLeg> {

	@Override
	public List<Validator<? super VolatilityLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VolatilityLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VolatilityLeg> validator() {
		return new VolatilityLegValidator();
	}

	@Override
	public Validator<? super VolatilityLeg> typeFormatValidator() {
		return new VolatilityLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilityLeg, Set<String>> onlyExistsValidator() {
		return new VolatilityLegOnlyExistsValidator();
	}
}
