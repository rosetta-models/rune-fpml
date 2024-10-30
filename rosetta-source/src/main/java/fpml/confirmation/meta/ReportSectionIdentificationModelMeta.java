package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportSectionIdentificationModel;
import fpml.confirmation.validation.ReportSectionIdentificationModelTypeFormatValidator;
import fpml.confirmation.validation.ReportSectionIdentificationModelValidator;
import fpml.confirmation.validation.exists.ReportSectionIdentificationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportSectionIdentificationModel.class)
public class ReportSectionIdentificationModelMeta implements RosettaMetaData<ReportSectionIdentificationModel> {

	@Override
	public List<Validator<? super ReportSectionIdentificationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportSectionIdentificationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportSectionIdentificationModel> validator() {
		return new ReportSectionIdentificationModelValidator();
	}

	@Override
	public Validator<? super ReportSectionIdentificationModel> typeFormatValidator() {
		return new ReportSectionIdentificationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportSectionIdentificationModel, Set<String>> onlyExistsValidator() {
		return new ReportSectionIdentificationModelOnlyExistsValidator();
	}
}
