package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AllocationReportingStatus;
import fpml.confirmation.validation.AllocationReportingStatusTypeFormatValidator;
import fpml.confirmation.validation.AllocationReportingStatusValidator;
import fpml.confirmation.validation.exists.AllocationReportingStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=AllocationReportingStatus.class)
public class AllocationReportingStatusMeta implements RosettaMetaData<AllocationReportingStatus> {

	@Override
	public List<Validator<? super AllocationReportingStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AllocationReportingStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AllocationReportingStatus> validator() {
		return new AllocationReportingStatusValidator();
	}

	@Override
	public Validator<? super AllocationReportingStatus> typeFormatValidator() {
		return new AllocationReportingStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AllocationReportingStatus, Set<String>> onlyExistsValidator() {
		return new AllocationReportingStatusOnlyExistsValidator();
	}
}
