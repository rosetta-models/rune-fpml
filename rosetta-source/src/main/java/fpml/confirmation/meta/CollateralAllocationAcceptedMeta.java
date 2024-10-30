package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralAllocationAccepted;
import fpml.confirmation.validation.CollateralAllocationAcceptedTypeFormatValidator;
import fpml.confirmation.validation.CollateralAllocationAcceptedValidator;
import fpml.confirmation.validation.exists.CollateralAllocationAcceptedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CollateralAllocationAccepted.class)
public class CollateralAllocationAcceptedMeta implements RosettaMetaData<CollateralAllocationAccepted> {

	@Override
	public List<Validator<? super CollateralAllocationAccepted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralAllocationAccepted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralAllocationAccepted> validator() {
		return new CollateralAllocationAcceptedValidator();
	}

	@Override
	public Validator<? super CollateralAllocationAccepted> typeFormatValidator() {
		return new CollateralAllocationAcceptedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralAllocationAccepted, Set<String>> onlyExistsValidator() {
		return new CollateralAllocationAcceptedOnlyExistsValidator();
	}
}
