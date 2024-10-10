package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommitmentSchedule;
import fpml.confirmation.validation.CommitmentScheduleTypeFormatValidator;
import fpml.confirmation.validation.CommitmentScheduleValidator;
import fpml.confirmation.validation.exists.CommitmentScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommitmentSchedule.class)
public class CommitmentScheduleMeta implements RosettaMetaData<CommitmentSchedule> {

	@Override
	public List<Validator<? super CommitmentSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommitmentSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommitmentSchedule> validator() {
		return new CommitmentScheduleValidator();
	}

	@Override
	public Validator<? super CommitmentSchedule> typeFormatValidator() {
		return new CommitmentScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommitmentSchedule, Set<String>> onlyExistsValidator() {
		return new CommitmentScheduleOnlyExistsValidator();
	}
}
