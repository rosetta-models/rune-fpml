package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Allocations;
import fpml.confirmation.validation.AllocationsTypeFormatValidator;
import fpml.confirmation.validation.AllocationsValidator;
import fpml.confirmation.validation.exists.AllocationsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Allocations.class)
public class AllocationsMeta implements RosettaMetaData<Allocations> {

	@Override
	public List<Validator<? super Allocations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Allocations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Allocations> validator() {
		return new AllocationsValidator();
	}

	@Override
	public Validator<? super Allocations> typeFormatValidator() {
		return new AllocationsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Allocations, Set<String>> onlyExistsValidator() {
		return new AllocationsOnlyExistsValidator();
	}
}
