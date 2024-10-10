package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PhysicalSwapLeg;
import fpml.confirmation.validation.PhysicalSwapLegTypeFormatValidator;
import fpml.confirmation.validation.PhysicalSwapLegValidator;
import fpml.confirmation.validation.exists.PhysicalSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PhysicalSwapLeg.class)
public class PhysicalSwapLegMeta implements RosettaMetaData<PhysicalSwapLeg> {

	@Override
	public List<Validator<? super PhysicalSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PhysicalSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PhysicalSwapLeg> validator() {
		return new PhysicalSwapLegValidator();
	}

	@Override
	public Validator<? super PhysicalSwapLeg> typeFormatValidator() {
		return new PhysicalSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PhysicalSwapLeg, Set<String>> onlyExistsValidator() {
		return new PhysicalSwapLegOnlyExistsValidator();
	}
}
