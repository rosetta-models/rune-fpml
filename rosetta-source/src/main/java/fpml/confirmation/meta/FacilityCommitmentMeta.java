package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityCommitment;
import fpml.confirmation.validation.FacilityCommitmentTypeFormatValidator;
import fpml.confirmation.validation.FacilityCommitmentValidator;
import fpml.confirmation.validation.exists.FacilityCommitmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FacilityCommitment.class)
public class FacilityCommitmentMeta implements RosettaMetaData<FacilityCommitment> {

	@Override
	public List<Validator<? super FacilityCommitment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityCommitment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityCommitment> validator() {
		return new FacilityCommitmentValidator();
	}

	@Override
	public Validator<? super FacilityCommitment> typeFormatValidator() {
		return new FacilityCommitmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityCommitment, Set<String>> onlyExistsValidator() {
		return new FacilityCommitmentOnlyExistsValidator();
	}
}
