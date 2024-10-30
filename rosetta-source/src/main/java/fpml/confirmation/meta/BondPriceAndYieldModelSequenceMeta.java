package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BondPriceAndYieldModelSequence;
import fpml.confirmation.validation.BondPriceAndYieldModelSequenceTypeFormatValidator;
import fpml.confirmation.validation.BondPriceAndYieldModelSequenceValidator;
import fpml.confirmation.validation.exists.BondPriceAndYieldModelSequenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BondPriceAndYieldModelSequence.class)
public class BondPriceAndYieldModelSequenceMeta implements RosettaMetaData<BondPriceAndYieldModelSequence> {

	@Override
	public List<Validator<? super BondPriceAndYieldModelSequence>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BondPriceAndYieldModelSequence, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BondPriceAndYieldModelSequence> validator() {
		return new BondPriceAndYieldModelSequenceValidator();
	}

	@Override
	public Validator<? super BondPriceAndYieldModelSequence> typeFormatValidator() {
		return new BondPriceAndYieldModelSequenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondPriceAndYieldModelSequence, Set<String>> onlyExistsValidator() {
		return new BondPriceAndYieldModelSequenceOnlyExistsValidator();
	}
}
