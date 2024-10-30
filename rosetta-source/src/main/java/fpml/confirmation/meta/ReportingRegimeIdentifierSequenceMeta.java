package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReportingRegimeIdentifierSequence;
import fpml.confirmation.validation.ReportingRegimeIdentifierSequenceTypeFormatValidator;
import fpml.confirmation.validation.ReportingRegimeIdentifierSequenceValidator;
import fpml.confirmation.validation.exists.ReportingRegimeIdentifierSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReportingRegimeIdentifierSequence.class)
public class ReportingRegimeIdentifierSequenceMeta implements RosettaMetaData<ReportingRegimeIdentifierSequence> {

	@Override
	public List<Validator<? super ReportingRegimeIdentifierSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportingRegimeIdentifierSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReportingRegimeIdentifierSequence> validator() {
		return new ReportingRegimeIdentifierSequenceValidator();
	}

	@Override
	public Validator<? super ReportingRegimeIdentifierSequence> typeFormatValidator() {
		return new ReportingRegimeIdentifierSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportingRegimeIdentifierSequence, Set<String>> onlyExistsValidator() {
		return new ReportingRegimeIdentifierSequenceOnlyExistsValidator();
	}
}
