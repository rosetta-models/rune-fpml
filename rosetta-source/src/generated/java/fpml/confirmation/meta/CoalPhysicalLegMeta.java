package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalPhysicalLeg;
import fpml.confirmation.validation.CoalPhysicalLegTypeFormatValidator;
import fpml.confirmation.validation.CoalPhysicalLegValidator;
import fpml.confirmation.validation.exists.CoalPhysicalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CoalPhysicalLeg.class)
public class CoalPhysicalLegMeta implements RosettaMetaData<CoalPhysicalLeg> {

	@Override
	public List<Validator<? super CoalPhysicalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalPhysicalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalPhysicalLeg> validator() {
		return new CoalPhysicalLegValidator();
	}

	@Override
	public Validator<? super CoalPhysicalLeg> typeFormatValidator() {
		return new CoalPhysicalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalPhysicalLeg, Set<String>> onlyExistsValidator() {
		return new CoalPhysicalLegOnlyExistsValidator();
	}
}
