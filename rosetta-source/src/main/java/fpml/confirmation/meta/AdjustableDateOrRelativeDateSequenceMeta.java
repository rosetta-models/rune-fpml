package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDateOrRelativeDateSequence;
import fpml.confirmation.validation.AdjustableDateOrRelativeDateSequenceTypeFormatValidator;
import fpml.confirmation.validation.AdjustableDateOrRelativeDateSequenceValidator;
import fpml.confirmation.validation.exists.AdjustableDateOrRelativeDateSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AdjustableDateOrRelativeDateSequence.class)
public class AdjustableDateOrRelativeDateSequenceMeta implements RosettaMetaData<AdjustableDateOrRelativeDateSequence> {

	@Override
	public List<Validator<? super AdjustableDateOrRelativeDateSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AdjustableDateOrRelativeDateSequence>create(fpml.confirmation.validation.datarule.AdjustableDateOrRelativeDateSequenceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableDateOrRelativeDateSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableDateOrRelativeDateSequence> validator() {
		return new AdjustableDateOrRelativeDateSequenceValidator();
	}

	@Override
	public Validator<? super AdjustableDateOrRelativeDateSequence> typeFormatValidator() {
		return new AdjustableDateOrRelativeDateSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDateOrRelativeDateSequence, Set<String>> onlyExistsValidator() {
		return new AdjustableDateOrRelativeDateSequenceOnlyExistsValidator();
	}
}
