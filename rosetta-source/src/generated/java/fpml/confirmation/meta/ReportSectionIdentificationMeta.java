package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportSectionIdentification;
import fpml.confirmation.validation.ReportSectionIdentificationTypeFormatValidator;
import fpml.confirmation.validation.ReportSectionIdentificationValidator;
import fpml.confirmation.validation.exists.ReportSectionIdentificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReportSectionIdentification.class)
public class ReportSectionIdentificationMeta implements RosettaMetaData<ReportSectionIdentification> {

	@Override
	public List<Validator<? super ReportSectionIdentification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportSectionIdentification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportSectionIdentification> validator() {
		return new ReportSectionIdentificationValidator();
	}

	@Override
	public Validator<? super ReportSectionIdentification> typeFormatValidator() {
		return new ReportSectionIdentificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportSectionIdentification, Set<String>> onlyExistsValidator() {
		return new ReportSectionIdentificationOnlyExistsValidator();
	}
}
