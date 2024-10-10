package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurrentPriorCommitmentModel;
import fpml.confirmation.validation.CurrentPriorCommitmentModelTypeFormatValidator;
import fpml.confirmation.validation.CurrentPriorCommitmentModelValidator;
import fpml.confirmation.validation.exists.CurrentPriorCommitmentModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CurrentPriorCommitmentModel.class)
public class CurrentPriorCommitmentModelMeta implements RosettaMetaData<CurrentPriorCommitmentModel> {

	@Override
	public List<Validator<? super CurrentPriorCommitmentModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CurrentPriorCommitmentModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CurrentPriorCommitmentModel> validator() {
		return new CurrentPriorCommitmentModelValidator();
	}

	@Override
	public Validator<? super CurrentPriorCommitmentModel> typeFormatValidator() {
		return new CurrentPriorCommitmentModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CurrentPriorCommitmentModel, Set<String>> onlyExistsValidator() {
		return new CurrentPriorCommitmentModelOnlyExistsValidator();
	}
}
