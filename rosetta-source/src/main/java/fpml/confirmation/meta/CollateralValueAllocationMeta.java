package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralValueAllocation;
import fpml.confirmation.validation.CollateralValueAllocationTypeFormatValidator;
import fpml.confirmation.validation.CollateralValueAllocationValidator;
import fpml.confirmation.validation.exists.CollateralValueAllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CollateralValueAllocation.class)
public class CollateralValueAllocationMeta implements RosettaMetaData<CollateralValueAllocation> {

	@Override
	public List<Validator<? super CollateralValueAllocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralValueAllocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralValueAllocation> validator() {
		return new CollateralValueAllocationValidator();
	}

	@Override
	public Validator<? super CollateralValueAllocation> typeFormatValidator() {
		return new CollateralValueAllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralValueAllocation, Set<String>> onlyExistsValidator() {
		return new CollateralValueAllocationOnlyExistsValidator();
	}
}
