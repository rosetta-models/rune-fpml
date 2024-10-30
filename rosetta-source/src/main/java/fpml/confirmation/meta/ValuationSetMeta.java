package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ValuationSet;
import fpml.confirmation.validation.ValuationSetTypeFormatValidator;
import fpml.confirmation.validation.ValuationSetValidator;
import fpml.confirmation.validation.exists.ValuationSetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ValuationSet.class)
public class ValuationSetMeta implements RosettaMetaData<ValuationSet> {

	@Override
	public List<Validator<? super ValuationSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ValuationSet> validator() {
		return new ValuationSetValidator();
	}

	@Override
	public Validator<? super ValuationSet> typeFormatValidator() {
		return new ValuationSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationSet, Set<String>> onlyExistsValidator() {
		return new ValuationSetOnlyExistsValidator();
	}
}
