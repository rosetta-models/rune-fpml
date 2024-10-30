package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommitmentChange;
import fpml.confirmation.validation.CommitmentChangeTypeFormatValidator;
import fpml.confirmation.validation.CommitmentChangeValidator;
import fpml.confirmation.validation.exists.CommitmentChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommitmentChange.class)
public class CommitmentChangeMeta implements RosettaMetaData<CommitmentChange> {

	@Override
	public List<Validator<? super CommitmentChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommitmentChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommitmentChange> validator() {
		return new CommitmentChangeValidator();
	}

	@Override
	public Validator<? super CommitmentChange> typeFormatValidator() {
		return new CommitmentChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommitmentChange, Set<String>> onlyExistsValidator() {
		return new CommitmentChangeOnlyExistsValidator();
	}
}
