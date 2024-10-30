package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRegimeName;
import fpml.confirmation.validation.ReportingRegimeNameTypeFormatValidator;
import fpml.confirmation.validation.ReportingRegimeNameValidator;
import fpml.confirmation.validation.exists.ReportingRegimeNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingRegimeName.class)
public class ReportingRegimeNameMeta implements RosettaMetaData<ReportingRegimeName> {

	@Override
	public List<Validator<? super ReportingRegimeName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingRegimeName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingRegimeName> validator() {
		return new ReportingRegimeNameValidator();
	}

	@Override
	public Validator<? super ReportingRegimeName> typeFormatValidator() {
		return new ReportingRegimeNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegimeName, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeNameOnlyExistsValidator();
	}
}
