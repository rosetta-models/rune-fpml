package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.InstrumentSet;
import fpml.confirmation.validation.InstrumentSetTypeFormatValidator;
import fpml.confirmation.validation.InstrumentSetValidator;
import fpml.confirmation.validation.exists.InstrumentSetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=InstrumentSet.class)
public class InstrumentSetMeta implements RosettaMetaData<InstrumentSet> {

	@Override
	public List<Validator<? super InstrumentSet>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InstrumentSet, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super InstrumentSet> validator() {
		return new InstrumentSetValidator();
	}

	@Override
	public Validator<? super InstrumentSet> typeFormatValidator() {
		return new InstrumentSetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InstrumentSet, Set<String>> onlyExistsValidator() {
		return new InstrumentSetOnlyExistsValidator();
	}
}
