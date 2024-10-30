package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AllocationContentModel;
import fpml.confirmation.validation.AllocationContentModelTypeFormatValidator;
import fpml.confirmation.validation.AllocationContentModelValidator;
import fpml.confirmation.validation.exists.AllocationContentModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AllocationContentModel.class)
public class AllocationContentModelMeta implements RosettaMetaData<AllocationContentModel> {

	@Override
	public List<Validator<? super AllocationContentModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationContentModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AllocationContentModel> validator() {
		return new AllocationContentModelValidator();
	}

	@Override
	public Validator<? super AllocationContentModel> typeFormatValidator() {
		return new AllocationContentModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationContentModel, Set<String>> onlyExistsValidator() {
		return new AllocationContentModelOnlyExistsValidator();
	}
}
