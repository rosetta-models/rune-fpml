package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AllocationRefused;
import fpml.confirmation.validation.AllocationRefusedTypeFormatValidator;
import fpml.confirmation.validation.AllocationRefusedValidator;
import fpml.confirmation.validation.exists.AllocationRefusedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AllocationRefused.class)
public class AllocationRefusedMeta implements RosettaMetaData<AllocationRefused> {

	@Override
	public List<Validator<? super AllocationRefused>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationRefused, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AllocationRefused> validator() {
		return new AllocationRefusedValidator();
	}

	@Override
	public Validator<? super AllocationRefused> typeFormatValidator() {
		return new AllocationRefusedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationRefused, Set<String>> onlyExistsValidator() {
		return new AllocationRefusedOnlyExistsValidator();
	}
}
