package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRegimeSequence0;
import fpml.confirmation.validation.ReportingRegimeSequence0TypeFormatValidator;
import fpml.confirmation.validation.ReportingRegimeSequence0Validator;
import fpml.confirmation.validation.exists.ReportingRegimeSequence0OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingRegimeSequence0.class)
public class ReportingRegimeSequence0Meta implements RosettaMetaData<ReportingRegimeSequence0> {

	@Override
	public List<Validator<? super ReportingRegimeSequence0>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingRegimeSequence0, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingRegimeSequence0> validator() {
		return new ReportingRegimeSequence0Validator();
	}

	@Override
	public Validator<? super ReportingRegimeSequence0> typeFormatValidator() {
		return new ReportingRegimeSequence0TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegimeSequence0, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeSequence0OnlyExistsValidator();
	}
}
