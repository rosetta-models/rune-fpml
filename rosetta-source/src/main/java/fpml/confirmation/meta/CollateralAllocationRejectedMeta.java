package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralAllocationRejected;
import fpml.confirmation.validation.CollateralAllocationRejectedTypeFormatValidator;
import fpml.confirmation.validation.CollateralAllocationRejectedValidator;
import fpml.confirmation.validation.exists.CollateralAllocationRejectedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CollateralAllocationRejected.class)
public class CollateralAllocationRejectedMeta implements RosettaMetaData<CollateralAllocationRejected> {

	@Override
	public List<Validator<? super CollateralAllocationRejected>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralAllocationRejected, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralAllocationRejected> validator() {
		return new CollateralAllocationRejectedValidator();
	}

	@Override
	public Validator<? super CollateralAllocationRejected> typeFormatValidator() {
		return new CollateralAllocationRejectedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralAllocationRejected, Set<String>> onlyExistsValidator() {
		return new CollateralAllocationRejectedOnlyExistsValidator();
	}
}
