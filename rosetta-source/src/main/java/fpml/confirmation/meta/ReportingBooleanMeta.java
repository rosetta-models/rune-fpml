package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingBoolean;
import fpml.confirmation.validation.ReportingBooleanTypeFormatValidator;
import fpml.confirmation.validation.ReportingBooleanValidator;
import fpml.confirmation.validation.exists.ReportingBooleanOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingBoolean.class)
public class ReportingBooleanMeta implements RosettaMetaData<ReportingBoolean> {

	@Override
	public List<Validator<? super ReportingBoolean>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingBoolean, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingBoolean> validator() {
		return new ReportingBooleanValidator();
	}

	@Override
	public Validator<? super ReportingBoolean> typeFormatValidator() {
		return new ReportingBooleanTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingBoolean, Set<String>> onlyExistsValidator() {
		return new ReportingBooleanOnlyExistsValidator();
	}
}
