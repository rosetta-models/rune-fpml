package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Allocation;
import fpml.confirmation.validation.AllocationTypeFormatValidator;
import fpml.confirmation.validation.AllocationValidator;
import fpml.confirmation.validation.exists.AllocationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=Allocation.class)
public class AllocationMeta implements RosettaMetaData<Allocation> {

	@Override
	public List<Validator<? super Allocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.Allocation>create(fpml.confirmation.validation.datarule.AllocationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Allocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Allocation> validator() {
		return new AllocationValidator();
	}

	@Override
	public Validator<? super Allocation> typeFormatValidator() {
		return new AllocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Allocation, Set<String>> onlyExistsValidator() {
		return new AllocationOnlyExistsValidator();
	}
}
