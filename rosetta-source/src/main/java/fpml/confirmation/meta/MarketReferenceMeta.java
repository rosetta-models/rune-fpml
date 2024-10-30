package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MarketReference;
import fpml.confirmation.validation.MarketReferenceTypeFormatValidator;
import fpml.confirmation.validation.MarketReferenceValidator;
import fpml.confirmation.validation.exists.MarketReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MarketReference.class)
public class MarketReferenceMeta implements RosettaMetaData<MarketReference> {

	@Override
	public List<Validator<? super MarketReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarketReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MarketReference> validator() {
		return new MarketReferenceValidator();
	}

	@Override
	public Validator<? super MarketReference> typeFormatValidator() {
		return new MarketReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarketReference, Set<String>> onlyExistsValidator() {
		return new MarketReferenceOnlyExistsValidator();
	}
}
