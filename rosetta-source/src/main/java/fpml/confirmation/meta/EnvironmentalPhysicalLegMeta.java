package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EnvironmentalPhysicalLeg;
import fpml.confirmation.validation.EnvironmentalPhysicalLegTypeFormatValidator;
import fpml.confirmation.validation.EnvironmentalPhysicalLegValidator;
import fpml.confirmation.validation.exists.EnvironmentalPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EnvironmentalPhysicalLeg.class)
public class EnvironmentalPhysicalLegMeta implements RosettaMetaData<EnvironmentalPhysicalLeg> {

	@Override
	public List<Validator<? super EnvironmentalPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EnvironmentalPhysicalLeg> validator() {
		return new EnvironmentalPhysicalLegValidator();
	}

	@Override
	public Validator<? super EnvironmentalPhysicalLeg> typeFormatValidator() {
		return new EnvironmentalPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new EnvironmentalPhysicalLegOnlyExistsValidator();
	}
}
