package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityCommitmentModel;
import fpml.confirmation.validation.FacilityCommitmentModelTypeFormatValidator;
import fpml.confirmation.validation.FacilityCommitmentModelValidator;
import fpml.confirmation.validation.exists.FacilityCommitmentModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityCommitmentModel.class)
public class FacilityCommitmentModelMeta implements RosettaMetaData<FacilityCommitmentModel> {

	@Override
	public List<Validator<? super FacilityCommitmentModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityCommitmentModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityCommitmentModel> validator() {
		return new FacilityCommitmentModelValidator();
	}

	@Override
	public Validator<? super FacilityCommitmentModel> typeFormatValidator() {
		return new FacilityCommitmentModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityCommitmentModel, Set<String>> onlyExistsValidator() {
		return new FacilityCommitmentModelOnlyExistsValidator();
	}
}
