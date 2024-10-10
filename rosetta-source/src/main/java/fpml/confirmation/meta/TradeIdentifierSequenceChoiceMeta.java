package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeIdentifierSequenceChoice;
import fpml.confirmation.validation.TradeIdentifierSequenceChoiceTypeFormatValidator;
import fpml.confirmation.validation.TradeIdentifierSequenceChoiceValidator;
import fpml.confirmation.validation.exists.TradeIdentifierSequenceChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeIdentifierSequenceChoice.class)
public class TradeIdentifierSequenceChoiceMeta implements RosettaMetaData<TradeIdentifierSequenceChoice> {

	@Override
	public List<Validator<? super TradeIdentifierSequenceChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeIdentifierSequenceChoice>create(fpml.confirmation.validation.datarule.TradeIdentifierSequenceChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeIdentifierSequenceChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeIdentifierSequenceChoice> validator() {
		return new TradeIdentifierSequenceChoiceValidator();
	}

	@Override
	public Validator<? super TradeIdentifierSequenceChoice> typeFormatValidator() {
		return new TradeIdentifierSequenceChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeIdentifierSequenceChoice, Set<String>> onlyExistsValidator() {
		return new TradeIdentifierSequenceChoiceOnlyExistsValidator();
	}
}
