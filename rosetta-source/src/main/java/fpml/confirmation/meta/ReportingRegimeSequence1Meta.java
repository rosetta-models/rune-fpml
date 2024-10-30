package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRegimeSequence1;
import fpml.confirmation.validation.ReportingRegimeSequence1TypeFormatValidator;
import fpml.confirmation.validation.ReportingRegimeSequence1Validator;
import fpml.confirmation.validation.exists.ReportingRegimeSequence1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingRegimeSequence1.class)
public class ReportingRegimeSequence1Meta implements RosettaMetaData<ReportingRegimeSequence1> {

	@Override
	public List<Validator<? super ReportingRegimeSequence1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingRegimeSequence1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingRegimeSequence1> validator() {
		return new ReportingRegimeSequence1Validator();
	}

	@Override
	public Validator<? super ReportingRegimeSequence1> typeFormatValidator() {
		return new ReportingRegimeSequence1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegimeSequence1, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeSequence1OnlyExistsValidator();
	}
}
