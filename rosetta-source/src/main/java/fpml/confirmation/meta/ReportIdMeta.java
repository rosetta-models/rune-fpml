package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportId;
import fpml.confirmation.validation.ReportIdTypeFormatValidator;
import fpml.confirmation.validation.ReportIdValidator;
import fpml.confirmation.validation.exists.ReportIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReportId.class)
public class ReportIdMeta implements RosettaMetaData<ReportId> {

	@Override
	public List<Validator<? super ReportId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportId> validator() {
		return new ReportIdValidator();
	}

	@Override
	public Validator<? super ReportId> typeFormatValidator() {
		return new ReportIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportId, Set<String>> onlyExistsValidator() {
		return new ReportIdOnlyExistsValidator();
	}
}
