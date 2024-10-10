package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingPurpose;
import fpml.confirmation.validation.ReportingPurposeTypeFormatValidator;
import fpml.confirmation.validation.ReportingPurposeValidator;
import fpml.confirmation.validation.exists.ReportingPurposeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReportingPurpose.class)
public class ReportingPurposeMeta implements RosettaMetaData<ReportingPurpose> {

	@Override
	public List<Validator<? super ReportingPurpose>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingPurpose, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingPurpose> validator() {
		return new ReportingPurposeValidator();
	}

	@Override
	public Validator<? super ReportingPurpose> typeFormatValidator() {
		return new ReportingPurposeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingPurpose, Set<String>> onlyExistsValidator() {
		return new ReportingPurposeOnlyExistsValidator();
	}
}
