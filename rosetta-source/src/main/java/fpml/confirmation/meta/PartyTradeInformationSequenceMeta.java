package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyTradeInformationSequence;
import fpml.confirmation.validation.PartyTradeInformationSequenceTypeFormatValidator;
import fpml.confirmation.validation.PartyTradeInformationSequenceValidator;
import fpml.confirmation.validation.exists.PartyTradeInformationSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PartyTradeInformationSequence.class)
public class PartyTradeInformationSequenceMeta implements RosettaMetaData<PartyTradeInformationSequence> {

	@Override
	public List<Validator<? super PartyTradeInformationSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyTradeInformationSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyTradeInformationSequence> validator() {
		return new PartyTradeInformationSequenceValidator();
	}

	@Override
	public Validator<? super PartyTradeInformationSequence> typeFormatValidator() {
		return new PartyTradeInformationSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeInformationSequence, Set<String>> onlyExistsValidator() {
		return new PartyTradeInformationSequenceOnlyExistsValidator();
	}
}
