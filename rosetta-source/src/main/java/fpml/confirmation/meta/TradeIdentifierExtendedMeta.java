package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeIdentifierExtended;
import fpml.confirmation.validation.TradeIdentifierExtendedTypeFormatValidator;
import fpml.confirmation.validation.TradeIdentifierExtendedValidator;
import fpml.confirmation.validation.exists.TradeIdentifierExtendedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeIdentifierExtended.class)
public class TradeIdentifierExtendedMeta implements RosettaMetaData<TradeIdentifierExtended> {

	@Override
	public List<Validator<? super TradeIdentifierExtended>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeIdentifier>create(fpml.confirmation.validation.datarule.TradeIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeIdentifierExtended, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeIdentifierExtended> validator() {
		return new TradeIdentifierExtendedValidator();
	}

	@Override
	public Validator<? super TradeIdentifierExtended> typeFormatValidator() {
		return new TradeIdentifierExtendedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeIdentifierExtended, Set<String>> onlyExistsValidator() {
		return new TradeIdentifierExtendedOnlyExistsValidator();
	}
}
