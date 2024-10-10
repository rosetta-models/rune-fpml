package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FloatingRateIndex;
import fpml.confirmation.validation.FloatingRateIndexTypeFormatValidator;
import fpml.confirmation.validation.FloatingRateIndexValidator;
import fpml.confirmation.validation.exists.FloatingRateIndexOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FloatingRateIndex.class)
public class FloatingRateIndexMeta implements RosettaMetaData<FloatingRateIndex> {

	@Override
	public List<Validator<? super FloatingRateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FloatingRateIndex> validator() {
		return new FloatingRateIndexValidator();
	}

	@Override
	public Validator<? super FloatingRateIndex> typeFormatValidator() {
		return new FloatingRateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndex, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexOnlyExistsValidator();
	}
}
