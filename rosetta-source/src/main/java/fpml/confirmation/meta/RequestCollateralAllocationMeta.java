package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RequestCollateralAllocation;
import fpml.confirmation.validation.RequestCollateralAllocationTypeFormatValidator;
import fpml.confirmation.validation.RequestCollateralAllocationValidator;
import fpml.confirmation.validation.exists.RequestCollateralAllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RequestCollateralAllocation.class)
public class RequestCollateralAllocationMeta implements RosettaMetaData<RequestCollateralAllocation> {

	@Override
	public List<Validator<? super RequestCollateralAllocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestCollateralAllocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RequestCollateralAllocation> validator() {
		return new RequestCollateralAllocationValidator();
	}

	@Override
	public Validator<? super RequestCollateralAllocation> typeFormatValidator() {
		return new RequestCollateralAllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestCollateralAllocation, Set<String>> onlyExistsValidator() {
		return new RequestCollateralAllocationOnlyExistsValidator();
	}
}
